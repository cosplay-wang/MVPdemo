package demo.cosplay.com.mvpdemo.modelImpl;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import demo.cosplay.com.mvpdemo.bean.NewsBean;
import demo.cosplay.com.mvpdemo.model.NewsModel;
import demo.cosplay.com.mvpdemo.util.gson.JsonUtil;
import demo.cosplay.com.mvpdemo.util.http.HttpUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Response;

/**
 * Created by Hasee on 2017/9/10.
 */

public class NewsModelImpl implements NewsModel {
    public interface loadNewsListener {
        void loadSuccess(List<NewsBean> news);
        void loadFailure(String errorMsg, Exception e);
    }

    @Override
    public void loadNews(final String url, final loadNewsListener listener) {
        DisposableObserver<List<NewsBean>>  disposableObserver = new DisposableObserver<List<NewsBean>>() {
            @Override
            public void onNext(@NonNull List<NewsBean> newsBeanList) {
                listener.loadSuccess(newsBeanList);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                listener.loadFailure(e.getMessage(), (Exception) e);
            }

            @Override
            public void onComplete() {

            }
        };
        Observable<List<NewsBean>> observable = Observable.create(new ObservableOnSubscribe<List<NewsBean>>() {
            @Override
            public void subscribe(@NonNull final ObservableEmitter<List<NewsBean>> rx) throws Exception {
                HttpUtils.getRequest(url, new HttpUtils.HttpUtilCallBack() {
                    @Override
                    public void onSuccess(Response r) {
                        List<NewsBean> newsBeanList = null;
                        try {
                            JSONObject jsonObject = null;
                            jsonObject = new JSONObject(r.body().string());
                            Gson gson = new Gson();

                            newsBeanList = gson.fromJson(jsonObject.get("item").toString(),new TypeToken<List<NewsBean>>(){}.getType());

                      //      newsBeanList = JsonUtil.parseJsonArrayWithGson(jsonObject.get("item").toString(), NewsBean.class);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        rx.onNext(newsBeanList);
                    }

                    @Override
                    public void onFailture(Exception e) {
                        rx.onError(e);
                    }
                });
            }
        });
        observable.onTerminateDetach()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(disposableObserver);

    }
}

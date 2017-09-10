package demo.cosplay.com.mvpdemo.util.http;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Hasee on 2017/9/10.
 */

public class HttpUtils {
    private static HttpUtils mInstance = null;
    OkHttpClient okHttpClient = null;
    private synchronized static HttpUtils getInstance() {
        if (mInstance == null) {
            mInstance = new HttpUtils();
        }
        return mInstance;
    }

    public HttpUtils() {
        okHttpClient = new OkHttpClient.Builder()
                .build();
    }

    public static Response getRequest(String url, final HttpUtilCallBack callBack) {
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = getInstance().okHttpClient.newCall(request).execute();
            if(response.code() == 200){
                callBack.onSuccess(response);
            }
        } catch (IOException e) {
            callBack.onFailture(e);
            e.printStackTrace();
        }
        return null;
    }

    public interface HttpUtilCallBack {
        void onSuccess(Response r);
        void onFailture(Exception e);
    }
}

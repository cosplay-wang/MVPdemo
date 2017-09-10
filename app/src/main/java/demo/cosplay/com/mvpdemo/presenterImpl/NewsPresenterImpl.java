package demo.cosplay.com.mvpdemo.presenterImpl;

import java.util.List;

import demo.cosplay.com.mvpdemo.bean.NewsBean;
import demo.cosplay.com.mvpdemo.model.NewsModel;
import demo.cosplay.com.mvpdemo.modelImpl.NewsModelImpl;
import demo.cosplay.com.mvpdemo.presenter.NewsPresenter;
import demo.cosplay.com.mvpdemo.view.NewsView;

/**
 * Created by Hasee on 2017/9/10.
 */

public class NewsPresenterImpl implements NewsPresenter,NewsModelImpl.loadNewsListener{
    private NewsModel newsModel;
    private NewsView newsView;

    public NewsPresenterImpl(NewsView newsView) {
        newsModel = new NewsModelImpl();
        this.newsView = newsView;
    }

    @Override
    public void loadNews(String url) {
        newsModel.loadNews(url,this);
    }

    @Override
    public void loadSuccess(List<NewsBean> news) {
               newsView.loadSuccess(news);
    }

    @Override
    public void loadFailure(String errorMsg, Exception e) {
       newsView.loadFailture(errorMsg);
    }
}

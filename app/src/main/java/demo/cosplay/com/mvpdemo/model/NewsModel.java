package demo.cosplay.com.mvpdemo.model;

import demo.cosplay.com.mvpdemo.modelImpl.NewsModelImpl;

/**
 * Created by Hasee on 2017/9/10.
 */

public interface NewsModel {
    void loadNews(String url, NewsModelImpl.loadNewsListener listener);
}

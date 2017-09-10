package demo.cosplay.com.mvpdemo.view;

import java.util.List;

import demo.cosplay.com.mvpdemo.bean.NewsBean;

/**
 * Created by Hasee on 2017/9/10.
 */

public interface NewsView {
    void loadSuccess(List<NewsBean> newsBeanList);
    void loadFailture(String msg);
}

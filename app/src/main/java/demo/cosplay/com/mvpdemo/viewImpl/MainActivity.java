package demo.cosplay.com.mvpdemo.viewImpl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.cosplay.com.mvpdemo.Constants;
import demo.cosplay.com.mvpdemo.R;
import demo.cosplay.com.mvpdemo.adapter.NewsRecyclerviewAdapter;
import demo.cosplay.com.mvpdemo.bean.NewsBean;
import demo.cosplay.com.mvpdemo.presenterImpl.NewsPresenterImpl;
import demo.cosplay.com.mvpdemo.view.NewsView;

public class MainActivity extends AppCompatActivity implements NewsView {
    NewsPresenterImpl newsPresenter;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    NewsRecyclerviewAdapter newsRecyclerviewAdapter;
    List<NewsBean> newsBeanLists = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRecyclerView();
        newsPresenter = new NewsPresenterImpl(this);
        newsPresenter.loadNews(Constants.NEWSURL);
    }

    private void initRecyclerView() {
        newsRecyclerviewAdapter = new NewsRecyclerviewAdapter(this, newsBeanLists);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(newsRecyclerviewAdapter);
    }

    @Override
    public void loadSuccess(List<NewsBean> newsBeanList) {
        newsBeanLists.addAll(newsBeanList);
        newsRecyclerviewAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadFailture(String msg) {
        Toast.makeText(this, "出问题了：" + msg, Toast.LENGTH_LONG).show();
        ;
    }
}

package demo.cosplay.com.mvpdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.cosplay.com.mvpdemo.R;
import demo.cosplay.com.mvpdemo.bean.NewsBean;
import demo.cosplay.com.mvpdemo.util.gson.JsonUtil;

/**
 * Created by Hasee on 2017/9/10.
 */

public class NewsRecyclerviewAdapter extends RecyclerView.Adapter<NewsRecyclerviewAdapter.NewsViewHolder> {
    public class NewsViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.item_text)
        TextView textView;
        @BindView(R.id.item_image)
        ImageView imageView;
        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    Context context;
    List<NewsBean> newsBeanList;

    public NewsRecyclerviewAdapter(Context context, List<NewsBean> newsBeanList) {
        this.context = context;
        this.newsBeanList = newsBeanList;

    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_layout,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        Glide.with(context)
                .load(newsBeanList.get(position).getThumbnail())
                .into(holder.imageView);
        holder.textView.setText(newsBeanList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return newsBeanList == null?0:newsBeanList.size();
    }
}

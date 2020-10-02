package com.example.hp.xml;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends BaseAdapter{

    Context context;
    List<NewsItem> news;
    public NewsAdapter(Context context,List<NewsItem> news){
        this.context=context;
        this.news=news;
    }

    @Override
    public int getCount() {
        return news.size();
    }

    @Override
    public Object getItem(int i) {
        return news.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.news_item,null);
            ViewHolder vh= new ViewHolder();
            vh.dataTv= view.findViewById(R.id.textView2);
            vh.titelTv =view.findViewById(R.id.textView);
            vh.imgNews = view.findViewById(R.id.imageView);
            view.setTag(vh);

        }
        ViewHolder vh=(ViewHolder) view.getTag();
        vh.titelTv.setText(news.get(i).getTitle());
        vh.dataTv.setText(news.get(i).getPubdata());
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(vh.imgNews);

        return view;
    }
    class ViewHolder{
        ImageView imgNews;
        TextView titelTv;
        TextView dataTv;
    }

}

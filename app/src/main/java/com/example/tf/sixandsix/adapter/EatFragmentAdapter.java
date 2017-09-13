package com.example.tf.sixandsix.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tf.sixandsix.R;
import com.example.tf.sixandsix.bean.EatModel;

import java.util.List;

/**
 * Created by admin on 2017/9/8.
 */

public class EatFragmentAdapter extends RecyclerView.Adapter {
    private List<EatModel> list;
    private Context context;
    private IAdapterOnClick listener;

    public IAdapterOnClick getListener() {
        return listener;
    }

    public void setListener(IAdapterOnClick listener) {
        this.listener = listener;
    }

    public EatFragmentAdapter(List<EatModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name, content, agree, discuss, time;
        private ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_eat_fragment_name);
            content = itemView.findViewById(R.id.item_eat_fragment_content);
            agree = itemView.findViewById(R.id.item_eat_fragment_agree);
            discuss = itemView.findViewById(R.id.item_eat_fragment_discuss);
            time = itemView.findViewById(R.id.item_eat_fragment_time);
            iv = itemView.findViewById(R.id.item_eat_fragment_iv);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_eat_fragment_rv, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        v.setOnClickListener(view -> listener.setOnClickListener(view));
        v.setOnLongClickListener(view -> true);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder vh = (MyViewHolder) holder;
        vh.name.setText(list.get(position).getName());
        vh.content.setText(list.get(position).getContent());
        vh.agree.setText("同意" + list.get(position).getAgree() + " · ");
        vh.discuss.setText("评论" + list.get(position).getDiscuss() + " · ");
        vh.time.setText("时间" + list.get(position).getTime() + "  ");
        vh.itemView.setTag(position);
        Glide.with(context).load(list.get(position).getImage()).into(vh.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

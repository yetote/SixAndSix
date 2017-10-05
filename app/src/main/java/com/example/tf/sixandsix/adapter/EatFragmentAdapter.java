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
*EatFragmentAdapter 美食Adapter
*@author Swg
*@time 2017/9/28 11:01
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
        private TextView name, content, agree, discuss, time, title;
        private ImageView iv;

        public TextView getName() {
            return name;
        }

        public void setName(TextView name) {
            this.name = name;
        }

        public TextView getContent() {
            return content;
        }

        public void setContent(TextView content) {
            this.content = content;
        }

        public TextView getAgree() {
            return agree;
        }

        public void setAgree(TextView agree) {
            this.agree = agree;
        }

        public TextView getDiscuss() {
            return discuss;
        }

        public void setDiscuss(TextView discuss) {
            this.discuss = discuss;
        }

        public TextView getTime() {
            return time;
        }

        public void setTime(TextView time) {
            this.time = time;
        }

        public TextView getTitle() {
            return title;
        }

        public void setTitle(TextView title) {
            this.title = title;
        }

        public ImageView getIv() {
            return iv;
        }

        public void setIv(ImageView iv) {
            this.iv = iv;
        }

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_eat_fragment_name);
            content = itemView.findViewById(R.id.item_eat_fragment_content);
            agree = itemView.findViewById(R.id.item_eat_fragment_agree);
            discuss = itemView.findViewById(R.id.item_eat_fragment_discuss);
            time = itemView.findViewById(R.id.item_eat_fragment_time);
            iv = itemView.findViewById(R.id.item_eat_fragment_iv);
            title = itemView.findViewById(R.id.item_eat_fragment_title);
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
        vh.getName().setText(list.get(position).getName());
        vh.getContent().setText(list.get(position).getContent());
        vh.getAgree().setText("同意" + list.get(position).getAgree() + " · ");
        vh.getDiscuss().setText("评论" + list.get(position).getDiscuss() + " · ");
        vh.getTime().setText("时间" + list.get(position).getTime() + "  ");
        vh.getTitle().setText(list.get(position).getTitle());
        vh.itemView.setTag(list.get(position).getId());
        Glide.with(context).load(list.get(position).getImage()).into(vh.getIv());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

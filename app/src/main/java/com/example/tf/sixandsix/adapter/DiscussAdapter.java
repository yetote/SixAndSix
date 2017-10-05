package com.example.tf.sixandsix.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tf.sixandsix.R;
import com.example.tf.sixandsix.bean.DiscussModel;

import java.util.List;

/**
*DiscussAdapter 评论Adapter
*@author Swg
*@time 2017/9/28 11:04
*/

public class DiscussAdapter extends RecyclerView.Adapter {
    private List<DiscussModel> list;
    private Context context;
    private View v;
    private IAdapterOnClick listener;

    public IAdapterOnClick getListener() {
        return listener;
    }

    public void setListener(IAdapterOnClick listener) {
        this.listener = listener;
    }

    public DiscussAdapter(List<DiscussModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public List<DiscussModel> getList() {
        return list;
    }

    public void setList(List<DiscussModel> list) {
        this.list = list;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView name, content, time;
        private Button btn;

        public ImageView getIv() {
            return iv;
        }

        public void setIv(ImageView iv) {
            this.iv = iv;
        }

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

        public TextView getTime() {
            return time;
        }

        public void setTime(TextView time) {
            this.time = time;
        }

        public Button getBtn() {
            return btn;
        }

        public void setBtn(Button btn) {
            this.btn = btn;
        }

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.item_discuss_iv);
            name = itemView.findViewById(R.id.item_discuss_name);
            content = itemView.findViewById(R.id.item_discuss_connect);
            btn = itemView.findViewById(R.id.item_discuss_agree);
            time = itemView.findViewById(R.id.item_discuss_time);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(context).inflate(R.layout.item_discuss_activity, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        vh.getBtn().setOnClickListener(view -> {
            int number = list.get((Integer) view.getTag()).getNumber();
            Drawable dra;
            if (getAgree(view)) {
                dra = ContextCompat.getDrawable(context, R.mipmap.un_great);
                number -= 1;
                list.get((Integer) view.getTag()).setAgree(false);
            } else {
                dra = ContextCompat.getDrawable(context, R.mipmap.great);
                number += 1;
                list.get((Integer) view.getTag()).setAgree(true);
            }
            if (number != 0) vh.getBtn().setText(number + "");
            else vh.getBtn().setText("");

            list.get((Integer) view.getTag()).setNumber(number);
            dra.setBounds(0, 0, dra.getMinimumWidth(), dra.getMinimumHeight());
            vh.getBtn().setCompoundDrawables(dra, null, null, null);
        });
        return vh;
    }

    private boolean getAgree(View v) {
        return list.get((Integer) v.getTag()).getIsAgree();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder vh = (MyViewHolder) holder;
        vh.getContent().setText(list.get(position).getConnect());
        vh.getName().setText(list.get(position).getUsername());
        vh.getTime().setText(list.get(position).getTime());
        if (list.get(position).getNumber() != 0)
            vh.getBtn().setText(list.get(position).getNumber() + "");
        Glide.with(context).load(list.get(position).getImage()).into(vh.getIv());
        vh.getBtn().setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

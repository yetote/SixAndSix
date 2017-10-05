package com.example.tf.sixandsix.activity;
/**
*EatInformationActivity 美食详细信息界面
*@author Swg
*@time 2017/9/28 10:59
*/
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.tf.sixandsix.R;

public class EatInformationActivity extends AppCompatActivity {
    private static final String TAG = "EatInformationActivity";
    private TextView title, content;
    private ImageView iv;
    private CollapsingToolbarLayout cToolbarLayout;
    private AppBarLayout mAppbarLayout;
    private Toolbar toolbar;
    private Button agree, discuss, collect;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setEnterTransition(new Fade().setDuration(1000));
        getWindow().setExitTransition(new Fade().setDuration(1000));

        setContentView(R.layout.activity_eat_information);

        initViews();

        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        //接收数据
        receiveData();

        setClick();
    }

    private void setClick() {
        toolbar.setNavigationOnClickListener(view -> finish());
        agree.setOnClickListener(view -> {
            Drawable agreeDra = ContextCompat.getDrawable(EatInformationActivity.this, R.mipmap.love);
            agreeDra.setBounds(0, 0, agreeDra.getMinimumWidth(), agreeDra.getMinimumHeight());
            agree.setCompoundDrawables(null, agreeDra, null, null);
            agree.setText("已赞同");

        });
        discuss.setOnClickListener(view -> {
            Intent i = new Intent();
            i.putExtra("id", id);
            i.setClass(this, DiscussActivity.class);
            startActivity(i);
        });
        collect.setOnClickListener(view -> {
            Drawable collectDra = ContextCompat.getDrawable(EatInformationActivity.this, R.mipmap.collect);
            collectDra.setBounds(0, 0, collectDra.getIntrinsicWidth(), collectDra.getMinimumHeight());
            collect.setCompoundDrawables(null, collectDra, null, null);
            collect.setText("已收藏");
        });

    }

    private void receiveData() {
        Intent i = getIntent();
        String titleText = i.getStringExtra("title");
        String contentText = i.getStringExtra("content");
        id = i.getStringExtra("id");
        toolbar.setTitleTextColor(Color.WHITE);
        content.setText(contentText);
        toolbar.setTitle(titleText);
    }

    private void initViews() {
        toolbar = findViewById(R.id.eat_information_toolbar);
        content = findViewById(R.id.eat_information_content);
        mAppbarLayout = findViewById(R.id.eat_information_appbarLayout);
        discuss = findViewById(R.id.eat_information_discuss_btn);
        collect = findViewById(R.id.eat_information_collection_btn);
        agree = findViewById(R.id.eat_information_agree_btn);
    }
}

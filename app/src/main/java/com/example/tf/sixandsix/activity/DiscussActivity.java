package com.example.tf.sixandsix.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.tf.sixandsix.R;
import com.example.tf.sixandsix.adapter.DiscussAdapter;
import com.example.tf.sixandsix.adapter.IAdapterOnClick;
import com.example.tf.sixandsix.bean.DiscussModel;

import java.util.ArrayList;
import java.util.List;

public class DiscussActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView rv;
    private EditText et;
    private Button btn;
    private String id;
    private List<DiscussModel> list;
    private DiscussAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_discuss);

        initViews();

        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        receiveData();

        onClick();

    }

    private void receiveData() {
        Intent i = getIntent();
        id = i.getStringExtra("id");

        rv.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        list.add(new DiscussModel("a", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3371241652,3488766417&fm=27&gp=0.jpg", "a", "2017-9-23 16:01", false, 0));
        list.add(new DiscussModel("b", "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=99346450,2735367300&fm=27&gp=0.jpg", "afsafasb", "2017-9-23 16:01", false, 1));
        list.add(new DiscussModel("c", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506336644218&di=a6ebb4690ff005d5eb4f4a79b85f7bbe&imgtype=0&src=http%3A%2F%2Fpic32.nipic.com%2F20130831%2F2668693_013449688000_2.jpg", "safasfasfc", "2017-9-23 16:01", false, 10));
        list.add(new DiscussModel("d", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506336644218&di=162ae3babc2bab2ac77332389157715d&imgtype=0&src=http%3A%2F%2Fpic28.photophoto.cn%2F20130830%2F0005018308228731_b.jpg", "safasfasfd", "2017-9-23 16:01", false, 12));
        list.add(new DiscussModel("e", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506336644218&di=d8a2d1777c1de7d1da098194826b040f&imgtype=0&src=http%3A%2F%2Fpic28.photophoto.cn%2F20130924%2F0005018357660919_b.jpg", "dsdsfafsce", "2017-9-23 16:01", false, 1));
        list.add(new DiscussModel("f", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506931411&di=57629f6b9381d22a322fd0561549a5ec&imgtype=jpg&er=1&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fb812c8fcc3cec3fdee7e2462d588d43f87942760.jpg", "afsafxczf", "2017-9-23 16:01", false, 0));
        list.add(new DiscussModel("g", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3908650451,2873769403&fm=27&gp=0.jpg", "afasfsafefqg", "2017-9-23 16:01", false, 0));

        adapter = new DiscussAdapter(list, this);
        rv.setAdapter(adapter);
    }

    private void onClick() {
        toolbar.setNavigationOnClickListener(view -> finish());
        btn.setOnClickListener(view -> {
            if (isNull())
                Toast.makeText(this, "评论内容不能为空", Toast.LENGTH_SHORT).show();
            else {
                et.setText("");
                Toast.makeText(this, "评论成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isNull() {
        return et.getText() == null;
    }

    private void initViews() {
        toolbar = findViewById(R.id.discuss_toolbar);
        rv = findViewById(R.id.discuss_rv);
        et = findViewById(R.id.discuss_et);
        btn = findViewById(R.id.discuss_btn);
    }
}

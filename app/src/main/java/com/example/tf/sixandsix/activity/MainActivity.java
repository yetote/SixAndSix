package com.example.tf.sixandsix.activity;

import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toolbar;

import com.example.tf.sixandsix.R;
import com.example.tf.sixandsix.adapter.HomePagerViewPagerAdapter;
import com.example.tf.sixandsix.fragment.DrinkFragment;
import com.example.tf.sixandsix.fragment.EatFragment;
import com.example.tf.sixandsix.fragment.LaughFragment;
import com.example.tf.sixandsix.fragment.PlayFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] tabArr = new String[]{"吃", "喝", "玩", "乐"};
    private List<Fragment> fragmentList;
    private HomePagerViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_main);

        initViews();

        //给TabLayout添加标签
        tab();
        viewpager();
    }

    private void viewpager() {
        fragmentList.add(new EatFragment());
        fragmentList.add(new DrinkFragment());
        fragmentList.add(new PlayFragment());
        fragmentList.add(new LaughFragment());
        adapter = new HomePagerViewPagerAdapter(getFragmentManager(), fragmentList, this);

        //viewpager

        viewPager.setAdapter(adapter);

    }

    private void tab() {
        int i = 0;
        for (; i < tabArr.length; ) {
            tabLayout.addTab(tabLayout.newTab().setText(tabArr[i]));
            i++;
        }
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.lightseagreen));
        tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.white), ContextCompat.getColor(this, R.color.red));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.red));
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initViews() {
//        toolbar = findViewById(R.id.homepager_toolabr);
        tabLayout = findViewById(R.id.homepager_tab);
        viewPager = findViewById(R.id.homepager_vp);
        fragmentList = new ArrayList<>();

    }
}


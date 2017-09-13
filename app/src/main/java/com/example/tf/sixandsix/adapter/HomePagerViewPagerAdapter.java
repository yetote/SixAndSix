package com.example.tf.sixandsix.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by admin on 2017/9/8.
 */

public class HomePagerViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private Context context;
    private String[] titleArr = new String[]{"吃", "喝", "玩", "乐"};


    public HomePagerViewPagerAdapter(FragmentManager fm, List<Fragment> list, Context context) {
        super(fm);
        this.list = list;
        this.context = context;
    }

    public HomePagerViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleArr[position];
    }
}

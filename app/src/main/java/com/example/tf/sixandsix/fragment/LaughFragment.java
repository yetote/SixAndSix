package com.example.tf.sixandsix.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tf.sixandsix.R;
import com.example.tf.sixandsix.bean.EatModel;

/**
*LaughFragment 休闲fragment
*@author Swg
*@time 2017/9/28 11:03
*/

public class LaughFragment extends Fragment {
    private TextView tv;
    private String c = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_laugh, null, false);
        tv = v.findViewById(R.id.laugh_tv);
        return v;
    }
}

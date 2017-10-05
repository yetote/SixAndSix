package com.example.tf.sixandsix.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tf.sixandsix.R;

/**
 * DrinkFragment 饮品fragment
 *
 * @author Swg
 * @time 2017/9/28 11:02
 */
public class DrinkFragment extends Fragment {
    private int a=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_drink, null, false);

        //异常测试

        System.out.println(100/a);

        return v;
    }
}

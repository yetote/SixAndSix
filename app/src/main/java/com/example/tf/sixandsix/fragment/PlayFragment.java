package com.example.tf.sixandsix.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tf.sixandsix.R;

/**
*PlayFragment 游玩fragment
*@author Swg
*@time 2017/9/28 11:03
*/

public class PlayFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_play, null, false);
        return v;
    }
}

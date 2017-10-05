package com.example.tf.sixandsix;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.example.tf.sixandsix.utils.CrashHandler;

/**
 * com.example.tf.sixandsix
 *
 * @author Swg
 * @time 2017/9/29 16:55
 */
public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = this;
        CrashHandler.getInstance().init(this);
        if (checkPermission()) {
            ActivityCompat.requestPermissions();
        }
    }

    public static Context getContext() {
        return mContext;
    }


    /**
     * 检查权限
     * @return boolean值，默认为未授权即false
     */
    private boolean checkPermission() {
        return ContextCompat.checkSelfPermission(getContext(), Manifest.permission_group.STORAGE) != PackageManager.PERMISSION_DENIED;
    }

}

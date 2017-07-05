package com.bawei.lifeiyu1504d20170630.application;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * name ：李飞宇
 * Date: 2017/6/30
 * desc:
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}

package com.yummrolls.yumrolls.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by oust on 8/30/17.
 */

public class AppController extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        RealmHelper.setDefaultConfig(this);
    }

    public static SharedPreferences getSharedPreferences(String name) {
        return context.getSharedPreferences("yumRolls", Context.MODE_PRIVATE);
    }

}

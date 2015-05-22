package com.tonetag.firstrun;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Dev1 on 22/05/15.
 */
public class Controller extends Application {


    private Context mContext = null;
    public static final String SHARED_PREF_NAME = "active";

    private SharedPreferences mShreSharedPreferences = null;//getSharedPreferences(SHARED_PREF_NAME, mContext.MODE_PRIVATE);

    public SharedPreferences getmShreSharedPreferences() {
        return mShreSharedPreferences;
    }

    public void setmShreSharedPreferences(SharedPreferences mShreSharedPreferences) {
        this.mShreSharedPreferences = mShreSharedPreferences;
    }

}

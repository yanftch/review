package com.yanftch.review;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.example.mylibrary.util.LogUtils;
import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApp extends Application {
    private static final String TAG = "debug_MyApp";

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.e(TAG, "onActivityCreated: " + activity.getLocalClassName());
                LogUtils.e(activity.getLocalClassName());
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.e(TAG, "onActivityResumed: " + activity.getLocalClassName());
            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.e(TAG, "onActivityDestroyed: " + activity.getLocalClassName());
            }
        });
    }
}

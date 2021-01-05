package com.example.mylibrary.util;

import android.util.Log;

public class LogUtils {
    private static final String TAG = "debug_LogUtils";

    public static void e(String msg) {
        Log.e(TAG, "common_ " + msg);
    }
}

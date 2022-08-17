package com.yanftch.review.android.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.text.TextUtils;

/**
 * 剪贴板工具类
 */
public class ClipUtils {
    private static final int MAX_RETRY_TIME = 3;
    private static final int FIRST_TIME_DELAY = 20;// 首次等待20ms
    private static final int DELAY_TIME_ADD = 20; // 每次增加20ms

    static class GetFormAndroidQTask implements Runnable {
        private int retryTime = 0;
        private Handler mHandler;
        private Context mContext;
        private GetClipCallback mGetClipCallback;

        GetFormAndroidQTask(Context context, Handler handler, GetClipCallback getClipCallback) {
            mHandler = handler;
            mContext = context;
            mGetClipCallback = getClipCallback;
        }

        public void run() {
            ClipboardManager clipboardManager = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = clipboardManager != null ? clipboardManager.getPrimaryClip() : null;
            if (clipData != null) {
                String data = getData(clipboardManager, clipData);
                mGetClipCallback.execute(data);
                return;
            }
            retryTime++;
            if (retryTime < MAX_RETRY_TIME) {
                mHandler.postDelayed(this, FIRST_TIME_DELAY + retryTime * DELAY_TIME_ADD);
            }
        }
    }

    public static void getClipData(Context context, GetClipCallback clipCallback) {
        String data = null;
        try {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = clipboardManager != null ? clipboardManager.getPrimaryClip() : null;
                // 如果是android Q执行重试逻辑
                if (clipData == null && android.os.Build.VERSION.SDK_INT >= 29) {
                    Handler handler = new Handler(context.getMainLooper());
                    handler.postDelayed(new GetFormAndroidQTask(context, handler, clipCallback), FIRST_TIME_DELAY);
                    return;
                }
                data = getData(clipboardManager, clipData);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        clipCallback.execute(data);
    }

    private static String getData(ClipboardManager clipboardManager, ClipData clipData) {
        CharSequence data = null;
        if (clipData != null && clipData.getItemCount() > 0) {
            data = clipData.getItemAt(0).getText();
        }
        // 清空剪切板
        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, ""));
        return data != null ? data.toString() : null;
    }

    public interface GetClipCallback {
        void execute(String clipData);
    }


    /**
     * 复制文本到剪贴板
     */
    public static void copyText(Context context, String text) {
        if (TextUtils.isEmpty(text) || context == null) return;

        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboardManager == null) return;

        ClipData clipData = ClipData.newPlainText("ziroom", text);
        clipboardManager.setPrimaryClip(clipData);
    }

    /**
     * 清空剪贴板
     */
    public static void clearClipboard(Context context) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboardManager == null) return;
        boolean b = checkDefaultPackage(context);
        if (b) {
            ClipData clipData = ClipData.newPlainText(null, "");
            clipboardManager.setPrimaryClip(clipData);
        }
    }

    /**
     * 使用了getPackagesForUid返回的package[]数组的第0个package，比较这两个是否相同，所以尝试自己获取比较，
     * 如果第0个返回的不是com.ziroom.ziroomcustomer，则 return FALSE
     *
     * @return 是否需要显示Notification
     */
    private static boolean checkDefaultPackage(final Context context) {
        String pkgName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo ai = packageManager.getApplicationInfo(pkgName, PackageManager.GET_META_DATA);
            String[] packages = packageManager.getPackagesForUid(ai.uid);
            if (packages == null) return true;
            return TextUtils.equals(pkgName, packages[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}
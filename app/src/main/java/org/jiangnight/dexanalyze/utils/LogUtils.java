package org.jiangnight.dexanalyze.utils;

import android.util.Log;

public class LogUtils {
    private static final String TAG = "JiangNight";
    private static final boolean isDebug = true;

    public static void LOG(String msg){
        if (isDebug)
            Log.d(TAG,msg);
    }
}

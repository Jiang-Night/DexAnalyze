package org.jiangnight.dexanalyze.utils;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;

public class PermissionHelper  {

    private static boolean hasSavePermission(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        return i >= 30 ? Environment.isExternalStorageManager() : i < 23 || activity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == PackageManager.PERMISSION_GRANTED;
    }

    public static void checkPermission(Activity activity){
        int i = Build.VERSION.SDK_INT;
        if (hasSavePermission(activity)) {
            //已有权限
        } else if (i >= 30) {
            Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
            intent.setData(Uri.parse("package:" + activity.getPackageName()));
            activity.startActivityForResult(intent, 1);
        } else if (i >= 23) {
            activity.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

}
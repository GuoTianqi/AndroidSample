package com.daybreak.androidsample.utils;

import android.os.Build;

/**
 * Created by GuoTianqi on 2017/6/20.
 */

public class ApiUtils {
    public static boolean ge21() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return true;
        } else {
            return false;
        }
    }
}

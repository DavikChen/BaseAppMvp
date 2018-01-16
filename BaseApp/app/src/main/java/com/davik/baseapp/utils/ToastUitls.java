package com.davik.baseapp.utils;

import android.content.Context;
import android.widget.Toast;

import com.davik.baseapp.App;

/**
 * @name trunk
 * @class name：com.davik.baseapp.utils
 * @class describe Toast 工具类 使用的是应用上下文 可以防止同一时间弹出多个Toast的问题
 * @anthor davikchen
 * @time 2017/8/2 19:06
 */
public class ToastUitls {

    public static void show(int resId) {
        shortShow(App.getAppContext(), resId);
    }

    public static void show(String str) {
        if (null != str && str.length() > 0) {
            shortShow(App.getAppContext(), str);
        }
    }

    /**
     * 短提示 by resId
     *
     * @param context
     * @param resId
     */
    public static void shortShow(Context context, int resId) {
        showResId(context, resId, Toast.LENGTH_SHORT);
    }


    /**
     * 长提示 by resId
     *
     * @param context
     * @param resId
     */
    public static void longShow(Context context, int resId) {
        showResId(context, resId, Toast.LENGTH_LONG);
    }

    /**
     * 短提示 by String
     *
     * @param context
     * @param string
     */
    public static void shortShow(Context context, String string) {
        showString(context, string, Toast.LENGTH_SHORT);
    }

    /**
     * 常提示 by String
     *
     * @param context
     * @param string
     */
    public static void longShow(Context context, String string) {
        showString(context, string, Toast.LENGTH_LONG);
    }

    /**
     * 判断时间间隔提示Toast by String
     *
     * @param context
     * @param str      文字
     * @param showTime
     */
    private static void showString(Context context, String str, int showTime) {
        if (null != str && str.length() > 0) {
            MyToast.getToast(context, str, showTime).show();
        }

    }

    /**
     * 判断时间间隔提示Toast by resId
     *
     * @param context
     * @param resId
     * @param showTime
     */
    private static void showResId(Context context, int resId, int showTime) {
        MyToast.getToast(context, context.getString(resId), showTime).show();

    }

    /**
     * 自定义Toast类
     */
    static class MyToast {
        private static Context context = null;
        private static Toast toast = null;

        public static Toast getToast(Context context, String words, int showTime) {

            if (MyToast.context == context) {
                toast.setText(words);
                toast.setDuration(showTime);
            } else {
                MyToast.context = context;
                toast = Toast.makeText(context, words, showTime);
            }
            return toast;
        }
    }
}

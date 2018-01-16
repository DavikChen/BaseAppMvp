package com.davik.baseapp.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * @class describe 图片显示工具类
 * @anthor davikchen
 * @time 2017/11/21 09:28
 */
public class ImageUtil {

    public static void with(Context context, String imageUrl, ImageView imageView) {
        Glide.with(context).load(imageUrl).into(imageView);
    }
}

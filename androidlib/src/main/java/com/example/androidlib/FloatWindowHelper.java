package com.example.androidlib;

import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.WindowManager;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.view.WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
import static android.view.WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;

public class FloatWindowHelper {

    private static final String TAG = FloatWindowHelper.class.getSimpleName();

    private WindowManager mWindowManager = null;
    private WindowManager.LayoutParams params;

    /**
     * 需求系统app
     */
    private void initParams() {
        params = new WindowManager.LayoutParams();
        // 类型,如果只是设置成TYPE_SYSTEM_ALERT并不能覆盖status bar
        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        // 设置flag
        int flags = FLAG_LAYOUT_IN_SCREEN | FLAG_NOT_FOCUSABLE;
        params.flags = flags;
        // 不设置这个弹出框的透明遮罩显示为黑色
        params.format = PixelFormat.TRANSLUCENT;
        params.width = WRAP_CONTENT;
        params.height = WRAP_CONTENT;

        params.gravity = Gravity.TOP;
    }
}
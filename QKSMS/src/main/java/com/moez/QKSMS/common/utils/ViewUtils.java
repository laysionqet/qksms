package com.moez.QKSMS.common.utils;

import android.os.Build;
import android.view.View;
import android.view.Window;

public class ViewUtils {

    /**
     * Returns true if the given x,y coordinates falls within the view bounds.
     * @param view
     * @param x
     * @param y
     * @return
     */
    public static boolean isInBounds(View view, int x, int y) {

        int[] l = new int[2];
        view.getLocationOnScreen(l);
        int vx = l[0];
        int vy = l[1];
        int vw = view.getWidth();
        int vh = view.getHeight();

        return !(x < vx || x > vx + vw || y < vy || y > vy + vh);
    }

    public static void requestWindowLightStatusBar(Window window, final boolean enabled) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        if (null == window) {
            return;
        }
        final View decorView = window.getDecorView();
        final int visibility = decorView.getSystemUiVisibility();
        if (enabled) {
            decorView.setSystemUiVisibility(visibility | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            decorView.setSystemUiVisibility(visibility & (~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR));
        }
    }

}

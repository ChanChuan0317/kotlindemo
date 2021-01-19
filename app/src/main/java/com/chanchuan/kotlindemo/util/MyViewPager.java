package com.chanchuan.kotlindemo.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * @author : Chanchuan
 * Date       : 2021/1/7/007    上午 9:51
 */
public class MyViewPager extends ViewPager {

    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setPageTransformer(true, new DefaultTransformer());
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean b = super.onInterceptTouchEvent(swapEvent(ev));
        swapEvent(ev);
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    private MotionEvent swapEvent(MotionEvent pMotionEvent) {
        float width = getWidth();
        float height = getHeight();
        float swappedX = (pMotionEvent.getY() / height) * width;
        float swappedY = (pMotionEvent.getX() / width) * height;
        pMotionEvent.setLocation(swappedX, swappedY);
        return pMotionEvent;
    }

    class DefaultTransformer implements PageTransformer {
        public static final String TAG = "simple";

        @Override
        public void transformPage(@NonNull View page, float position) {
            float alpha = 0;
            if (position >= 0 && position <= 1) {
                alpha = 1 - position;
            } else if (position > -1 && position < 0) {
                alpha = position + 1;
            }
            page.setAlpha(alpha);
            float transX = page.getWidth() * -position;
            page.setTranslationX(transX);
            float transY = position * page.getHeight();
            page.setTranslationY(transY);
        }
    }
}

package com.afollestad.mvpanddaggerexample.androidviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * An actual View, not View from 'MVP'. The height always matches the width, which is used to provide
 * a consistent grid in this sample app.
 *
 * @author Aidan Follestad (afollestad)
 */
public class SquareImageView extends ImageView {

    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //noinspection SuspiciousNameCombination
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
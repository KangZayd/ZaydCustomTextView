package com.kangzayd.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Kang Zayd on 20/10/2016.
 */
public class CustomFontTextView extends TextView {

    public CustomFontTextView(Context context) {
        this(context, null);
    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = context.obtainStyledAttributes(attrs,
                R.styleable.ZaydTextView, 0, 0);
        String path_font = array.getString(R.styleable.ZaydTextView_fontPath);

        array.recycle();
        if (path_font != null) {
            setCustomTypeFace(context, path_font);
        } else {
            setCustomTypeFace(context, "fonts/Default.ttf");
        }
    }

    private void setCustomTypeFace(Context context, String path_font) {
        Typeface typeFaces = Typeface.createFromAsset(context.getAssets(), path_font);
        this.setTypeface(typeFaces);
    }
}

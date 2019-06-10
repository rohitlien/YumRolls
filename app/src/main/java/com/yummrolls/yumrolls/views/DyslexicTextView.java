package com.yummrolls.yumrolls.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by oust on 10/1/17.
 */

public class DyslexicTextView extends TextView {
    public DyslexicTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public DyslexicTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DyslexicTextView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        Typeface customFont = FontCache.getTypeface("OpenDyslexic-Regular.otf", context);
        setTypeface(customFont);
    }
}

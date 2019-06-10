package com.yummrolls.yumrolls.views;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class StradustFontTextView extends TextView {

    public StradustFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public StradustFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public StradustFontTextView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        Typeface customFont = FontCache.getTypeface("StardustAdventure.ttf", context);
        setTypeface(customFont);
    }

}

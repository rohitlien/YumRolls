package com.yummrolls.yumrolls.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

/**
 * Created by oust on 8/30/17.
 */

public class TapasEditText extends EditText {


    public TapasEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public TapasEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TapasEditText(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        Typeface customFont = FontCache.getTypeface("Tapas-Regular.otf", context);
        setTypeface(customFont);
    }
}

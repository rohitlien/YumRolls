package com.yummrolls.yumrolls.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by oust on 8/30/17.
 */

public class TapasRegularTextView extends TextView{

        public TapasRegularTextView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            init(context);
        }

        public TapasRegularTextView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context);
        }

        public TapasRegularTextView(Context context) {
            super(context);
            init(context);
        }

        private void init(Context context) {
            Typeface customFont = FontCache.getTypeface("Tapas-Regular.otf", context);
            setTypeface(customFont);
        }



}

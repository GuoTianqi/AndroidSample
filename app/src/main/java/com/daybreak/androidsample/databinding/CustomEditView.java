package com.daybreak.androidsample.databinding;

import android.content.Context;
import androidx.appcompat.widget.AppCompatEditText;

import android.util.AttributeSet;

public class CustomEditView extends AppCompatEditText {
    public CustomEditView(Context context) {
        super(context);
    }

    public CustomEditView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomEditView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private CharSequence mCustomText = "";

    public CharSequence getCustomText() {
        return mCustomText;
    }

    public void setCustomText(CharSequence customText) {
        mCustomText = customText != null ? customText : "";
        setText(mCustomText);
    }
}

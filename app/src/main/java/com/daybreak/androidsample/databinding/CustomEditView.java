package com.daybreak.androidsample.databinding;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.format.Time;
import android.util.AttributeSet;

import org.w3c.dom.Text;

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

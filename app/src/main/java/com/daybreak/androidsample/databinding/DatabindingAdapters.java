package com.daybreak.androidsample.databinding;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.adapters.ListenerUtil;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.format.Time;
import android.util.Log;

import com.daybreak.androidsample.R;

public class DatabindingAdapters {
    @BindingAdapter("customText")
    public static void setCustomText(CustomEditView editView, CharSequence text) {
        Log.e("XXX", "setCustomText: " + editView.getCustomText().toString());
        final CharSequence oldText = editView.getCustomText();
        if (text == oldText || (text == null && oldText.length() == 0)) {
            return;
        }

        if (text instanceof Spanned) {
            if (text.equals(oldText)) {
                return;
            }
        } else if (!haveContentsChanged(text, oldText)) {
            return;
        }

        editView.setCustomText(text);
    }

    @InverseBindingAdapter(attribute = "customText", event = "customTextAttrChanged")
    public static CharSequence getCustomText(CustomEditView editView) {
        Log.e("XXX", "getCustomText:" + editView.getCustomText().toString());
        return editView.getCustomText();
    }

    @BindingAdapter("customTextAttrChanged")
    public static void setListeners(final CustomEditView editView, final InverseBindingListener
            attrChange) {
        Log.e("XXX", "setListeners");
        final TextWatcher newValue;
        if (attrChange == null) {
            newValue = null;
        } else {
            newValue = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    attrChange.onChange();
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            };
        }

        final TextWatcher oldValue = ListenerUtil.trackListener(editView, newValue, R.id.textWatcher);
        if (oldValue != null) {
            editView.removeTextChangedListener(oldValue);
        }

        if (newValue != null) {
            editView.addTextChangedListener(newValue);
        }
    }

    private static boolean haveContentsChanged(CharSequence str1, CharSequence str2) {
        if ((str1 == null) != (str2 == null)) {
            return true;
        } else if (str1 == null) {
            return false;
        }
        final int length = str1.length();
        if (length != str2.length()) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}

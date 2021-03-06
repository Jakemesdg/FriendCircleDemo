package com.share.jack.cygtool.util;

import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 *
 */
public class CygStringUtil {

    public static final String EMPTY_CONTENT = "";

    public CygStringUtil() {
    }

    public static String getEditTextContent(Object object) {
        if (object instanceof TextView) {
            return ((TextView) object).getText().toString();
        }
        return EMPTY_CONTENT;
    }

    public static boolean isEmpty(@Nullable String string) {
        return string == null || string.isEmpty();
    }
}
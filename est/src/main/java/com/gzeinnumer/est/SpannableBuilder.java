package com.gzeinnumer.est;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.TypedValue;

import java.util.ArrayList;

public class SpannableBuilder {

    private final ArrayList<SpannableModel> data = new ArrayList<SpannableModel>();
    private final Context context;
    private SpannableCallBack spannableCallBack;

    public SpannableBuilder(Context context) {
        this.context = context;
    }

    public SpannableBuilder text(int type, String str) {
        addString(str, type, -1, -1, spannableCallBack);
        return this;
    }

    public SpannableBuilder textColor(int type, String str, int color) {
        addString(str, type, -1, color, spannableCallBack);
        return this;
    }

    public SpannableBuilder textSize(int type, String str, int size) {
        addString(str, type, size, -1, spannableCallBack);
        return this;
    }

    public SpannableBuilder textSizeColor(int type, String str, int size, int color) {
        addString(str, type, size, color, spannableCallBack);
        return this;
    }

    public SpannableBuilder text(int type, String str, SpannableCallBack spannableCallBack) {
        addString(str, type,-1, -1, spannableCallBack);
        return this;
    }

    public SpannableBuilder textColor(int type, String str, int color, SpannableCallBack spannableCallBack) {
        addString(str, type, -1, color, spannableCallBack);
        return this;
    }

    public SpannableBuilder textSize(int type, String str, int size, SpannableCallBack spannableCallBack) {
        addString(str, type, size, -1, spannableCallBack);
        return this;
    }

    public SpannableBuilder textSizeColor(int type, String str, int size, int color, SpannableCallBack spannableCallBack) {
        addString(str, type, size, color, spannableCallBack);
        return this;
    }

    private void addString(String str, int typeStyle, int size, int color, SpannableCallBack spannableCallBack) {
        SpannableModel spannableModel = new SpannableModel();
        spannableModel.setString(str);
        spannableModel.setTypeStyle(typeStyle);
        spannableModel.setSize(getValueInDP(context, size));
        spannableModel.setColor(color);
        spannableModel.setSpannableCallBack(spannableCallBack);
        data.add(spannableModel);
    }

    private int getValueInDP(Context context, int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }

    private CharSequence getFinalValue() {
        SpannableStringBuilder longDescription = new SpannableStringBuilder();
        for (int i = 0; i < data.size(); i++) {
            SpannableModel d = data.get(i);
            int start = longDescription.length();
            longDescription.append(d.string);
            longDescription.setSpan(new StyleSpan(d.typeStyle), start, longDescription.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            if (d.color != -1)
                longDescription.setSpan(new ForegroundColorSpan(d.color), start, longDescription.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            if (d.size != -1)
                longDescription.setSpan(new AbsoluteSizeSpan(d.size), start, longDescription.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            if (d.spannableCallBack != null)
                longDescription.setSpan(new SpannableClickableSpan(i + 1, d.spannableCallBack), start, longDescription.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return longDescription;
    }

    public CharSequence build() {
        return getFinalValue();
    }
}

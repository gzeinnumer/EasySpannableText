package com.gzeinnumer.est;

public class SpannableModel {
    String string;
    int typeStyle;
    int color = -1;
    int size = -1;
    SpannableCallBack spannableCallBack;

    public SpannableModel() {
    }

    public void setString(String string) {
        this.string = string;
    }

    public void setTypeStyle(int typeStyle) {
        this.typeStyle = typeStyle;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSpannableCallBack(SpannableCallBack spannableCallBack) {
        this.spannableCallBack = spannableCallBack;
    }
}

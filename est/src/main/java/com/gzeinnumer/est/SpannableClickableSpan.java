package com.gzeinnumer.est;

import android.text.style.ClickableSpan;
import android.view.View;

public class SpannableClickableSpan extends ClickableSpan {

    int pos;
    SpannableCallBack spannableCallBack;
    public SpannableClickableSpan(int position, SpannableCallBack spannableCallBack){
        this.pos=position;
        this.spannableCallBack = spannableCallBack;
    }

    @Override
    public void onClick(View widget) {
        if (spannableCallBack !=null) spannableCallBack.onClick();
    }

}
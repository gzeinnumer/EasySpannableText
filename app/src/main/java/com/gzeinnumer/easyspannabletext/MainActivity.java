package com.gzeinnumer.easyspannabletext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.gzeinnumer.est.SpannableBuilder;
import com.gzeinnumer.est.SpannableCallBack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        noOnClick();
        withOnClick();
    }

    private void noOnClick() {
        TextView textView = findViewById(R.id.tv);

        int size = 2;
        int color = ContextCompat.getColor(this, R.color.purple_500);

        CharSequence sequence = new SpannableBuilder()
                .text(Typeface.NORMAL,"text\n")
                .textColor(Typeface.BOLD,"textColor\n",color)
                .textSize(Typeface.ITALIC,"textSize\n",size)
                .textSizeColor(Typeface.BOLD_ITALIC,"textSizeColor\n",size, color)
                .build();
        textView.setText(sequence);
//        textView.setText(sequence, TextView.BufferType.SPANNABLE);
    }

    private void withOnClick() {
        TextView textView = findViewById(R.id.tv);

        int size = 2;
        int color = ContextCompat.getColor(this, R.color.purple_500);

        CharSequence sequence = new SpannableBuilder()
                .text(Typeface.NORMAL,"text\n", new SpannableCallBack() {
                    @Override
                    public void onClick() {
                        Toast toast = Toast.makeText(MainActivity.this, "Tekan 1", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP, 0, 0);
                        toast.show();
                    }
                })
                .textColor(Typeface.BOLD,"textColor\n",color, new SpannableCallBack() {
                    @Override
                    public void onClick() {
                        Toast toast = Toast.makeText(MainActivity.this, "Tekan 2", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.LEFT, 0, 0);
                        toast.show();
                    }
                })
                .textSize(Typeface.ITALIC,"textSize\n",size, new SpannableCallBack() {
                    @Override
                    public void onClick() {
                        Toast toast = Toast.makeText(MainActivity.this, "Tekan 3", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.BOTTOM, 0, 0);
                        toast.show();
                    }
                })
                .textSizeColor(Typeface.BOLD_ITALIC,"textSizeColor\n",size, color, new SpannableCallBack() {
                    @Override
                    public void onClick() {
                        Toast toast = Toast.makeText(MainActivity.this, "Tekan 4", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.RIGHT, 0, 0);
                        toast.show();
                    }
                })
                .build();
        textView.setText(sequence);
//        textView.setText(sequence, TextView.BufferType.SPANNABLE);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
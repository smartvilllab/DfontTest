package com.example.dfondtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button BtnDefault;
    Button BtnFontSizeUp;
    Button BtnFontSizeDown;
    Button BtnInput;
    TextView TvFontSystem;
    TextView TvFontDiolEB;
    TextView TvFontDiolB;
    TextView TvFontDiolR;
    EditText EtInput;

    String mDefaultText = "ㅋㅋㅋ다람쥐 헌 쳇바퀴에 타고파 1234567890 ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz !?@*";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_default).setOnClickListener(this);
        findViewById(R.id.button_input).setOnClickListener(this);
        findViewById(R.id.button_size_up).setOnClickListener(this);
        findViewById(R.id.button_size_down).setOnClickListener(this);

        TvFontSystem = (TextView)findViewById(R.id.textView_font_system);
        TvFontDiolEB = (TextView)findViewById(R.id.textView_font_diol_eb);
        TvFontDiolB = (TextView)findViewById(R.id.textView_font_diol_b);
        TvFontDiolR = (TextView)findViewById(R.id.textView_font_diol_r);

        TvFontSystem.setText(mDefaultText);
        TvFontDiolEB.setText(mDefaultText);
        TvFontDiolB.setText(mDefaultText);
        TvFontDiolR.setText(mDefaultText);

        EtInput = (EditText)findViewById(R.id.editText_input);
        // test
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button_default:
                TvFontSystem.setText(mDefaultText);
                TvFontDiolEB.setText(mDefaultText);
                TvFontDiolB.setText(mDefaultText);
                TvFontDiolR.setText(mDefaultText);

                TvFontSystem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                TvFontDiolEB.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
                TvFontDiolB.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                TvFontDiolR.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);

                EtInput.setText("");
                break;
            case R.id.button_input:
                TvFontSystem.setText(EtInput.getText());
                TvFontDiolEB.setText(EtInput.getText());
                TvFontDiolB.setText(EtInput.getText());
                TvFontDiolR.setText(EtInput.getText());
                EtInput.setText("");
                View view = this.getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                break;
            case R.id.button_size_up:
                float currentSize = TvFontSystem.getTextSize();
                currentSize = currentSize / Resources.getSystem().getDisplayMetrics().density;
                //Toast.makeText(this,"size = "+currentSize,Toast.LENGTH_LONG).show();
                if (currentSize < 50){
                    TvFontSystem.setTextSize(TypedValue.COMPLEX_UNIT_SP,(float)(currentSize*1.2));
                    TvFontDiolEB.setTextSize(TypedValue.COMPLEX_UNIT_SP, (float)(currentSize*1.2));
                    TvFontDiolB.setTextSize(TypedValue.COMPLEX_UNIT_SP, (float)(currentSize*1.2));
                    TvFontDiolR.setTextSize(TypedValue.COMPLEX_UNIT_SP, (float)(currentSize*1.2));
                }
                EtInput.setText("");
                break;
            case R.id.button_size_down:
                currentSize = TvFontSystem.getTextSize();
                currentSize = currentSize / Resources.getSystem().getDisplayMetrics().density;
                //Toast.makeText(this,"size = "+currentSize,Toast.LENGTH_LONG).show();
                if (currentSize > 10){
                    TvFontSystem.setTextSize(TypedValue.COMPLEX_UNIT_SP, (float)(currentSize*0.8));
                    TvFontDiolEB.setTextSize(TypedValue.COMPLEX_UNIT_SP, (float)(currentSize*0.8));
                    TvFontDiolB.setTextSize(TypedValue.COMPLEX_UNIT_SP, (float)(currentSize*0.8));
                    TvFontDiolR.setTextSize(TypedValue.COMPLEX_UNIT_SP, (float)(currentSize*0.8));
                }
                EtInput.setText("");
                break;
        }
    }
}

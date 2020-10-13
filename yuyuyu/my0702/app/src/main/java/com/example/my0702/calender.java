package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.os.Bundle;

public class calender extends AppCompatActivity {
    private TextView TextView1,TextView2;
    private TextView t1,t2,t3;
    private EditText mmm1,mmm2,mmm3,mmm4;
    private Button btn0000,btn1111;
    private ImageButton imageButton;
    private Switch sw1;
    private String aa;
    int oldVaue;
    private RadioButton
            mRadioButton1,
            mRadioButton2,
            mRadioButton3,
            mRadioButton4,
            mRadioButton5,
            mRadioButton6,
            mRadioButton7;
    String ad,ae;
    private EditText diary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender);
        //取得傳遞過來的資料
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("account");
        TextView1 = findViewById(R.id.n1);
        TextView1.setText(loginname);
        btn0000 = findViewById(R.id.btn17);
        btn1111 = findViewById(R.id.game_next_button);
        btn0000.setOnClickListener(buttonback);
        btn1111.setOnClickListener(btnAdd1OnClick123456);
        mRadioButton1 = findViewById(R.id.radioButton13);
        mRadioButton2 = findViewById(R.id.radioButton12);
        mRadioButton3 = findViewById(R.id.radioButton11);
        mRadioButton4 = findViewById(R.id.radioButton15);
        mRadioButton5 = findViewById(R.id.radioButton17);
        mRadioButton6 = findViewById(R.id.radioButton14);
        mRadioButton7 = findViewById(R.id.radioButton16);
        TextView2 = findViewById(R.id.text_to_change);
        changeTextViewValueRandomlyOnButtonClick();

    }
    private void changeTextViewValueRandomlyOnButtonClick() {
        final String[] manyDifferentStrings = {"今天在家裡，", "我喜歡", "最快樂的時候，我會", "我想知道","我最大的恐懼是","每一個媽媽","我覺得","運動","別的小孩","我沒有能","和女生在一起時",
                "將來的日子","我需要","我最棒的時候","使我痛苦的是","在學校裡","唯一的困難","我希望","我的爸爸","我的媽媽","我秘密地","跳舞","多數女孩子","我想成為一個","和男生在一起時","和女生在一起時","這個測驗"};

        final TextView changingText = (TextView) findViewById(R.id.text_to_change);
        Button changeTextButton = (Button) findViewById(R.id.change_text_button);

        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random = (int) (Math.random() * manyDifferentStrings.length);
                if (random == oldVaue) {
                    random = (int) (Math.random() * manyDifferentStrings.length);
                }
                changingText.setText(manyDifferentStrings[random]);
                oldVaue = random;
            }
        });
    }
    private View.OnClickListener btnAdd1OnClick123456 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (mRadioButton1.isChecked()) {
                ad = "家人";
            } else if(mRadioButton2.isChecked()) {
                ad = "同學/朋友";
            } else if(mRadioButton3.isChecked()) {
                ad = "老師";
            }



            if(mRadioButton4.isChecked()) {
                ae = "早上";
            } else if(mRadioButton5.isChecked()) {
                ae = "中午";
            } else if(mRadioButton6.isChecked()) {
                ae = "下午";
            } else if(mRadioButton7.isChecked()) {
                ae = "晚上";
            }
            //String result1 = MainActivityloginSQL.executeQuery1(" UPDATE preference SET `sportplace`='\"+a1+\"',`slimming` = '\"+a3+\"',`fitness` = '\"+a4+\"',`shaping` = '\"+a5+\"', strengthen = '\"+a6+\"',`foodplace` = '\"+a2+\"' WHERE account = '\"+mn5.getText().toString()+\"'");
            String result1 = MainActivityloginSQL.executeQuery1("UPDATE calender SET `person`='"+ad+"' WHERE id = '"+TextView1.getText().toString()+"'");
            String result2 = MainActivityloginSQL.executeQuery1("UPDATE calender SET `time`='"+ae+"' WHERE id = '"+TextView1.getText().toString()+"'");
            String result3 = MainActivityloginSQL.executeQuery1("UPDATE calender SET `diary`='"+TextView2.getText().toString()+"' WHERE id = '"+TextView1.getText().toString()+"'");
            Intent intent = new Intent(calender.this, MainActivity.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }
    };
    private View.OnClickListener buttonback= new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent(calender.this, calender_mood.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }

    };
}

package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class imood4 extends AppCompatActivity {
    private TextView TextView1;
    private RadioButton
            mRadioButton1,
            mRadioButton2,
            mRadioButton3,
            mRadioButton4,
            mRadioButton5,
            mRadioButton6,
            mRadioButton7;
    String a4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood4);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("account");
        TextView1 = findViewById(R.id.n1);
        TextView1.setText(loginname);
        Button back4 = findViewById(R.id.mood4_back_button);
        Button next4 = findViewById(R.id.mood4_next_button);
        back4.setOnClickListener(btnAdd1OnClickback4);
        next4.setOnClickListener(btnAdd1OnClicknext4);
        mRadioButton1 = findViewById(R.id.four_button01);
        mRadioButton2 = findViewById(R.id.four_button02);
        mRadioButton3 = findViewById(R.id.four_button03);
        mRadioButton4 = findViewById(R.id.four_button04);
        mRadioButton5 = findViewById(R.id.four_button05);
        mRadioButton6 = findViewById(R.id.four_button06);
        mRadioButton7 = findViewById(R.id.four_button07);

    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.mood4);
//        Button nextPageBtn = (Button)findViewById(R.id.button);
//        nextPageBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(imood4.this , imood5.class);
//
//                startActivity(intent);
//            }
//        });
//
//    }

    private View.OnClickListener btnAdd1OnClickback4 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(imood4.this, imood3.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);
        }
    };
    private View.OnClickListener btnAdd1OnClicknext4 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mRadioButton1.isChecked()) {
                a4 = "1 怒氣沖沖失去理智";
            } else if(mRadioButton2.isChecked()) {
                a4 = "2 憤怒發脾氣";
            } else if(mRadioButton3.isChecked()) {
                a4 = "3 不高興";
            } else if(mRadioButton4.isChecked()) {
                a4 = "4 平靜";
            } else if(mRadioButton5.isChecked()) {
                a4 = "5 開心";
            } else if(mRadioButton6.isChecked()) {
                a4 = "6 興奮";
            } else if(mRadioButton7.isChecked()) {
                a4 = "7 非常快樂";
            }
            //String result1 = MainActivityloginSQL.executeQuery1(" UPDATE preference SET `sportplace`='\"+a1+\"',`slimming` = '\"+a3+\"',`fitness` = '\"+a4+\"',`shaping` = '\"+a5+\"', strengthen = '\"+a6+\"',`foodplace` = '\"+a2+\"' WHERE account = '\"+mn5.getText().toString()+\"'");
            String result1 = MainActivityloginSQL.executeQuery1("UPDATE imood SET `imood4`='"+a4+"' WHERE id = '"+TextView1.getText().toString()+"'");
            Intent intent = new Intent(imood4.this, imood5.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);
        }
    };
}
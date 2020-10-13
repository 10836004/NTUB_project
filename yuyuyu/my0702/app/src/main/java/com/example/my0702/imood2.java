package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class imood2 extends AppCompatActivity {

    final Context context = this;
    private Button button1234,button01234;
    private RadioButton radioButton;
    private ImageButton imageButton;
    private Boolean f_jumptolayout03 = false;
    private Integer layout_choice = 0;
    private TextView TextView1;
    private RadioButton
            mRadioButton1,
            mRadioButton2,
            mRadioButton3,
            mRadioButton4,
            mRadioButton5,
            mRadioButton6,
            mRadioButton7;
    String a2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood2);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("account");
        TextView1 = findViewById(R.id.n1);
        TextView1.setText(loginname);
        Button back2 = findViewById(R.id.mood2_back_button);
        Button next2 = findViewById(R.id.mood2_next_button);
        back2.setOnClickListener(btnAdd1OnClickback2);
        next2.setOnClickListener(btnAdd1OnClicknext2);
        mRadioButton1 = findViewById(R.id.two_button01);
        mRadioButton2 = findViewById(R.id.two_button02);
        mRadioButton3 = findViewById(R.id.two_button03);
        mRadioButton4 = findViewById(R.id.two_button04);
        mRadioButton5 = findViewById(R.id.two_button05);
        mRadioButton6 = findViewById(R.id.two_button06);
        mRadioButton7 = findViewById(R.id.two_button07);
    }
    private View.OnClickListener btnAdd1OnClickback2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(imood2.this, i_mood.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);
        }
    };
    private View.OnClickListener btnAdd1OnClicknext2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mRadioButton1.isChecked()) {
                a2 = "1 怒氣沖沖失去理智";
            } else if(mRadioButton2.isChecked()) {
                a2 = "2 憤怒發脾氣";
            } else if(mRadioButton3.isChecked()) {
                a2 = "3 不高興";
            } else if(mRadioButton4.isChecked()) {
                a2 = "4 平靜";
            } else if(mRadioButton5.isChecked()) {
                a2 = "5 開心";
            } else if(mRadioButton6.isChecked()) {
                a2 = "6 興奮";
            } else if(mRadioButton7.isChecked()) {
                a2 = "7 非常快樂";
            }
            //String result1 = MainActivityloginSQL.executeQuery1(" UPDATE preference SET `sportplace`='\"+a1+\"',`slimming` = '\"+a3+\"',`fitness` = '\"+a4+\"',`shaping` = '\"+a5+\"', strengthen = '\"+a6+\"',`foodplace` = '\"+a2+\"' WHERE account = '\"+mn5.getText().toString()+\"'");
            String result1 = MainActivityloginSQL.executeQuery1("UPDATE imood SET `imood2`='"+a2+"' WHERE id = '"+TextView1.getText().toString()+"'");
            Intent intent = new Intent(imood2.this, imood3.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);
        }
    };

}
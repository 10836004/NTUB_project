package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class imood3 extends AppCompatActivity {
    private TextView TextView1;
    private RadioButton
            mRadioButton1,
            mRadioButton2,
            mRadioButton3,
            mRadioButton4;
    String a3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood3);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("account");
        TextView1 = findViewById(R.id.n1);
        TextView1.setText(loginname);
        Button back3 = findViewById(R.id.mood3_back_button);
        Button next3 = findViewById(R.id.mood3_next_button);
        back3.setOnClickListener(btnAdd1OnClickback3);
        next3.setOnClickListener(btnAdd1OnClicknext3);
        mRadioButton1 = findViewById(R.id.three_button01);
        mRadioButton2 = findViewById(R.id.three_button02);
        mRadioButton3 = findViewById(R.id.three_button03);
        mRadioButton4 = findViewById(R.id.three_button04);
    }

    private View.OnClickListener btnAdd1OnClickback3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(imood3.this, imood2.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);
        }
    };
    private View.OnClickListener btnAdd1OnClicknext3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mRadioButton1.isChecked()) {
                a3 = "1 遇到別人讓我很生氣，我會告訴自己不要理他們就好了";
            } else if(mRadioButton2.isChecked()) {
                a3 = "2 我會把這件開心的事情和朋友分享，記住這件開心的事情。";
            } else if(mRadioButton3.isChecked()) {
                a3 = "3 我會找有趣的事情去做，讓自己的心情更好一點。";
            } else if(mRadioButton4.isChecked()) {
                a3 = "4 我會自己找一個安靜的地方，自己一個人安靜地玩。";
            }
            //String result1 = MainActivityloginSQL.executeQuery1(" UPDATE preference SET `sportplace`='\"+a1+\"',`slimming` = '\"+a3+\"',`fitness` = '\"+a4+\"',`shaping` = '\"+a5+\"', strengthen = '\"+a6+\"',`foodplace` = '\"+a2+\"' WHERE account = '\"+mn5.getText().toString()+\"'");
            String result1 = MainActivityloginSQL.executeQuery1("UPDATE imood SET `imood3`='"+a3+"' WHERE id = '"+TextView1.getText().toString()+"'");
            Intent intent = new Intent(imood3.this, imood4.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);
        }
    };
}



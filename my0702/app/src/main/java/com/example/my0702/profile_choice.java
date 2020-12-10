package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class profile_choice extends AppCompatActivity {
    private ImageButton imageButton,imageButton2,imageButton3;
    private TextView TextView1;
    private Button btnhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_choice);
        //取得傳遞過來的資料
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("account");
        TextView1 = findViewById(R.id.n1);
        TextView1.setText(loginname);
        imageButton= findViewById(R.id.profile1);
        imageButton.setOnClickListener(buttonprofile);
        imageButton2= findViewById(R.id.profile2);
        imageButton2.setOnClickListener(buttonchart);
        imageButton3= findViewById(R.id.profile3);
        imageButton3.setOnClickListener(buttondiary);
        btnhome= findViewById(R.id.home);
        btnhome.setOnClickListener(buttonhome);
    }
    private View.OnClickListener buttonprofile= new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent(profile_choice.this, profile2.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }



    };
    private View.OnClickListener buttonchart= new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent(profile_choice.this, imooddd.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }

    };
    private View.OnClickListener buttondiary= new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent(profile_choice.this, updatedd.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }

    };
    private View.OnClickListener buttonhome= new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent(profile_choice.this, MainActivity.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }

    };
}
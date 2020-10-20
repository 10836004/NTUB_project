package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class game_choice extends AppCompatActivity {
    private TextView TextView1;
    private TextView t1,t2,t3;
    private EditText mmm1,mmm2,mmm3,mmm4;
    private Button btn1;
    private ImageButton imageButton,imageButton1;
    private Switch sw1;
    private String aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_choice);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("account");
        TextView1 = findViewById(R.id.n1);
        TextView1.setText(loginname);
        btn1 = findViewById(R.id.home);
        btn1.setOnClickListener(buttonhome);
        ImageButton imageButton = findViewById(R.id.puzzle_game_button);
        imageButton.setOnClickListener(btnAdd1OnClick1234);
        imageButton1 = findViewById(R.id.learn_mood_button);
        imageButton1.setOnClickListener(btnAdd1OnClick12345);

    }
    private View.OnClickListener btnAdd1OnClick1234= new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent(game_choice.this, puzzle_start.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }

    };
    private View.OnClickListener btnAdd1OnClick12345= new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent(game_choice.this, GameMood.class);
            //intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }

    };
    private View.OnClickListener buttonhome= new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent(game_choice.this, MainActivity.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }

    };
}
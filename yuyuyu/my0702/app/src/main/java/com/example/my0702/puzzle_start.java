package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class puzzle_start extends AppCompatActivity {
    private Button btn1,btn2;
    private TextView TextView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_start);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("account");
        TextView1 = findViewById(R.id.n1);
        TextView1.setText(loginname);

        btn1 = findViewById(R.id.home);
        btn1.setOnClickListener(buttonhome);
        btn2 = findViewById(R.id.start);
        btn2.setOnClickListener(btnstart);
    }
    private View.OnClickListener btnstart= new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent(puzzle_start.this, SamplePuzzle.class);

            startActivity(intent);//跳轉到倒計時頁面
        }
    };
    /*
    private View.OnClickListener btnstart = new View.OnClickListener() {
        public void onClick(View view) {
            Intent intent = new Intent(puzzle_start.this, SamplePuzzle.class);  // bug in this line. use SamplePuzzle instead puzzle_game
            startActivity(intent);//跳轉到倒計時頁面
        }
    };
     */
    private View.OnClickListener buttonhome= new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent(puzzle_start.this, MainActivity.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }

    };
}
package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;
import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
//import android.app.Activity;
//import android.os.Bundle;
//import android.util.DisplayMetrics;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.TextView;

//主畫面
public class MainActivity extends AppCompatActivity {
    private Button button1, button2, button3, button4, button5, buttonlogout;

    //static final String DB_FILE = "friends.db";//資料庫
    //static final String DB_TABLE = "friends";//資料表
    //SQLiteDatabase db;    //資料庫
    private EditText midtAddr, midpassword;
    private TextView TextView1, TextView2, txtv1,txtv2,txtv3,txtv4;

    // 開啟或建立資料庫
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);   //全螢幕設定
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//        WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        //取得傳遞過來的資料
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname = bundle.getString("account");
        TextView1 = findViewById(R.id.textView5);
        TextView1.setText(loginname);
/*
        midtAddr = findViewById(R.id.userid);
        midpassword = findViewById(R.id.passwd);
        Button loginbtn = findViewById(R.id.buttonlogin);
        loginbtn.setOnClickListener(loginbtnOnClick);
*/

        buttonlogout = (Button) findViewById(R.id.buttonlogout);//把UI介面的東西叫過來
        button1 = (Button) findViewById(R.id.button7);//把UI介面的東西叫過來
        button3 = (Button) findViewById(R.id.button8);//把UI介面的東西叫過來
        button4 = (Button) findViewById(R.id.button9);//把UI介面的東西叫過來
        button5 = (Button) findViewById(R.id.button10);//把UI介面的東西叫過來

        txtv1 = (TextView) findViewById(R.id.textView8);//把UI介面的東西叫過來
        txtv2 = (TextView) findViewById(R.id.textView75);//把UI介面的東西叫過來
        txtv3 = (TextView) findViewById(R.id.textView76);//把UI介面的東西叫過來
        txtv4 = (TextView) findViewById(R.id.textView77);//把UI介面的東西叫過來
       /* button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Preference.class);
                String str = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
                StringBuffer sb = new StringBuffer();
                int len = 6;
                for (int i = 0; i < len; i++) {
                    int idx = (int)(Math.random() * str.length());
                    sb.append(str.charAt(idx));
                }
                intent.putExtra("name", sb.toString());//"姓名:"
                startActivity(intent);//訪客登入執行跳頁
            }
        });*/
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, calender_mood.class);
                intent.putExtra("account", TextView1.getText().toString());//"姓名:"
                startActivity(intent);//跳轉至心情日記頁面
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, profile_choice.class);
                intent.putExtra("account", TextView1.getText().toString());//"姓名:"
                startActivity(intent);//跳轉至個人專區頁面
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, i_mood.class);
                intent.putExtra("account", TextView1.getText().toString());//"姓名:"
                startActivity(intent);//跳轉至心情溫度計測試頁面
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, game_choice.class);
                intent.putExtra("account", TextView1.getText().toString());//"姓名:"
                startActivity(intent);//跳轉至遊戲區頁面
            }
        });
        buttonlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MainActivity2__login.class);
                startActivity(intent);//跳轉至遊戲區頁面
                finish();
                Toast toast = Toast.makeText(MainActivity.this, "成功登出", Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        txtv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, i_mood.class);
                intent.putExtra("account", TextView1.getText().toString());//"姓名:"
                startActivity(intent);//跳轉至溫度計頁面
            }
        });

        txtv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, calender_mood.class);
                intent.putExtra("account", TextView1.getText().toString());//"姓名:"
                startActivity(intent);//跳轉至心情日記頁面
            }
        });

        txtv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, game_choice.class);
                intent.putExtra("account", TextView1.getText().toString());//"姓名:"
                startActivity(intent);//跳轉至遊戲區頁面
            }
        });

        txtv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, profile_choice.class);
                intent.putExtra("account", TextView1.getText().toString());//"姓名:"
                startActivity(intent);//跳轉至個人專區頁面
            }
        });

    }
}

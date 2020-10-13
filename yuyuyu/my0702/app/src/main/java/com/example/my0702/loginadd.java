package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.*;

import java.text.SimpleDateFormat;
import java.util.Date;

//登入判斷
public class loginadd extends AppCompatActivity {
    private TextView TextView1,TextView2;
    private EditText Ed1,Ed2;
    private int b;
    private Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginadd);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());

        //取得傳遞過來的資料
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        TextView1 = (TextView) findViewById(R.id.textView8);
        TextView2 = (TextView) findViewById(R.id.textView81);
        TextView1.setText(bundle.getString("ed1"));
        TextView2.setText(bundle.getString("ed2"));
        btn1 = findViewById(R.id.btn_login);
        btn1.setOnClickListener(buttonhome);


        //MainActivity_login_sql_text MainActivity_login_sql_text = new MainActivity_login_sql_text(this);
        //MainActivity_login_sql_text.execute(type,TextView1.getText().toString(),TextView2.getText().toString());
        //Ed1 .setText(Integer.toString(b));

        try {
                /*
                    SQL 結果有多筆資料時使用JSONArray
                    只有一筆資料時直接建立JSONObject物件
                    JSONObject jsonData = new JSONObject(result);
                */
            String result = MainActivityloginSQL.executeQuery1("SELECT * FROM  `registered` WHERE `id` ='" + TextView1.getText().toString() + "'  and `pwd` ='" + TextView2.getText().toString() + "' ");
            int a = result.indexOf("off");
            /*
            String result2;
            if(TextView1.getText().toString().equals("id.getText().toString)"))
            { //判斷帳號是否相同
                result2 = "此帳號已有人使用，請更換一個!!";
            }*/
            if (a > -1) {  //判斷無會員
                Ed1.setText("-1");
                Intent intent1 = new Intent(loginadd.this, MainActivity2__login.class);
                startActivity(intent1);//註冊會員執行跳頁
            }

            JSONArray jsonArray = new JSONArray(result);    //BUG

            if (Integer.parseInt(String.valueOf(jsonArray.length())) == 1) { //判斷有會員資料

                    Intent intent1 = new Intent(loginadd.this, MainActivity.class);
                    intent1.putExtra("account", TextView1.getText().toString());//"姓名:"
                    startActivity(intent1);//註冊會員執行跳頁

            }

            } catch(Exception e){
                // Log.e("log_tag", e.toString());
            }


//////這個好像不會回傳東西來這邊


        }
    private View.OnClickListener buttonhome= new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent(loginadd.this, MainActivity2__login.class);
            startActivity(intent);//跳轉到倒計時頁面
            finish();
            Toast toast = Toast.makeText(loginadd.this, "請登入", Toast.LENGTH_SHORT);
            toast.show();
        }

    };
    }
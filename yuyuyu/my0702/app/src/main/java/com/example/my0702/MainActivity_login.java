package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.*;

import java.text.SimpleDateFormat;

//登入判斷
public class MainActivity_login extends AppCompatActivity {
    private TextView TextView1,TextView2;
    private EditText Ed1,Ed2;
    private int b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_insert);
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
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String date = sDateFormat.format(new java.util.Date());
        //取得傳遞過來的資料
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        TextView1 = (TextView)findViewById(R.id.textView800);
        TextView2 = (TextView)findViewById(R.id.textView8001);
        TextView1 .setText(bundle.getString("ac"));
        TextView2 .setText(bundle.getString("pd"));
        Ed1 = (EditText)findViewById(R.id.etusername);

        String type = "Select_login";
        //MainActivity_login_sql_text MainActivity_login_sql_text = new MainActivity_login_sql_text(this);
        //MainActivity_login_sql_text.execute(type,TextView1.getText().toString(),TextView2.getText().toString());
        //Ed1 .setText(Integer.toString(b));

        try {
                /*
                    SQL 結果有多筆資料時使用JSONArray
                    只有一筆資料時直接建立JSONObject物件
                    JSONObject jsonData = new JSONObject(result);
                */
            String result = MainActivityloginSQL.executeQuery1("SELECT * FROM  `login` WHERE `account` ='"+TextView1.getText().toString()+"'  and `password` ='"+TextView2.getText().toString()+"' ");
            int a= result.indexOf("off");

            if(a>-1){  //判斷無會員
                Ed1.setText("-1");
                Intent intent1 = new Intent(MainActivity_login.this, MainActivity.class);
                startActivity(intent1);//註冊會員執行跳頁
            }

            JSONArray jsonArray = new JSONArray(result);    //BUG

            if( Integer.parseInt(String.valueOf(jsonArray.length()))==1){ //判斷有會員資料

                String result1 = login_preference_SQL.executeQuery("SELECT * FROM `preference` where `account` = '"+TextView1.getText().toString()+"' ");
                int aa= result1.indexOf("off");
                if(aa>-1){ //無設定偏好跳回
                    Ed1.setText("-1");
                    Intent intent1 = new Intent(MainActivity_login.this, Preference.class);
                    intent1.putExtra("account", TextView1.getText().toString());//"姓名:"
                    startActivity(intent1);//註冊會員執行跳頁
                }

                Ed1.setText("0");
                JSONArray jsonArray1 = new JSONArray(result1);    //BUG
                Ed1.setText("1");
                if( Integer.parseInt(String.valueOf(jsonArray1.length()))==1){ //判斷是否有設定偏好

                    String result2 = login_myselfnews_SQL.executeQuery("SELECT * FROM `myselfnews` where `account` = '"+TextView1.getText().toString()+"'and  `date`='"+date+"'");
                    int aaa= result2.indexOf("off");

                     //BUG
                    if(aaa>-1){ //無設今日資料跳新增
                        Ed1.setText("-1");
                        Intent intent1 = new Intent(MainActivity_login.this, LoginMain1.class);
                        intent1.putExtra("account", TextView1.getText().toString());//"姓名:"
                        startActivity(intent1);//新增個人數值執行跳頁
                    }

                    JSONArray jsonArray2 = new JSONArray(result2);

                        if( Integer.parseInt(String.valueOf(jsonArray2.length()))==1){ //判斷是否有今日設定
                            Ed1.setText("3");
                            JSONObject jsonData = jsonArray2.getJSONObject(0);
                            Intent intent3 = new Intent(MainActivity_login.this, LoginMain.class);
                            intent3.putExtra("account", jsonData.getString("account"));//"姓名:"
                            intent3.putExtra("high", jsonData.getString("high"));//"姓名:"
                            intent3.putExtra("kg", jsonData.getString("kg"));//"姓名:"
                            startActivity(intent3);//修改個人數值執行跳頁
                        }
                }
            }



        } catch(Exception e) {
            // Log.e("log_tag", e.toString());
        }

    }
    public interface AsyncResponse {
        void processFinish(String output);
    }

}



//////這個好像不會回傳東西來這邊




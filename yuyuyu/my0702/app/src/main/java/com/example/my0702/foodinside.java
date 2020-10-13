package com.example.my0702;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

import static android.view.View.GONE;
//菜單頁面
public class foodinside extends AppCompatActivity {
    private TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7;
    private String SB1,SB2,SB3,SB4;
    private String TI1,TI2,TI3,TI4;
    private String BMI1,BMI2,BMI3,BMI4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodinside);

        //取得傳遞過來的資料
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int loginname1=bundle.getInt("id");
        textView1 = (TextView)findViewById(R.id.textView30);
        textView2 = (TextView)findViewById(R.id.textView12);
        textView3 = (TextView)findViewById(R.id.textView72);
        textView4 = (TextView)findViewById(R.id.textView57);
        textView5 = (TextView)findViewById(R.id.textView73);
        textView6 = (TextView)findViewById(R.id.textView74);
        textView7 = (TextView)findViewById(R.id.textView14);
        textView7.setText(String.valueOf(loginname1));
        try {

            String result = foodinside_SQL.executeQuery("SELECT * FROM `food` where `id`='"+textView7.getText().toString()+"' ");

            JSONArray jsonArray = new JSONArray(result);

            for(int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonData = jsonArray.getJSONObject(i);

                textView1.setText("菜名："+jsonData.getString("menu"));

                if(Integer.parseInt(jsonData.getString("slimming"))==1){
                    textView2.setText("瘦身");
                }
                if(Integer.parseInt(jsonData.getString("fitness"))==1){
                    textView2.setText("健身");
                }
                if(Integer.parseInt(jsonData.getString("shaping"))==1){
                    textView2.setText("塑形");
                }
                if(Integer.parseInt(jsonData.getString("strengthen"))==1){
                    textView2.setText("增強體質");
                }

                String[]  movement=jsonData.getString("food").split(",");
                String movement1="";
                String[]  movement2=jsonData.getString("foodweight").split(",");
                for(int a=0;a<movement.length;a++){
                    movement1=movement1+movement[a]+"\u3000"+movement2[a]+"\n";
                }
                textView3.setText(movement1);
                //textView4.setText(movement3);
                textView5.setText("卡路里："+jsonData.getString("calories")+"\n");
                textView6.setText("步驟："+jsonData.getString("step"));

            }
        } catch(Exception e) {
            // Log.e("log_tag", e.toString());
        }

    }
}
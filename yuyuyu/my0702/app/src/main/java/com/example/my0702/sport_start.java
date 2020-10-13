package com.example.my0702;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.SimpleDateFormat;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

import static android.view.View.GONE;
//運動執行
public class sport_start extends AppCompatActivity {

    CircularView circularViewWithTimer;     //宣告物件變數
    Context context;
    int countBeep = 0;
    int tempBeep = 0;
    private Button start,stop,pause,resume,reset,finish;
    private TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_start);
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = sDateFormat.format(new java.util.Date());
        //取得傳遞過來的資料
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname1=bundle.getString("checked");
        String[]  movement=loginname1.split(",");
        String loginname2=bundle.getString("time");
        String[]  movement1=loginname2.split(",");
        String loginname3=bundle.getString("calories");
        int number=bundle.getInt("number");
        int count=bundle.getInt("count");
        int num=bundle.getInt("num");
        int text=Integer.parseInt(movement1[num]);
        start = (Button)findViewById(R.id.bt1);       //物件變數導入介面
        stop = (Button)findViewById(R.id.bt2);       //物件變數導入介面
        pause = (Button)findViewById(R.id.bt3);
        resume =(Button)findViewById(R.id.bt4);
        reset = (Button)findViewById(R.id.bt5);
        finish = (Button)findViewById(R.id.bt6);

        stop.setVisibility(GONE);
        pause.setVisibility(GONE);
        resume.setVisibility(GONE);
        reset.setVisibility(GONE);
        finish.setVisibility(GONE);
        if(number==1 || number==3 || number==5){
            text=5;
        }
        if(number==1 || number==3 || number==5){
            textView1 = findViewById(R.id.textView6);
            textView1.setText("休息時間");
            textView2 = findViewById(R.id.textView7);
            textView2.setText("5");
        }else{
            textView1 = findViewById(R.id.textView6);
            textView1.setText(movement[number-num]);
            textView2 = findViewById(R.id.textView7);
            textView2.setText(movement1[number-num]);
        }

        textView3 = findViewById(R.id.textView800);
        textView3.setText(loginname1);
        textView4= findViewById(R.id.textView9);
        textView4.setText(loginname2);
        textView5 = findViewById(R.id.textView10);
        textView5.setText(Integer.toString(number));
        textView6 = findViewById(R.id.textView11);
        textView6.setText(Integer.toString(text));
        textView7 = findViewById(R.id.textView12);
        textView7.setText(Integer.toString(count));
        textView8 = findViewById(R.id.textView13);
        textView8.setText(Integer.toString(num));
        textView9 = findViewById(R.id.textView14);
        textView9.setText(loginname3);

        circularViewWithTimer = findViewById(R.id.circular_view);
        CircularView.OptionsBuilder builderWithTimer = new CircularView.OptionsBuilder()
                        .shouldDisplayText(true)
                        .setCounterInSeconds(text)        //執行秒數
                        .setCircularViewCallback(new CircularViewCallback() {
                            public void onTimerFinish() {
                                // Will be called if times up of countdown timer
                                Toast.makeText(sport_start.this, "CircularCallback: Timer Finished ", Toast.LENGTH_SHORT).show();       //時間倒數結束
                                if(countBeep==Integer.parseInt(textView6.getText().toString())) {
                                    /*Intent i = new Intent(sport_start.this,sport_start.class);
                                    i.putExtra("checked",  textView3.getText().toString());        //傳入點選事件之項目
                                    i.putExtra("time",  textView4.getText().toString());
                                    i.putExtra("number", Integer.parseInt(textView5.getText().toString()) + 1);
                                    i.putExtra("count", Integer.parseInt(textView7.getText().toString()));
                                    if(Integer.parseInt(textView5.getText().toString()) + 1==1 || Integer.parseInt(textView5.getText().toString()) + 1==3 || Integer.parseInt(textView5.getText().toString()) + 1==5){
                                        i.putExtra("num", Integer.parseInt(textView8.getText().toString())+1);
                                    }else{
                                        i.putExtra("num", Integer.parseInt(textView8.getText().toString()));
                                    }
                                    startActivity(i);*/
                                    stop.setVisibility(GONE);
                                    pause.setVisibility(GONE);
                                    resume.setVisibility(GONE);
                                    reset.setVisibility(GONE);
                                    if(Integer.parseInt(textView5.getText().toString())+1<Integer.parseInt(textView7.getText().toString())) {
                                        Intent i = new Intent(sport_start.this,sport_start.class);
                                        i.putExtra("checked",  textView3.getText().toString());        //傳入點選事件之項目
                                        i.putExtra("time",  textView4.getText().toString());
                                        i.putExtra("number", Integer.parseInt(textView5.getText().toString()) + 1);
                                        i.putExtra("count", Integer.parseInt(textView7.getText().toString()));
                                        i.putExtra("calories", textView9.getText().toString());
                                        if(Integer.parseInt(textView5.getText().toString()) + 1==1 || Integer.parseInt(textView5.getText().toString()) + 1==3 || Integer.parseInt(textView5.getText().toString()) + 1==5){
                                            i.putExtra("num", Integer.parseInt(textView8.getText().toString())+1);
                                        }else{
                                            i.putExtra("num", Integer.parseInt(textView8.getText().toString()));
                                        }
                                        startActivity(i);
                                    }else{
                                        finish.setVisibility(View.VISIBLE);
                                        reset.setVisibility(GONE);
                                        /*Intent i = new Intent(sport_start.this, sport.class);
                                        startActivity(i);*/
                                    }

                                    /*stop.setVisibility(GONE);
                                    pause.setVisibility(GONE);
                                    resume.setVisibility(GONE);*/
                                }
                            }
                            public void onTimerCancelled() {
                                // Will be called if stopTimer is called
                                Toast.makeText(sport_start.this, "CircularCallback: Timer Cancelled ", Toast.LENGTH_SHORT).show();      //強制終止

                            }
                        });

        circularViewWithTimer.setOptions(builderWithTimer);
        if(number!=0){
            circularViewWithTimer.startTimer();
            playAlertTone(getApplicationContext());
            start.setVisibility(GONE);
            stop.setVisibility(View.VISIBLE);
            pause.setVisibility(View.VISIBLE);
            reset.setVisibility(View.VISIBLE);
            finish.setVisibility(GONE);
        }
    }

    //執行開始
    public void btn_Start(View view) {
        circularViewWithTimer.startTimer();
        playAlertTone(getApplicationContext());
        start.setVisibility(GONE);
        stop.setVisibility(View.VISIBLE);
        pause.setVisibility(View.VISIBLE);
        reset.setVisibility(View.VISIBLE);
        finish.setVisibility(GONE);
    }
    //執行終止
    public void btn_Stop(View view) {
        circularViewWithTimer.stopTimer();
        stop.setVisibility(GONE);
        pause.setVisibility(GONE);
        resume.setVisibility(GONE);
        reset.setVisibility(GONE);
        if(Integer.parseInt(textView5.getText().toString())+1<Integer.parseInt(textView7.getText().toString())) {
            Intent i = new Intent(sport_start.this,sport_start.class);
            i.putExtra("checked",  textView3.getText().toString());        //傳入點選事件之項目
            i.putExtra("time",  textView4.getText().toString());
            i.putExtra("number", Integer.parseInt(textView5.getText().toString()) + 1);
            i.putExtra("count", Integer.parseInt(textView7.getText().toString()));
            i.putExtra("calories", textView9.getText().toString());
            if(Integer.parseInt(textView5.getText().toString()) + 1==1 || Integer.parseInt(textView5.getText().toString()) + 1==3 || Integer.parseInt(textView5.getText().toString()) + 1==5){
                i.putExtra("num", Integer.parseInt(textView8.getText().toString())+1);
            }else{
                i.putExtra("num", Integer.parseInt(textView8.getText().toString()));
            }
            startActivity(i);
        }else{
            finish.setVisibility(View.VISIBLE);
            reset.setVisibility(GONE);
            /*Intent i = new Intent(sport_start.this, sport.class);
            startActivity(i);*/
        }


    }
    //執行暫停
    public void btn_Pause(View view) {
        circularViewWithTimer.pauseTimer();
        tempBeep=countBeep;
        countBeep=Integer.parseInt(textView6.getText().toString());
        pause.setVisibility(GONE);
        resume.setVisibility(View.VISIBLE);
    }
    //執行繼續
    public void btn_Resume(View view) {
        circularViewWithTimer.resumeTimer();
        countBeep=tempBeep;
        pause.setVisibility(View.VISIBLE);
        resume.setVisibility(GONE);
        playAlertTone(getApplicationContext());
    }
    public void btn_Reset(View view) {
        Intent i = new Intent(sport_start.this,sport_start.class);
        i.putExtra("checked",  textView3.getText().toString());        //傳入點選事件之項目
        i.putExtra("time",  textView4.getText().toString());
        i.putExtra("number", Integer.parseInt(textView5.getText().toString()));
        i.putExtra("count", Integer.parseInt(textView7.getText().toString()));
        i.putExtra("num", Integer.parseInt(textView8.getText().toString()));
        i.putExtra("calories", textView9.getText().toString());
        startActivity(i);
        countBeep=Integer.parseInt(textView6.getText().toString());
        finish();
    }
    public void btn_Finish(View view) {

        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = sDateFormat.format(new java.util.Date());
        String account = "123";
        String sport = textView3.getText().toString();
        String time = textView4.getText().toString();
        String calories = textView9.getText().toString();
        String result2 = sport_SQL_insert.executeQuery(date,account,sport,time,calories);
        /*int aaa= result2.indexOf("login success");
        textView1.setText(Integer.toString(aaa));
        int aaaa= result2.indexOf("login NOT success");
        textView2.setText(Integer.toString(aaaa));*/


        Intent i = new Intent(sport_start.this, sport.class);
        startActivity(i);
    }
    public void playAlertTone(final  Context context){
        Thread t = new Thread(){
            public void run(){
                while(countBeep<Integer.parseInt(textView6.getText().toString())){
                    countBeep+=1;
                }
            }
        };
        t.start();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        countBeep=Integer.parseInt(textView6.getText().toString());
    }
}

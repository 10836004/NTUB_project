package com.example.my0702;

import org.json.JSONArray;
import org.json.JSONObject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.os.Bundle;
import android.os.StrictMode;
//運動選單
public class sport extends AppCompatActivity {

    private Button button_get_record;
    private String SB1,SB2,SB3,SB4;
    private String TI1,TI2,TI3,TI4;
    private String BMI1,BMI2,BMI3,BMI4;
    public static int flag_1,flag_2,flag_3,flag_4 = 0;
    private TextView textView1,textView2,textView3,textView4;
    private Button button1,button2,button3,button4,button5;
    private LinearLayout mainLayout,mainLayout1,mainLayout2,mainLayout3,mainLayout4,mainLayout5,mainLayout6,mainLayout7;
    private View.OnClickListener btnClickHandle = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            mainLayout.removeView(v);
            mainLayout1.removeView(v);
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);

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

        textView1=(TextView)findViewById(R.id.textView15);
        textView2=(TextView)findViewById(R.id.textView16);
        textView3=(TextView)findViewById(R.id.textView17);
        textView4=(TextView)findViewById(R.id.textView19);
        mainLayout =(LinearLayout)findViewById(R.id.dynamic_layout);
        mainLayout1 =(LinearLayout)findViewById(R.id.dynamic_layout1);
        mainLayout2 =(LinearLayout)findViewById(R.id.dynamic_layout2);
        mainLayout3 =(LinearLayout)findViewById(R.id.dynamic_layout3);
        mainLayout4 =(LinearLayout)findViewById(R.id.dynamic_layout4);
        mainLayout5 =(LinearLayout)findViewById(R.id.dynamic_layout5);
        mainLayout6 =(LinearLayout)findViewById(R.id.dynamic_layout6);
        mainLayout7 =(LinearLayout)findViewById(R.id.dynamic_layout7);
        button1 = (Button) findViewById(R.id.btn111);//把UI介面的東西叫過來
        button2 = (Button) findViewById(R.id.sportbt_1);//把UI介面的東西叫過來
        button3 = (Button) findViewById(R.id.sportbt_2);
        button4 = (Button) findViewById(R.id.sportbt_3);
        button5 = (Button) findViewById(R.id.sportbt_4);
        textView1.setClickable(true);       //給予點擊觸發事件權限
        textView2.setClickable(true);
        textView3.setClickable(true);
        textView4.setClickable(true);
///*--------------------------------------------------------------------------------------------
/*
 bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod =new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.home:
                    fragment = new HomeFragment();
                    break;
                case R.id.running:
                    fragment = new RunningFragment();
                    break;
                case R.id.eat:


                    break;
                case R.id.personal:
                    fragment = new PersonalFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            return true;
        }
    };
*/
//--------------------------------------------------------------------------------------------------
        try {

            String result = sport_SQL.executeQuery("SELECT * FROM `sport` ");//1

            JSONArray jsonArray = new JSONArray(result);//1

            for(int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonData = jsonArray.getJSONObject(i);//1
                if(i==0) {
                    SB1=jsonData.getString("sport") +",";//1
                    TI1= jsonData.getString("time") +",";
                    BMI1=jsonData.getString("calories") +",";
                    button2.setText("運動項目 : " + jsonData.getString("sport") + " & 時間 : " + jsonData.getString("time"));
                }else if(i==1) {
                    SB2=jsonData.getString("sport") +",";
                    TI2= jsonData.getString("time") +",";
                    BMI2=jsonData.getString("calories") +",";
                    button3.setText("運動項目 : " + jsonData.getString("sport") + " & 時間 : " + jsonData.getString("time"));
                }else if(i==2) {
                    SB3=jsonData.getString("sport") +",";
                    TI3= jsonData.getString("time") +",";
                    BMI3=jsonData.getString("calories") +",";
                    button4.setText("運動項目 : " + jsonData.getString("sport") + " & 時間 : " + jsonData.getString("time"));
                }else if(i==3) {
                    SB4=jsonData.getString("sport") +",";
                    TI4= jsonData.getString("time") +",";
                    BMI4=jsonData.getString("calories") +",";
                    button5.setText("運動項目 : " + jsonData.getString("sport") + " & 時間 : " + jsonData.getString("time"));
                }
            }
        } catch(Exception e) {
            // Log.e("log_tag", e.toString());
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=0;
                Intent intent = new Intent(sport.this, sport_start.class);

                StringBuffer sb = new StringBuffer();
                StringBuffer ti = new StringBuffer();
                StringBuffer bmi = new StringBuffer();
                if(flag_1==1){
                    sb.append(SB1);
                    ti.append(TI1);
                    bmi.append(BMI1);
                    a=a+2;
                }
                if(flag_2==1){
                    sb.append(SB2);
                    ti.append(TI2);
                    bmi.append(BMI2);
                    a=a+2;
                }
                if(flag_3==1){
                    sb.append(SB3);
                    ti.append(TI3);
                    bmi.append(BMI3);
                    a=a+2;
                }
                if(flag_4==1){
                    sb.append(SB4);
                    ti.append(TI4);
                    bmi.append(BMI4);
                    a=a+2;
                }

                intent.putExtra("checked",  sb.toString());        //傳入點選事件之項目
                intent.putExtra("time",  ti.toString());
                intent.putExtra("calories",  bmi.toString());
                intent.putExtra("number", 0);
                intent.putExtra("count",  a-1);
                intent.putExtra("num",  0);
                startActivity(intent);//跳轉到倒計時頁面
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mainLayout.removeView(button2);     //刪除該介面的物件
                mainLayout1.removeView(textView1);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mainLayout2.removeView(button3);
                mainLayout3.removeView(textView2);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mainLayout4.removeView(button4);
                mainLayout5.removeView(textView3);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mainLayout6.removeView(button5);
                mainLayout7.removeView(textView4);
            }
        });

//宣告按鈕
        button2.setOnClickListener(btnpreferenceOnClick1);      //給予點擊觸發事件
        button3.setOnClickListener(btnpreferenceOnClick2);
        button4.setOnClickListener(btnpreferenceOnClick3);
        button5.setOnClickListener(btnpreferenceOnClick4);



    }
    //讓按鈕點擊後執行什麼

    private View.OnClickListener btnpreferenceOnClick1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (flag_1 == 0) {
                button2.setSelected(true); // 第一次??触?的事件
                flag_1 = 1;
            } else {
                button2.setSelected(false); // 第二次??buttont改?触?的事件
                flag_1 = 0;
            }
        }

    };
    private View.OnClickListener btnpreferenceOnClick2 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (flag_2 == 0) {
                button3.setSelected(true); // 第一次??触?的事件
                flag_2 = 1;
            } else {
                button3.setSelected(false); // 第二次??buttont改?触?的事件
                flag_2 = 0;
            }
        }

    };
    private View.OnClickListener btnpreferenceOnClick3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (flag_3 == 0) {
                button4.setSelected(true); // 第一次??触?的事件
                flag_3 = 1;
            } else {
                button4.setSelected(false); // 第二次??buttont改?触?的事件
                flag_3 = 0;
            }
        }

    };
    private View.OnClickListener btnpreferenceOnClick4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (flag_4 == 0) {
                button5.setSelected(true); // 第一次??触?的事件
                flag_4 = 1;
            } else {
                button5.setSelected(false); // 第二次??buttont改?触?的事件
                flag_4 = 0;
            }
        }

    };

    private Button bt_10;
    //@Override
    protected void onCreate1(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);
        bt_10 = (Button) findViewById(R.id.sportbt_1);
        bt_10.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                switch (event.getAction()) {
                     case MotionEvent.ACTION_DOWN:
                        bt_10.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                     break;
                     case MotionEvent.ACTION_UP:
                         bt_10.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                     break;
                }
                return true;
            }
        });
    }
    /*private View.OnClickListener btnClickHandle = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            mainLayout.removeView(v);
        }
        mainLayout=(LinearLayout)findViewById(R.id.dynamic_layout);
        for(int i=0;i<5;i++){
            btn=new Button(this);
            btn.setText("remove me -> " + i);
            //mainLayout.addView(btn);
            mainLayout.addView(btn,-2,-2);
            btn.setOnClickListener(btnClickHandle);
        }
    };*/
}
package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class changIntroduction extends AppCompatActivity {
    private TextView mn1;
    private TextView t1,t2,t3;
    private EditText mm1,mm2,mm3,mm4;
    private Button btn1;
    private Switch sw1;
    private String aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chang_introduction);
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
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("account");
        mn1= findViewById(R.id.textView18);
        mn1.setText(loginname);
        mm1 = findViewById(R.id.accontchang);
        mm2 =findViewById(R.id.namechange);
        mm3=findViewById(R.id.textchange);
        sw1=findViewById(R.id.switch1);
        /*t1 =findViewById(R.id.textView54);
        t3=findViewById(R.id.textView53);
        t2=findViewById(R.id.textView55);*/
        t1 =findViewById(R.id.textView144);
        try {
            String result1 = changlntroduction_SQL.executeQuery("SELECT * FROM `login` inner join `myselfe` on `login`.`account`=`myselfe`.`account` inner join `preference` on `login`.`account`=`preference`.`account` where `login`.`account`='"+mn1.getText().toString()+"'");
            int a= result1.indexOf("off");
            if(a>-1){ //無設定偏好跳回
                String result2 = changlntroduction_SQL.executeQuery("SELECT * FROM `login` where `account`='"+mn1.getText().toString()+"'");
                JSONArray jsonArray2 = new JSONArray(result2);

                if( Integer.parseInt(String.valueOf(jsonArray2.length()))==1){
                    JSONObject jsonData = jsonArray2.getJSONObject(0);
                    mm1.setText(jsonData.getString("account"));
                    mm2.setText(jsonData.getString("name"));
                    Button btn1 = findViewById(R.id.button3);
                    btn1.setOnClickListener(btnAdd1OnClick);
                }
            }
            JSONArray jsonArray1 = new JSONArray(result1);

            if( Integer.parseInt(String.valueOf(jsonArray1.length()))==1){
                JSONObject jsonData = jsonArray1.getJSONObject(0);
                mm1.setText(jsonData.getString("account"));
                mm2.setText(jsonData.getString("name"));
                mm3.setText(jsonData.getString("Introduction"));
                sw1.setText(jsonData.getString("public"));
                t1.setText(jsonData.getString("public"));
                        if(sw1.getText().toString().equals("0")){
                            sw1.setChecked(false);
                            sw1.setTextOn("0");
                        }else{
                            sw1.setChecked(true);
                            sw1.setTextOff("1");
                        }
                    }
                Button btn1 = findViewById(R.id.button3);
                btn1.setOnClickListener(btnAdd1OnClick);

        } catch(Exception e){
            // Log.e("log_tag", e.toString());
        }
        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    if(Integer.parseInt(t1.getText().toString())==0){
                        aa="1";
                    }else{
                        aa="0";
                    }
                    //t2.setText(aa);
                }
            }
        });

    }

    private View.OnClickListener btnAdd1OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                try {
                    /*t1.setText(mm2.getText().toString());
                    t3.setText(aa);*/
                    String result2 = changlntroduction_SQL_UPandIN.executeQuery1( mm1.getText().toString(),aa );
                } catch(Exception e){
                    // Log.e("log_tag", e.toString());
                }
        }
    };
}
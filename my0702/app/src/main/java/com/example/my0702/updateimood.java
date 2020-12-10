package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import android.os.Bundle;

public class updateimood extends AppCompatActivity {
    private Button btn1,btnback,btnhome,buttonupdate;
    private EditText mEdtkg1,mEdthi, mEdtBMI1,mEdtbodya, mEdtbody1,mEdtbody11,mEdtbody21,mEdtbody31,mEdtbody41,mEdtbody51,mEdtbody61,mEdtbody71,mEdtbody81,mEdtbody91;
    private TextView TextView1,text1;
    SimpleDateFormat sDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
    String date1 = sDateFormat1.format(new java.util.Date());

    public updateimood() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateimood);
        //取得傳遞過來的資料
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("id");
        int loginname1 = bundle.getInt("idid");
        TextView1 = findViewById(R.id.n1);
        TextView1.setText(loginname);
        text1=findViewById(R.id.n5);
        text1.setText(String.valueOf(loginname1));
        btnhome= findViewById(R.id.home);
        btnhome.setOnClickListener(buttonhome);
        btnback= findViewById(R.id.back);
        btnback.setOnClickListener(buttonback);
        buttonupdate= findViewById(R.id.update);
        buttonupdate.setOnClickListener(button123);
        mEdtbodya = findViewById(R.id.edthi);
        mEdtbody1 = findViewById(R.id.edthi1);
        mEdtbody11= findViewById(R.id.edtkg1);
        mEdtbody21= findViewById(R.id.edtbody1);
        //mEdtbody31 = findViewById(R.id.edtbody11);
        mEdtbody41 = findViewById(R.id.edtbody21);
        //text1= findViewById(R.id.textView4);

        try {
            String result = MainActivityloginSQL.executeQuery1("SELECT * FROM `imood` where `idid`='"+text1.getText().toString()+"'");
            //String result = MainActivityloginSQL.executeQuery1("SELECT * FROM `calender` WHERE `id` = '3333'  and `datetime` = '2020-10-11 08:39:19''");

            //   text1.setText("SELECT * FROM `registered` where `name` = '"+TextView1.getText().toString()+"'");


            JSONArray jsonArray = new JSONArray(result);
            if( Integer.parseInt(String.valueOf(jsonArray.length()))==1){ //已有偏好資料進行更新
                JSONArray jsonArray2 = new JSONArray(result);
                JSONObject jsonData = jsonArray2.getJSONObject(0);

                mEdtbodya.setText( jsonData.getString("imood1"));;
                mEdtbody1.setText( jsonData.getString("imood2"));;
                mEdtbody11.setText( jsonData.getString("imood3"));
                mEdtbody21.setText( jsonData.getString("imood4"));
                //mEdtbody31.setText( jsonData.getString("imood4"));
                mEdtbody41.setText( jsonData.getString("datetime"));



            }
        }catch (Exception e) {
            // Log.e("log_tag", e.toString());

        }

    }


    private View.OnClickListener buttonback = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(updateimood.this, imooddd.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }
    };

    private View.OnClickListener buttonhome = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(updateimood.this, MainActivity.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }
    };
    private View.OnClickListener button123 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String result = MainActivityloginSQL.executeQuery1("UPDATE imood SET `imood1`='"+mEdtbodya.getText().toString()+"' WHERE idid = '"+text1.getText().toString()+"'");
            String result1 = MainActivityloginSQL.executeQuery1("UPDATE imood SET `imood2`='"+mEdtbody1.getText().toString()+"' WHERE idid = '"+text1.getText().toString()+"'");
            String result2 = MainActivityloginSQL.executeQuery1("UPDATE imood SET `imood3`='"+mEdtbody11.getText().toString()+"' WHERE idid = '"+text1.getText().toString()+"'");
            String result3 = MainActivityloginSQL.executeQuery1("UPDATE imood SET `imood4`='"+mEdtbody21.getText().toString()+"' WHERE idid = '"+text1.getText().toString()+"'");
            //String result4 = MainActivityloginSQL.executeQuery1("UPDATE imood SET `imood4`='"+mEdtbody31.getText().toString()+"' WHERE idid = '"+text1.getText().toString()+"'");
            //String result5 = MainActivityloginSQL.executeQuery1("UPDATE calender SET `datetime`='"+mEdtbody41.getText().toString()+"' WHERE id = '"+TextView1.getText().toString()+"'");

            Intent intent = new Intent(updateimood.this, imooddd.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }
    };
}

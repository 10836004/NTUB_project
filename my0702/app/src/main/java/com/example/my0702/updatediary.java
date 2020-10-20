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

public class updatediary extends AppCompatActivity {
    private Button btn1,btnhome,buttonupdate;
    private EditText mEdtkg1,mEdthi, mEdtBMI1, mEdtbody1,mEdtbody11,mEdtbody21,mEdtbody31,mEdtbody41,mEdtbody51,mEdtbody61,mEdtbody71,mEdtbody81,mEdtbody91;
    private TextView TextView1,text1;
    SimpleDateFormat sDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
    String date1 = sDateFormat1.format(new java.util.Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatediary);

        //取得傳遞過來的資料
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("account");
        TextView1 = findViewById(R.id.n1);
        TextView1.setText(loginname);
        btnhome= findViewById(R.id.home);
        btnhome.setOnClickListener(buttonhome);
        buttonupdate= findViewById(R.id.update);
        buttonupdate.setOnClickListener(button123);
        mEdtbody1 = findViewById(R.id.edthi1);
        mEdtbody11= findViewById(R.id.edtkg1);
        mEdtbody21= findViewById(R.id.edtbody1);
        mEdtbody31 = findViewById(R.id.edtbody11);
        mEdtbody41 = findViewById(R.id.edtbody21);
        //text1= findViewById(R.id.textView4);

        try {
            String result = MainActivityloginSQL.executeQuery1("SELECT * FROM `calender` where `id` = '"+TextView1.getText().toString()+"' and `date` = '"+date1+"'");
            //String result = MainActivityloginSQL.executeQuery1("SELECT * FROM `calender` WHERE `id` = '3333'  and `datetime` = '2020-10-11 08:39:19''");

            //   text1.setText("SELECT * FROM `registered` where `name` = '"+TextView1.getText().toString()+"'");

            JSONArray jsonArray = new JSONArray(result);
            if( Integer.parseInt(String.valueOf(jsonArray.length()))==1){ //已有偏好資料進行更新
                JSONArray jsonArray2 = new JSONArray(result);
                JSONObject jsonData = jsonArray2.getJSONObject(0);


                mEdtbody1.setText( jsonData.getString("mood"));;
                mEdtbody11.setText( jsonData.getString("person"));
                mEdtbody21.setText( jsonData.getString("time"));
                mEdtbody31.setText( jsonData.getString("diary"));
                mEdtbody41.setText( jsonData.getString("datetime"));


            }
        }catch (Exception e) {
            // Log.e("log_tag", e.toString());

        }

    }




    private View.OnClickListener buttonhome = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(updatediary.this, MainActivity.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }
    };
    private View.OnClickListener button123 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String result1 = MainActivityloginSQL.executeQuery1("UPDATE calender SET `mood`='"+mEdtbody1.getText().toString()+"' WHERE id = '"+TextView1.getText().toString()+"'");
            String result2 = MainActivityloginSQL.executeQuery1("UPDATE calender SET `person`='"+mEdtbody11.getText().toString()+"' WHERE id = '"+TextView1.getText().toString()+"'");
            String result3 = MainActivityloginSQL.executeQuery1("UPDATE calender SET `time`='"+mEdtbody21.getText().toString()+"' WHERE id = '"+TextView1.getText().toString()+"'");
            String result4 = MainActivityloginSQL.executeQuery1("UPDATE calender SET `diary`='"+mEdtbody31.getText().toString()+"' WHERE id = '"+TextView1.getText().toString()+"'");
            String result5 = MainActivityloginSQL.executeQuery1("UPDATE calender SET `datetime`='"+mEdtbody41.getText().toString()+"' WHERE id = '"+TextView1.getText().toString()+"'");

            Intent intent = new Intent(updatediary.this, MainActivity.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }
    };

}
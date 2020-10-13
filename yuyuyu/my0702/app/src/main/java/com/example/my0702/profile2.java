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

public class profile2 extends AppCompatActivity {
    private Button btn1,btnhome;
    private EditText mEdtkg1,mEdthi, mEdtBMI1, mEdtbody1,mEdtbody11,mEdtbody21,mEdtbody31,mEdtbody41,mEdtbody51,mEdtbody61,mEdtbody71,mEdtbody81,mEdtbody91;
    private TextView TextView1,text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        //取得傳遞過來的資料
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("account");
        TextView1 = findViewById(R.id.n1);
        TextView1.setText(loginname);
        btnhome= findViewById(R.id.home);
        btnhome.setOnClickListener(buttonhome);
        mEdtbody1 = findViewById(R.id.edthi1);
        mEdtbody11= findViewById(R.id.edtkg1);
        mEdtbody21= findViewById(R.id.edtbody1);
        mEdtbody31 = findViewById(R.id.edtbody11);
        mEdtbody41 = findViewById(R.id.edtbody21);
        mEdtbody51 = findViewById(R.id.edtbody31);
        mEdtbody61 = findViewById(R.id.edtbody41);
        mEdtbody71 = findViewById(R.id.edtbody51);
       //text1= findViewById(R.id.textView4);

        try {
            String result = MainActivityloginSQL.executeQuery1("SELECT * FROM `registered` where `id` = '"+TextView1.getText().toString()+"'");

         //   text1.setText("SELECT * FROM `registered` where `name` = '"+TextView1.getText().toString()+"'");

            JSONArray jsonArray = new JSONArray(result);
            if( Integer.parseInt(String.valueOf(jsonArray.length()))==1){ //已有偏好資料進行更新
                JSONArray jsonArray2 = new JSONArray(result);
                JSONObject jsonData = jsonArray2.getJSONObject(0);


                mEdtbody1.setText( jsonData.getString("name"));;
                mEdtbody11.setText( jsonData.getString("sex"));
                mEdtbody21.setText( jsonData.getString("Email"));
                mEdtbody31.setText( jsonData.getString("bird"));
                mEdtbody41.setText( jsonData.getString("claasss"));
                mEdtbody51.setText( jsonData.getString("parentname"));
                mEdtbody61.setText( jsonData.getString("nickname"));
                mEdtbody71.setText( jsonData.getString("phone"));


                      }
        }catch (Exception e) {
            // Log.e("log_tag", e.toString());
        }

    }
    private View.OnClickListener buttonhome = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(profile2.this, MainActivity.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }
    };


}
package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class profile2 extends AppCompatActivity {
    private Button btn1,btnhome,buttonupdate;
    private EditText mEdtkg1,mEdthi, mEdtBMI1, mEdtbody011,mEdtbody012,mEdtbody1,mEdtbody11,mEdtbody21,mEdtbody31,mEdtbody41,mEdtbody51,mEdtbody61,mEdtbody71,mEdtbody81,mEdtbody91;
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
        buttonupdate= findViewById(R.id.update1234);
        buttonupdate.setOnClickListener(button123);
        mEdtbody011 = findViewById(R.id.edtbody411);
        mEdtbody012 = findViewById(R.id.edtbody412);
        mEdtbody1 = findViewById(R.id.edthi1);
        mEdtbody11= findViewById(R.id.edtkg1);
        mEdtbody21= findViewById(R.id.edtbody1);
        mEdtbody31 = findViewById(R.id.edtbody11);
        mEdtbody41 = findViewById(R.id.edtbody21);
        mEdtbody51 = findViewById(R.id.edtbody31);

        mEdtbody71 = findViewById(R.id.edtbody51);
       //text1= findViewById(R.id.textView4);

        try {
            String result = MainActivityloginSQL.executeQuery1("SELECT * FROM `registered` where `id` = '"+TextView1.getText().toString()+"'");

         //   text1.setText("SELECT * FROM `registered` where `name` = '"+TextView1.getText().toString()+"'");

            JSONArray jsonArray = new JSONArray(result);
            if( Integer.parseInt(String.valueOf(jsonArray.length()))==1){ //已有偏好資料進行更新
                JSONArray jsonArray2 = new JSONArray(result);
                JSONObject jsonData = jsonArray2.getJSONObject(0);

                mEdtbody011.setText( jsonData.getString("id"));;
                mEdtbody012.setText( jsonData.getString("pwd"));
                mEdtbody1.setText( jsonData.getString("name"));;
                mEdtbody11.setText( jsonData.getString("sex"));
                mEdtbody21.setText( jsonData.getString("birth"));
                mEdtbody31.setText( jsonData.getString("dadparentsage"));
                mEdtbody41.setText( jsonData.getString("dadeducation"));
                mEdtbody51.setText( jsonData.getString("momparentsage"));
                mEdtbody71.setText( jsonData.getString("momeducation"));


                      }
        }catch (Exception e) {
            // Log.e("log_tag", e.toString());
        }

    }

    private View.OnClickListener button123 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String result0 = MainActivityloginSQL.executeQuery1("UPDATE registered SET `pwd`='"+mEdtbody012.getText().toString()+"' WHERE id = '"+TextView1.getText().toString()+"'");
            String result1 = MainActivityloginSQL.executeQuery1("UPDATE registered SET `name`='"+mEdtbody1.getText().toString()+"' WHERE id = '"+TextView1.getText().toString()+"'");
            String result2 = MainActivityloginSQL.executeQuery1("UPDATE registered SET `sex`='"+mEdtbody11.getText().toString()+"' WHERE id = '"+TextView1.getText().toString()+"'");
            String result3 = MainActivityloginSQL.executeQuery1("UPDATE registered SET `birth`='"+mEdtbody21.getText().toString()+"' WHERE id = '"+TextView1.getText().toString()+"'");
            String result4 = MainActivityloginSQL.executeQuery1("UPDATE registered SET `dadparentsage`='"+mEdtbody31.getText().toString()+"' WHERE id = '"+TextView1.getText().toString()+"'");
            String result5 = MainActivityloginSQL.executeQuery1("UPDATE registered SET `dadeducation`='"+mEdtbody41.getText().toString()+"' WHERE id = '"+TextView1.getText().toString()+"'");
            String result6 = MainActivityloginSQL.executeQuery1("UPDATE registered SET `momparentsage`='"+mEdtbody51.getText().toString()+"' WHERE id = '"+TextView1.getText().toString()+"'");
            String result7 = MainActivityloginSQL.executeQuery1("UPDATE registered SET `momeducation`='"+mEdtbody71.getText().toString()+"' WHERE id = '"+TextView1.getText().toString()+"'");


            Intent intent = new Intent(profile2.this, profile_choice.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            Toast toast = Toast.makeText(profile2.this, "修改成功", Toast.LENGTH_LONG);
            toast.show();
            startActivity(intent);//跳轉到倒計時頁面
        }
    };
    private View.OnClickListener buttonhome = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(profile2.this, MainActivity.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }
    };
}
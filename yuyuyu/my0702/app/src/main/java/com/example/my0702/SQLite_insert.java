package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
//註冊判斷
public class SQLite_insert extends AppCompatActivity {
    private TextView TextView00,TextView0,TextView1,TextView2,TextView3,TextView4,TextView5,TextView6,TextView7,TextView8;
    private String account,password,name,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_insert);
//取得傳遞過來的資料
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        TextView00 = (TextView)findViewById(R.id.textView91);
        TextView0 = (TextView)findViewById(R.id.textView89);
        TextView1 = (TextView)findViewById(R.id.textView800);
        TextView2 = (TextView)findViewById(R.id.textView8001);
        TextView3 = (TextView)findViewById(R.id.textView8002);
        TextView4 = (TextView)findViewById(R.id.textView8003);
        TextView5 = (TextView)findViewById(R.id.textView84);
        TextView6 = (TextView)findViewById(R.id.textView85);
        TextView7 = (TextView)findViewById(R.id.textView86);
        TextView8 = (TextView)findViewById(R.id.textView87);
        TextView00 .setText(bundle.getString("mmm1"));
        TextView0 .setText(bundle.getString("mmm2"));
        TextView1 .setText(bundle.getString("mm1"));
        TextView2 .setText(bundle.getString("mm2"));
        TextView3 .setText(bundle.getString("mm3"));
        TextView4 .setText(bundle.getString("mm4"));
        TextView5 .setText(bundle.getString("mm5"));
        TextView6 .setText(bundle.getString("mm6"));
        TextView7 .setText(bundle.getString("mm7"));
        TextView8 .setText(bundle.getString("mm8"));
        String type = "SQLite_insert";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,TextView00.getText().toString(),TextView0.getText().toString(),TextView1.getText().toString(),TextView2.getText().toString(),TextView3.getText().toString(),TextView4.getText().toString(),TextView5.getText().toString(),TextView6.getText().toString(),TextView7.getText().toString(),TextView8.getText().toString());
        Intent i = new Intent(SQLite_insert.this, MainActivity2__login.class);
        startActivity(i);
    }

}
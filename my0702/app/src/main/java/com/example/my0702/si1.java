/*
package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;


//註冊判斷
public class si1 extends AppCompatActivity  {
    private TextView TextView1,TextView2,TextView3,TextView4;
    private String account,password,name,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_insert1);

        //取得傳遞過來的資料
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        TextView1 = (TextView)findViewById(R.id.textView800);
        TextView2 = (TextView)findViewById(R.id.textView8001);
        //TextView3 = (TextView)findViewById(R.id.textView821);
        //TextView4 = (TextView)findViewById(R.id.textView831);


        TextView1 .setText(bundle.getString("mmm1"));
        TextView2 .setText(bundle.getString("mmm2"));
        //TextView3 .setText(bundle.getString("mmm3"));
       // TextView4 .setText(bundle.getString("mmm4"));
        String type = "si1";
        bgw1 backgroundWorker = new bgw1(this);
        backgroundWorker.execute(type,TextView1.getText().toString(),TextView2.getText().toString());
        //,TextView3.getText().toString(),TextView4.getText().toString()
        Intent i = new Intent(si1.this, SQLite.class);
        startActivity(i);
    }
}
*/
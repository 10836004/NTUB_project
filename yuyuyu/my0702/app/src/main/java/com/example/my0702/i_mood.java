package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.content.Context;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class i_mood extends AppCompatActivity {
    private TextView TextView1;
    final Context context = this;
    private Button button1234,button01234;
    private RadioButton radioButton;
    private ImageButton imageButton;
    private Boolean f_jumptolayout03 = false;
    private Integer layout_choice = 0;
    private RadioButton
            mRadioButton1,
            mRadioButton2,
            mRadioButton3,
            mRadioButton4,
            mRadioButton5,
            mRadioButton6,
            mRadioButton7;
     String a1;

    SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    SimpleDateFormat sDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
    String date = sDateFormat.format(new java.util.Date());
    String date1 = sDateFormat1.format(new java.util.Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood1);
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
        //取得傳遞過來的資料
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("account");
        TextView1 = findViewById(R.id.n1);
        TextView1.setText(loginname);
        button1234 = findViewById(R.id.mood1_back_button);
        button01234 = findViewById(R.id.mood1_next_button);
        button1234.setOnClickListener(btnAdd1OnClick1234);
        button01234.setOnClickListener(btnAdd1OnClick01234);
        mRadioButton1 = findViewById(R.id.one_button01);
        mRadioButton2 = findViewById(R.id.one_button02);
        mRadioButton3 = findViewById(R.id.one_button03);
        mRadioButton4 = findViewById(R.id.one_button04);
        mRadioButton5 = findViewById(R.id.one_button05);
        mRadioButton6 = findViewById(R.id.one_button06);
        mRadioButton7 = findViewById(R.id.one_button07);


    }
    private View.OnClickListener btnAdd1OnClick1234 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //SQLiteDatabase friendDb = mFriendDbopenHelp.getWritableDatabase();

            //ContentValues newRow = new ContentValues();
            //newRow.put("name", mEdtName.getText().toString());//加入一筆姓名資料
            //newRow.put("sex", mEdtSex.getText().toString());//加入一筆性別資料
            //newRow.put("address", mEdtAddr.getText().toString());//加入一筆帳號資料
            //newRow.put("password", mEdtpassword.getText().toString());//加入一筆密碼資料
            //friendDb.insert(DB_TABLE, null, newRow);
            //friendDb.close();
            /*try {
                String result = SQLite_insert.executeQuery("INSERT INTO `sport`.`login` (`account`, `password`, `name`, `gender`) VALUES ('"+mEdtName.getText().toString()+"', '"+mEdtSex.getText().toString()+"', '"+mEdtAddr.getText().toString()+"', '"+mEdtpassword.getText().toString()+"');");
            } catch(Exception e) {
                // Log.e("log_tag", e.toString());
            }*/

            Intent intent = new Intent(i_mood.this, MainActivity.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }
    };
    private View.OnClickListener btnAdd1OnClick01234 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mRadioButton1.isChecked()) {
                a1 = "1 怒氣沖沖失去理智";
            } else if(mRadioButton2.isChecked()) {
                a1 = "2 憤怒發脾氣";
            } else if(mRadioButton3.isChecked()) {
                a1 = "3 不高興";
            } else if(mRadioButton4.isChecked()) {
                a1 = "4 平靜";
            } else if(mRadioButton5.isChecked()) {
                a1 = "5 開心";
            } else if(mRadioButton6.isChecked()) {
                a1 = "6 興奮";
            } else if(mRadioButton7.isChecked()) {
                a1 = "7 非常快樂";
            }


            //String result1 = MainActivityloginSQL.executeQuery1("INSERT INTO `test20200901`.`imood` (`imood1`, `imood2`, `imood3`, `imood4`, `imood5`) VALUES ('\" + a1.getText().toString() +)");
            String result1 = MainActivityloginSQL.executeQuery1("INSERT INTO `test20200901`.`imood` (`id`,`datetime`,`date`,`imood1`) VALUES ('"+TextView1.getText().toString()+"','"+date+"','"+date1+"','"+a1+"')");

            Intent intent = new Intent(i_mood.this, imood2.class);
            //intent.putExtra("a1", a1.getText().toString());//"姓名:"
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }
    };
}



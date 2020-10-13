package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

//註冊頁面
public class s_q_lite1 extends AppCompatActivity {
    private TextView mn1;
    private TextView t1,t2,t3;
    private EditText mmm1,mmm2,mmm3,mmm4;
    private Button btn1;
    private Switch sw1;
    private String aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_q_lite);

        mmm1 = findViewById(R.id.name);
        mmm2 = findViewById(R.id.Email1);
        mmm3 = findViewById(R.id.bird);
        mmm4 = findViewById(R.id.claasss);
        Button btn1 = findViewById(R.id.button4321);
        btn1.setOnClickListener(btnAdd1OnClick1);

    }


    private View.OnClickListener btnAdd1OnClick1 = new View.OnClickListener() {
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

            Intent intent = new Intent(s_q_lite1.this, SQLite_insert.class);
            intent.putExtra("mmm1",  mmm1.getText().toString());        //傳入點選事件之項目
            intent.putExtra("mmm2",  mmm2.getText().toString());
            intent.putExtra("mmm3", mmm3.getText().toString());
            intent.putExtra("mmm4",  mmm4.getText().toString());


            startActivity(intent);//跳轉到倒計時頁面
        }
    };
//查詢
/*private View.OnClickListener btnQueryOnClick = new View.OnClickListener(){
    @Override
    public void onClick(View view){
        SQLiteDatabase friendDb = mFriendDbopenHelp.getWritableDatabase();
        Cursor c = null;
        if(!mEdtName.getText().toString().equals("")){
            c=friendDb.query(true,DB_TABLE,new String[]{"name","sex",
                    "address","password"},"name=" + "\""+
                    mEdtName.getText().toString()
                    +"\"",null,null,null,null,null);
        }else if(!mEdtSex.getText().toString().equals("")){
            c = friendDb.query(true,DB_TABLE,new String[]{"name","sex",
                    "address","password"},"sex=" + "\""+
                    mEdtSex.getText().toString()
                    +"\"",null,null,null,null,null);
        }else if (!mEdtAddr.getText().toString().equals("")) {
            c = friendDb.query(true,DB_TABLE,new String[]{"name","sex",
                    "address","password"}, "address="+ "\"" +
                    mEdtAddr.getText().toString()
                    + "\"",null,null,null,null,null);
        }else if (!mEdtpassword.getText().toString().equals("")) {
            c = friendDb.query(true,DB_TABLE,new String[]{"name","sex",
                    "address","password"},"password=" + "\"" +
                    mEdtpassword.getText().toString()
                    + "\"",null,null,null,null,null);
        }*/

//顯示
/*private  View.OnClickListener btnListOnClick = new View.OnClickListener(){
    @Override
    public void onClick(View view){
        SQLiteDatabase friendDb = mFriendDbopenHelp.getWritableDatabase();
        Cursor c = friendDb.query(true,DB_TABLE,new String[]{
                "name","sex", "address","password"},null,null,null,null,null,null);//顯示全部資料
        if(c==null)
            return;

        if(c.getCount()==0){
            mTxtList.setText("");
            Toast.makeText(SQLite.this,"沒有資料",Toast.LENGTH_LONG).show();
        }
        else {
            c.moveToFirst();
            mTxtList.setText(c.getString(0)+c.getString(1)+c.getString(2) + c.getString(3));

            while(c.moveToNext())
                mTxtList.append("\n" + c.getString(0) + c.getString(1) + c.getString(2) + c.getString(3));
        }
        friendDb.close();

       }
    };*/
};


























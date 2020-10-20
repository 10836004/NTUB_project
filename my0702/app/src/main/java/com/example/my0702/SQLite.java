package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;

import java.util.Calendar;

//註冊頁面
public class SQLite extends AppCompatActivity {
    private TextView TextView1,TextView2;
    private TextView t1,t2,t3;
    private RadioButton boy, girl,dad,mom;
    private EditText mm0,mm00,mm1,mm2,mm3,mm4,mm5,mm6,mm7,mm8;
    private Button btn1;
    private Switch sw1;
    private String aa;
    private String a11,a12;
    private Spinner Spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_q_lite);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("mmm1");
        String loginname1=bundle.getString("mmm2");
        TextView1 = findViewById(R.id.n1);
        TextView1.setText(loginname);
        TextView2 = findViewById(R.id.n2);
        TextView2.setText(loginname1);
        t1 = findViewById(R.id.n3);

        mm1 = findViewById(R.id.name);
        boy = findViewById(R.id.boy);
        girl = findViewById(R.id.girl);
        //mm2 = findViewById(R.id.sex);
        mm3 = findViewById(R.id.Email1);
        mm4 = findViewById(R.id.bird);
        //mm5 = findViewById(R.id.claasss);


        Spinner =findViewById(R.id.spinner2);
        final String[] grade = {"一年級", "二年級", "三年級", "四年級", "五年級", "六年級"};
        ArrayAdapter<String> dataAdapter;

        dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,grade);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner.setPrompt("選擇：");
        Spinner.setAdapter(dataAdapter);
        Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(adapterView.getItemAtPosition(i).equals("選擇")){

                }else{
                    String item = adapterView.getItemAtPosition(i).toString();

                    //Toast.makeText(adapterView.getContext(),"Selected:" + item,Toast.LENGTH_SHORT).show();

                    if(adapterView.getItemAtPosition(i).equals("一年級")) {
                        t1.setText("一年級");

                    }else if(adapterView.getItemAtPosition(i).equals("二年級")){
                        t1.setText("二年級");
                    }else if(adapterView.getItemAtPosition(i).equals("三年級")){
                        t1.setText("三年級");
                    }else if(adapterView.getItemAtPosition(i).equals("四年級")){
                        t1.setText("四年級");
                    }else if(adapterView.getItemAtPosition(i).equals("五年級")){
                        t1.setText("五年級");
                    }else if(adapterView.getItemAtPosition(i).equals("六年級")){
                        t1.setText("六年級");
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //TODO Auto-generated method stub
            }
        });
        t1.setText(t1.getText().toString());



        mm6 = findViewById(R.id.parentname);



        //mm7 = findViewById(R.id.nickname);
        dad = findViewById(R.id.dad);
        mom = findViewById(R.id.mom);


        mm8 = findViewById(R.id.phone);
        Button btn1 = findViewById(R.id.btnclass);
        btn1.setOnClickListener(btnAdd1OnClick);
        //TextView2.setText(grade[position]);
 }
    public void datePicker(View v){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                String dateTime = String.valueOf(year)+"-"+String.valueOf(month+1)+"-"+String.valueOf(day);
                mm4.setText(dateTime);
            }

        }, year, month, day).show();
    }
//新增資料
    private View.OnClickListener btnAdd1OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (boy.isChecked()) {
                a11 = "男";
            } else if (girl.isChecked()) {
                a11 = "女";
            }

            if (mom.isChecked()) {
                a12 = "媽媽";
            } else if (dad.isChecked()) {
                a12 = "爸爸";
            }



            if ( mm1.getText().toString().matches("")  || mm3.getText().toString().matches("") || mm4.getText().toString().matches("")  || mm6.getText().toString().matches("") || mm8.getText().toString().matches("")) {


                Toast toast = Toast.makeText(SQLite.this, "欄位不能是空白!!", Toast.LENGTH_LONG);
                toast.show();

            }  else{
                Intent intent = new Intent(SQLite.this, SQLite_insert.class);
                intent.putExtra("mmm1", TextView1.getText().toString());        //傳入點選事件之項目
                intent.putExtra("mmm2", TextView2.getText().toString());
                intent.putExtra("mm1", mm1.getText().toString());        //傳入點選事件之項目
                intent.putExtra("a11", a11);
                intent.putExtra("mm3", mm3.getText().toString());
                intent.putExtra("mm4", mm4.getText().toString());
                intent.putExtra("Spinner", t1.getText().toString());
                intent.putExtra("mm6", mm6.getText().toString());
                intent.putExtra("a12", a12);
                intent.putExtra("mm8", mm8.getText().toString());
                Toast toast = Toast.makeText(SQLite.this, "註冊成功，現在登入帳號使用i好心情吧!!", Toast.LENGTH_LONG);
                toast.show();
                startActivity(intent);//跳轉到倒計時頁面
            }
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













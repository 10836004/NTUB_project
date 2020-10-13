package com.example.my0702;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.*;
import android.database.Cursor;

import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.*;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

//身體資訊
public class LoginMain extends AppCompatActivity {
    private EditText mEdtkg, mEdthi,mEdtBMI, mEdtbody,mEdtbody1,mEdtbody2,mEdtbody3,mEdtbody4,mEdtbody5,mEdtbody6,mEdtbody7,mEdtbody8,mEdtbody9;
    private TextView mTxtList1,mn1,mn2,mn3,mn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
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
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = sDateFormat.format(new java.util.Date());
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("account");
///*--------------------------------------------------------------------------------------------
/*
 bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod =new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.home:
                    fragment = new HomeFragment();
                    break;
                case R.id.running:
                    fragment = new RunningFragment();
                    break;
                case R.id.eat:


                    break;
                case R.id.personal:
                    fragment = new PersonalFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            return true;
        }
    };
*/
//--------------------------------------------------------------------------------------------------
        mn1 = findViewById(R.id.n1);
        mn2 = findViewById(R.id.n2);
        mn3 = findViewById(R.id.n3);
        mEdthi = findViewById(R.id.edthi);
        mEdtkg = findViewById(R.id.edtkg);
        mn4 = findViewById(R.id.n4);
        mn4.setText(loginname);
        mEdtBMI = findViewById(R.id.edtBMI);
        mEdtbody = findViewById(R.id.edtbody);
        mEdtbody1 = findViewById(R.id.edtbody1);
        mEdtbody2 = findViewById(R.id.edtbody2);
        mEdtbody3 = findViewById(R.id.edtbody3);
        mEdtbody4 = findViewById(R.id.edtbody4);
        mEdtbody5 = findViewById(R.id.edtbody5);
        mEdtbody6 = findViewById(R.id.edtbody6);
        mEdtbody7 = findViewById(R.id.edtbody7);
        mEdtbody8 = findViewById(R.id.edtbody8);
        mEdtbody9 = findViewById(R.id.edtbody9);
        mTxtList1 = findViewById(R.id.txtList1);
        mn1 = findViewById(R.id.n1);
        mn2 = findViewById(R.id.n2);

        //------------------------------------------------------------------------
        try {
            String result1 = LoginMain_SQL1.executeQuery("SELECT * FROM `myselfnews` where `account` = '"+mn4.getText().toString()+"'and  `date`='"+date+"'");

            int a= result1.indexOf("off");
            if(a>-1){  //判斷無資料

             Intent intent1 = new Intent(LoginMain.this, LoginMain1.class);
                intent1.putExtra("account", mn4.getText().toString());//"姓名:"
                startActivity(intent1);//註冊會員執行跳頁
            }

            JSONArray jsonArray1 = new JSONArray(result1);
            if( Integer.parseInt(String.valueOf(jsonArray1.length()))==1) {
                JSONObject jsonData = jsonArray1.getJSONObject(0);
                mEdthi.setText(jsonData.getString("high"));
                mEdtkg.setText(jsonData.getString("kg"));
                mEdtbody.setText(jsonData.getString("body"));
                mEdtbody1.setText(jsonData.getString("body1"));
                mEdtbody2.setText(jsonData.getString("body2"));
                mEdtbody3.setText(jsonData.getString("body3"));
                mEdtbody4.setText(jsonData.getString("body4"));
                mEdtbody5.setText(jsonData.getString("body5"));
                mEdtbody6.setText(jsonData.getString("body6"));
                mEdtbody7.setText(jsonData.getString("body7"));
                mEdtbody8.setText(jsonData.getString("body8"));
                mEdtbody9.setText(jsonData.getString("body9"));
                mn1.setText(jsonData.getString("account"));

            //計算BMI-----------------------------------------------------------------------------------------
            float fh = Float.parseFloat(mEdthi.getText().toString());      // 取得 身高輸入值
            float fw = Float.parseFloat(mEdtkg.getText().toString());     // 取得 體重輸入值
            float fresult;                                     // BMI值 計算結果
            TextView result = (TextView)findViewById(R.id.edtBMI);// 取得 顯示結果 物件
            fh = fh/100; // 計算BMI
            fh = fh*fh;  // 計算BM
            NumberFormat nf = NumberFormat.getInstance();   // 數字格式
            nf.setMaximumFractionDigits(2);                 // 限制小數第二位
            fresult = fw/fh;                                // 計算BMI
            result.setText(nf.format(fw/fh) +"");           // 顯示BMI計算結果
            TextView dia = (TextView)findViewById(R.id.BMItext);// 取得 顯示診斷 物件

            // 診斷結果 顯示
            if (fresult<18.5) {
                dia.setText("體重過輕");
                dia.setTextColor(Color.parseColor("#FF5151"));//设置颜色
                dia.setTextSize(30);//设置字体大小
            }
            else if (18.5 <= fresult && fresult< 24) {
                dia.setText("正常範圍");
                dia.setTextColor(Color.parseColor("#28FF28"));//设置颜色
                dia.setTextSize(30);//设置字体大小
            } else if (24 <=fresult && fresult < 27) {
                dia.setText("過    重");
                dia.setTextColor(Color.parseColor("#FF5151"));//设置颜色
                dia.setTextSize(30);//设置字体大小
            }else if (27 <=fresult && fresult < 30) {
                dia.setText("輕度肥胖");
                dia.setTextColor(Color.parseColor("#FF2D2D"));//设置颜色
                dia.setTextSize(30);//设置字体大小
            } else if (30 <= fresult && fresult < 35) {
                dia.setText("中度肥胖");
                dia.setTextColor(Color.parseColor("#FF0000"));//设置颜色
                dia.setTextSize(30);//设置字体大小
            } else if (fresult >= 35) {
                dia.setText("重度肥胖");
                dia.setTextColor(Color.parseColor("#EA0000"));//设置颜色
                dia.setTextSize(30);//设置字体大小
            }





            }
        } catch(Exception e){
            // Log.e("log_tag", e.toString());
        }

//----------------------------------------------------------------------------------------------------


        Button btnAdd1 = findViewById(R.id.btnAdd1);

       btnAdd1.setOnClickListener(btnAdd1OnClick);

    }


    //新增資料
    private View.OnClickListener btnAdd1OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            try {
                String result2 = LoginMain_SQL.executeQuery1( mn1.getText().toString() , mEdtkg.getText().toString() , mEdthi.getText().toString(), mEdtBMI.getText().toString(), mEdtbody.getText().toString(), mEdtbody1.getText().toString(), mEdtbody2.getText().toString(), mEdtbody3.getText().toString(), mEdtbody4.getText().toString(), mEdtbody5.getText().toString(), mEdtbody6.getText().toString(), mEdtbody7.getText().toString(), mEdtbody8.getText().toString(), mEdtbody9.getText().toString() );

                Intent intent1 = new Intent(LoginMain.this, LoginMain.class);
                intent1.putExtra("account", mn1.getText().toString());//"姓名:"
                intent1.putExtra("address", mn2.getText().toString() );//"帳號:"
                intent1.putExtra("kg", mEdtkg.getText().toString()  );//"體重:"
                intent1.putExtra("hi", mn4.getText().toString() );//"身高:"
                intent1.putExtra("body", mEdtbody.getText().toString() );//"body:"
                intent1.putExtra("body1",mEdtbody1.getText().toString() );//"body1:"
                intent1.putExtra("body2",mEdtbody2.getText().toString());//"body2:"
                intent1.putExtra("body3",mEdtbody3.getText().toString() );//"body3:"
                intent1.putExtra("body4",mEdtbody4.getText().toString() );//"body4:"
                intent1.putExtra("body5",mEdtbody5.getText().toString());;//"body5:"
                intent1.putExtra("body6",mEdtbody6.getText().toString() );;//"body6:"
                intent1.putExtra("body7",mEdtbody7.getText().toString() );;//"body7:"
                intent1.putExtra("body8",mEdtbody8.getText().toString() );;//"body8:"
                intent1.putExtra("body9",mEdtbody9.getText().toString() );;//"body9:"
                startActivity(intent1);//切換Activity執行跳頁


            } catch (Exception e) {
                // Log.e("log_tag", e.toString());
            }






        }
    };

}
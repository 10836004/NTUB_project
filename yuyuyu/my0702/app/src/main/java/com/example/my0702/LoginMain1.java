package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;
import android.content.*;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.text.NumberFormat;
//身體資訊
public class LoginMain1 extends AppCompatActivity {
    private  static final String DB_FILE = "friends.db";//資料庫
    private static final String DB_TABLE1 = "Bodyinformation";//資料表
    private EditText mEdtkg1,mEdthi, mEdtBMI1, mEdtbody1,mEdtbody11,mEdtbody21,mEdtbody31,mEdtbody41,mEdtbody51,mEdtbody61,mEdtbody71,mEdtbody81,mEdtbody91;
    private TextView a1,a2;
    SQLiteDatabase db;    //資料庫
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main1);
        db=openOrCreateDatabase(DB_FILE, Context.MODE_PRIVATE, null);

        //取得傳遞過來的資料
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("account");
        String name1=bundle.getString("name");
        String address1=bundle.getString("address");
        String kg1=bundle.getString("kg");
        String hi1=bundle.getString("hi");
        String BMI1=bundle.getString("BMI");
        String body1=bundle.getString ("body" );
        String body11=bundle.getString ("body1");
        String body21=bundle.getString ("body2");
        String body31=bundle.getString ("body3");
        String body41=bundle.getString ("body4");
        String body51=bundle.getString ("body5");
        String body61=bundle.getString ("body6");
        String body71=bundle.getString ("body7");
        String body81=bundle.getString ("body8");
        String body91=bundle.getString ("body9");

        //ˋ抓取layout的id宣告轉換
        mEdthi= findViewById(R.id.edthi1);
        a1 = findViewById(R.id.n3);
        a2= findViewById(R.id.n4);
        a1.setText(loginname);
        mEdtkg1 = findViewById(R.id.edtkg1);

        mEdtbody1 = findViewById(R.id.edtbody1);
        mEdtbody11= findViewById(R.id.edtbody11);
        mEdtbody21= findViewById(R.id.edtbody21);
        mEdtbody31 = findViewById(R.id.edtbody31);
        mEdtbody41 = findViewById(R.id.edtbody41);
        mEdtbody51 = findViewById(R.id.edtbody51);
        mEdtbody61 = findViewById(R.id.edtbody61);
        mEdtbody71 = findViewById(R.id.edtbody71);
        mEdtbody81 = findViewById(R.id.edtbody81);
        mEdtbody91 = findViewById(R.id.edtbody91);
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

        Button btnAdd1 = findViewById(R.id.btnAdd11);

        btnAdd1.setOnClickListener(btnAdd1OnClick);
    }


    private View.OnClickListener btnAdd1OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            try {
                String result2 = LoginMain1_SQL.executeQuery1( a1.getText().toString() , mEdtkg1.getText().toString() , mEdthi.getText().toString(), mEdtbody1.getText().toString(), mEdtbody11.getText().toString(), mEdtbody21.getText().toString(), mEdtbody31.getText().toString(), mEdtbody41.getText().toString(), mEdtbody51.getText().toString(), mEdtbody61.getText().toString(), mEdtbody71.getText().toString(), mEdtbody81.getText().toString(), mEdtbody91.getText().toString() );

                Intent intent1 = new Intent(LoginMain1.this, LoginMain.class);
                intent1.putExtra("account", a1.getText().toString());//"姓名:"
                startActivity(intent1);//切換Activity執行跳頁


            } catch (Exception e) {
                // Log.e("log_tag", e.toString());
            }






        }
    };

}
package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.*;

import org.json.JSONArray;

//偏好設定
public class Preference extends AppCompatActivity {

    private CheckBox mSlimming, mfitness, mshaping, mspfitness;
    private EditText mhi, mkgg;
    private RadioButton mtakeout, mtakein, mdoorin, mdoorout;
    private TextView mn5, mn6, mn7, mTxtList11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
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
        String loginname = bundle.getString("account");
        mhi = (EditText) findViewById(R.id.hi);
        mkgg = findViewById(R.id.kgg);
        mdoorin = findViewById(R.id.doorin);
        mdoorout = findViewById(R.id.doorout);
        mSlimming = findViewById(R.id.Slimming);
        mfitness = findViewById(R.id.fitness);
        mshaping = findViewById(R.id.shaping);
        mspfitness = findViewById(R.id.spfitness);
        mtakeout = findViewById(R.id.takeout);
        mtakein = findViewById(R.id.takein);

        mn5 = findViewById(R.id.n5);
        mn5.setText(loginname);
        mn6 = findViewById(R.id.n6);
        mn7 = findViewById(R.id.n7);
        Button preference = findViewById(R.id.btn_preference);

        preference.setOnClickListener(btnpreferenceOnClick);

    }

    String a1, a2;
    int a3, a4, a5, a6;
    private View.OnClickListener btnpreferenceOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            try {
                String result = Preference_SQL.executeQuery1("INSERT INTO `sport`.`login` (`account`) VALUES ('" + mn5.getText().toString() + "');");
                String result2 = Preference_BMI.executeQuery1( mn5.getText().toString() ,mhi.getText().toString() ,mkgg.getText().toString() );

                if (mdoorin.isChecked()) {
                    a1 = "室內";
                } else {
                    a1 = "室外";
                }
                if (mSlimming.isChecked()){
                    a3 = 1;
                }
                if (mfitness.isChecked()){
                    a4 = 1;
                }
                if (mshaping.isChecked()){
                    a5 = 1;
                }
                if (mspfitness.isChecked()){
                    a6 = 1;
                }

                if (mtakeout.isChecked()) {
                    a2 = "外食";
                } else {
                    a2 = "自煮";
                }

                String result1 = Perference_SQL_pre.executeQuery1("INSERT INTO `sport`.`preference` (`account`, `sportplace`, `slimming`, `fitness`, `shaping`, `strengthen`, `foodplace`, `public`) VALUES ('" + mn5.getText().toString() + "', '" + a1 + "', '" + a3 + "', '" + a4 + "', '"+ a5 + "', '" + a6 + "', '" + a2 + "', '1')");
                Intent intent1 = new Intent(Preference.this, LoginMain.class);
                intent1.putExtra("account", mn5.getText().toString());//"姓名:"
                intent1.putExtra("hi", mhi.getText().toString());//"姓名:"
                intent1.putExtra("kg", mkgg.getText().toString());//"姓名:"
                startActivity(intent1);//註冊會員執行跳頁

            } catch (Exception e) {
                // Log.e("log_tag", e.toString());
            }

        }


    };

}














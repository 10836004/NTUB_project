package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import java.text.SimpleDateFormat;
public class calender_mood extends AppCompatActivity {
    private TextView TextView1;
    private TextView t1,t2,t3;
    private EditText mmm1,mmm2,mmm3,mmm4;
    private Button btn1,btn0;
    private ImageButton imageButton;
    private Switch sw1;
    private String aa;
    private RadioButton
            mRadioButton1,
            mRadioButton2,
            mRadioButton3,
            mRadioButton4,
            mRadioButton5,
            mRadioButton6;

    SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    SimpleDateFormat sDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
    String date = sDateFormat.format(new java.util.Date());
    String date1 = sDateFormat1.format(new java.util.Date());
    String ac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender_mood);

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
        btn0 = findViewById(R.id.btn17);
        btn1 = findViewById(R.id.btn18);
        btn0.setOnClickListener(buttonhome);
        btn1.setOnClickListener(btnAdd1OnClick12345);
        mRadioButton1 = findViewById(R.id.btn_excited);
        mRadioButton2 = findViewById(R.id.btn_happy);
        mRadioButton3 = findViewById(R.id.btn_good);
        mRadioButton4 = findViewById(R.id.btn_bad2);
        mRadioButton5 = findViewById(R.id.btn_angry2);
        mRadioButton6 = findViewById(R.id.btn_mad2);
    }
    private View.OnClickListener btnAdd1OnClick12345 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mRadioButton1.isChecked()) {
                ac = "6 興奮";
            } else if (mRadioButton2.isChecked()) {
                ac = "5 開心";
            } else if (mRadioButton3.isChecked()) {
                ac = "4 良好";
            } else if (mRadioButton4.isChecked()) {
                ac = "3 差勁";
            } else if (mRadioButton5.isChecked()) {
                ac = "2 生氣";
            } else if (mRadioButton6.isChecked()) {
                ac = "1 惱火";

            }


                String result1 = MainActivityloginSQL.executeQuery1("INSERT INTO `test20200901`.`calender` (`id`,`mood`,`datetime`,`date`) VALUES ('"+TextView1.getText().toString()+"','"+ac+"','"+date+"','"+date1+"')");
                Intent intent = new Intent(calender_mood.this, calender.class);
                //intent.putExtra("mmm1",  mmm1.getText().toString());        //傳入點選事件之項目
                //intent.putExtra("mmm2",  mmm2.getText().toString());
                //intent.putExtra("mmm3", mmm3.getText().toString());
                //intent.putExtra("mmm4",  mmm4.getText().toString());

                intent.putExtra("account", TextView1.getText().toString());//"姓名:"
                startActivity(intent);//跳轉到倒計時頁面
            }

    };

    private View.OnClickListener buttonhome= new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent(calender_mood.this, MainActivity.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }

    };
}

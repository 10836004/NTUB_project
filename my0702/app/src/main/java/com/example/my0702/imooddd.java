package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import android.os.Bundle;

public class imooddd extends AppCompatActivity {
    private int[] x = new int[1000];
    private TextView ft1,ft2,ft3,ft4,ft5,ft6,ft7,ft8,TextView1;
    private LinearLayout line_fragment_hot_main;
    private Button btn1,btnhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imooddd);
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
        btnhome= findViewById(R.id.button);
        btnhome.setOnClickListener(buttonhome);


        line_fragment_hot_main = (LinearLayout)findViewById(R.id.line_fragment_hot_main);

        try {
            String result = MainActivityloginSQL.executeQuery1("SELECT * FROM `imood` where `id` = '"+TextView1.getText().toString()+"' ");


            JSONArray jsonArray = new JSONArray(result);

            for(int i=0;i<jsonArray.length();i++  ) {
                JSONObject jsonData = jsonArray.getJSONObject(i);
                //設定每個item最外層的LinearLayout
                final LinearLayout itemMain = new LinearLayout(this);
                itemMain.setId(Integer.parseInt(jsonData.getString("idid")));
                itemMain.setOrientation(LinearLayout.HORIZONTAL); //設定linearLayout是橫向還是豎各
                LinearLayout.LayoutParams itemMainparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dip2px(this, 100)); //設定寬與高
                itemMainparams.setMargins(0,dip2px(this,14),0,0); //設定每個item與上一個控制元件的間隔是1dip
                itemMain.setLayoutParams(itemMainparams);
                itemMain.setBackgroundColor(Color.parseColor("#B088FF")); //設定背景色
                itemMain.setVerticalGravity(Gravity.CENTER); //設定對齊方式

                itemMain.findViewById(Integer.parseInt(jsonData.getString("idid"))).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        Intent intent1 = new Intent(imooddd.this, updateimood.class);
                        intent1.putExtra("idid", itemMain.getId());
                        intent1.putExtra("id", TextView1.getText().toString());
                        startActivity(intent1);//切換Activity執行跳頁
                    }
                });


                //設定中間文字顯示LinearLayout
                LinearLayout itemtext = new LinearLayout(this);
                itemtext.setOrientation(LinearLayout.VERTICAL);
                LinearLayout.LayoutParams itemtextparams = new LinearLayout.LayoutParams(250, dip2px(this, 150), 1);
                itemtext.setLayoutParams(itemtextparams);
                itemtext.setVerticalGravity(Gravity.CENTER_VERTICAL);
                TextView txtOne = new TextView(this);
                txtOne.setText(jsonData.getString("datetime"));
                txtOne.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20); //設定字號，並且設定它的單位為dip
                txtOne.getPaint().setFakeBoldText(true); //字型加租
                LinearLayout.LayoutParams txtOneparams = new LinearLayout.LayoutParams(dip2px(this, ViewGroup.LayoutParams.WRAP_CONTENT), dip2px(this, ViewGroup.LayoutParams.WRAP_CONTENT));
                txtOneparams.weight = 0;
                txtOneparams.setMargins(0, 0, 0, 0);
                txtOneparams.gravity = Gravity.LEFT;
                txtOne.setBackgroundColor(1);
                txtOne.setLayoutParams(txtOneparams);
                itemtext.addView(txtOne);
                /*
                //---------------------------
                TextView txtTwo = new TextView(this);
                txtTwo.setText(jsonData.getString("id"));
                txtTwo.getPaint().setFakeBoldText(true);
                txtTwo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                LinearLayout.LayoutParams txtTwoparams = new LinearLayout.LayoutParams(dip2px(this, ViewGroup.LayoutParams.WRAP_CONTENT), dip2px(this, ViewGroup.LayoutParams.WRAP_CONTENT));
                txtTwoparams.weight = 0;
                txtTwo.setLayoutParams(txtTwoparams);
                itemtext.addView(txtTwo);
                //---------------------------
                TextView txtThree = new TextView(this);
                txtThree.setText(jsonData.getString("weather"));
                txtThree.getPaint().setFakeBoldText(true);
                txtThree.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                LinearLayout.LayoutParams txttxtThreeparams = new LinearLayout.LayoutParams(dip2px(this, ViewGroup.LayoutParams.WRAP_CONTENT), dip2px(this, ViewGroup.LayoutParams.WRAP_CONTENT));
                txttxtThreeparams.weight = 0;
                txtThree.setLayoutParams(txttxtThreeparams);
                itemtext.addView(txtThree);
                //---------------------------
                TextView txtfour = new TextView(this);
                txtfour.setText(jsonData.getString("idid"));
                txtfour.getPaint().setFakeBoldText(true);
                txtfour.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                txtfour.setBackgroundColor(1);
                LinearLayout.LayoutParams txttxttxtfourparams = new LinearLayout.LayoutParams(dip2px(this, ViewGroup.LayoutParams.WRAP_CONTENT), dip2px(this, ViewGroup.LayoutParams.WRAP_CONTENT));
                txttxttxtfourparams.weight = 0;
                txtfour.setLayoutParams(txttxttxtfourparams);
                itemtext.addView(txtfour);
                */
                itemMain.addView(itemtext);

                //定義右側顯示資訊框架
                LinearLayout line_right_text = new LinearLayout(this);
                line_right_text.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams rightparams = new LinearLayout.LayoutParams(0, dip2px(this, 70), 1);
                line_right_text.setLayoutParams(rightparams);
                line_right_text.setGravity(Gravity.RIGHT);  //右對齊

                itemMain.addView(line_right_text);
                line_fragment_hot_main.addView(itemMain);
            }
        } catch(Exception e) {
            // Log.e("log_tag", e.toString());
        }

    }

    public static int dip2px(Context context, float dipValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale  * 0.5f);
    }

    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale  * 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale  * 0.5f);
    }
    private View.OnClickListener buttonhome = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(imooddd.this, profile_choice.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }
    };
}

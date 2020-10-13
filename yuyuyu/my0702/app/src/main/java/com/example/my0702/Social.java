package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import org.json.JSONArray;
import org.json.JSONObject;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;



import java.util.ArrayList;
import java.util.List;
//個人資訊
public class Social extends AppCompatActivity {
    private TableRow TR_inTR1;
    private Spinner sp_choose;
    private TextView mn1,mn2,mn3,mn4,mn5;
   private ImageView page1;
   private Button But2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);
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
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("account");
        page1=findViewById(R.id.social_image);
        mn1= findViewById(R.id.social_name);
        mn2= findViewById(R.id.social_text);
        mn3 = findViewById(R.id.textView52);
        mn3.setText(loginname);
        But2 = findViewById(R.id.button2);
        mn4 = findViewById(R.id.message1text);
        mn5 = findViewById(R.id.message1sport);

        try {
            String result = MainActivityloginSQL.executeQuery1("SELECT * FROM login left join myselfe on `login`.`account`=`myselfe`.`account` where `login`.`account`='"+mn3.getText().toString()+"'");
            JSONArray jsonArray = new JSONArray(result);
            JSONObject jsonData = jsonArray.getJSONObject(0);

            mn1.setText(jsonData.getString("name"));
            mn2.setText(jsonData.getString("Introduction"));


        }
        catch(Exception e){
        // Log.e("log_tag", e.toString());
    }


        sp_choose = (Spinner) findViewById(R.id.spinner);
        List<String> categories = new ArrayList<>();
        categories.add(0,"個人");
        categories.add("好友");
        categories.add("我看一下喔");

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_choose.setAdapter(dataAdapter);
        sp_choose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(adapterView.getItemAtPosition(i).equals("選擇")){

                }else{
                    String item = adapterView.getItemAtPosition(i).toString();

                    Toast.makeText(adapterView.getContext(),"Selected:" + item,Toast.LENGTH_SHORT).show();

                     if(adapterView.getItemAtPosition(i).equals("好友")) {
                         Intent intent  = new Intent(Social.this,Select_spinner1.class);
                         startActivity(intent);
                     }else if(adapterView.getItemAtPosition(i).equals("我看一下喔")){
                         Intent intent  = new Intent(Social.this,Select_spinner2.class);
                         startActivity(intent);
                     }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                   //TODO Auto-generated method stub
            }
        });


        TabLayout tabLayout = findViewById(R.id.tabBar1);
        TabItem tabmessage1 =findViewById(R.id.tabmessage1);
        TabItem tabmessage2 =findViewById(R.id.tabmessage2);
        final ViewPager viewPager1 = findViewById(R.id.viewPager1);



        PagerAdaptermessage pagerAdapter = new PagerAdaptermessage(getSupportFragmentManager(),tabLayout.getTabCount());

        viewPager1.setAdapter(pagerAdapter);

       tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               viewPager1.setCurrentItem(tab.getPosition());
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });
        But2.setOnClickListener(btnAdd1OnClick);

    }

    private View.OnClickListener btnAdd1OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent1 = new Intent(Social.this, changIntroduction.class);
            intent1.putExtra("account", mn3.getText().toString());//"姓名:"
            startActivity(intent1);//切換Activity執行跳頁

        }
    };

}

package com.example.my0702;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONObject;

//菜單頁面
public class infood extends AppCompatActivity {
    private TableRow TR_inTR1;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infood);
        TabLayout tabLayout = findViewById(R.id.tabBar);
        TabItem tabChats = findViewById(R.id.tabCgats);
        TabItem tabStatus = findViewById(R.id.tabStatus);
        final ViewPager viewPager = findViewById(R.id.viewPager);
        /*ft1=(TextView)findViewById(R.id.textView20);
        ft2=(TextView)findViewById(R.id.textView21);*/
        /*bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);*/
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
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
    //自煮
    public void rowClick(View view) {
        switch(view.getId()) {
            case R.id.inTR1:
                // Load image from Drawable folder
                Intent intent1 = new Intent(infood.this, foodinside.class);
                intent1.putExtra("id", 1);
                startActivity(intent1);//切換Activity執行跳頁
                break;
            case R.id.inTR2:
                // Load image from Drawable folder
                Intent intent2 = new Intent(infood.this, foodinside.class);
                intent2.putExtra("id", 2);
                startActivity(intent2);//切換Activity執行跳頁
                break;
            case R.id.inTR3:
                // Load image from Drawable folder
                Intent intent3 = new Intent(infood.this, foodinside.class);
                intent3.putExtra("id", 3);
                startActivity(intent3);//切換Activity執行跳頁
                break;
            case R.id.inTR4:
                // Load image from Drawable folder
                Intent intent4 = new Intent(infood.this, foodinside.class);
                intent4.putExtra("id", 4);
                startActivity(intent4);//切換Activity執行跳頁
                break;
        }
    }
    //外食
    public void rowClick1(View view) {
        switch(view.getId()) {
            case R.id.outTR1:
                // Load image from Drawable folder
                Intent intent1 = new Intent(infood.this, foodinside.class);
                startActivity(intent1);//切換Activity執行跳頁
                break;
            case R.id.outTR2:
                // Load image from Drawable folder
                Intent intent2 = new Intent(infood.this, foodinside.class);
                startActivity(intent2);//切換Activity執行跳頁
                break;
            case R.id.outTR3:
                // Load image from Drawable folder
                Intent intent3 = new Intent(infood.this, foodinside.class);
                startActivity(intent3);//切換Activity執行跳頁
                break;
            case R.id.outTR4:
                // Load image from Drawable folder
                Intent intent4 = new Intent(infood.this, foodinside.class);
                startActivity(intent4);//切換Activity執行跳頁
                break;
        }
    }
}
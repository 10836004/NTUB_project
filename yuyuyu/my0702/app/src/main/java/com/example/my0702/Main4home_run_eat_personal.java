package com.example.my0702;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
//功能選單
public class Main4home_run_eat_personal extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4home_run_eat_personal);



       // button1.setOnClickListener((View.OnClickListener) bottomNavMethod);
        // button1 = (Button) findViewById(R.id.btn_m4food);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
  //     bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
  //         @Override
  //         public boolean onNavigationItemSelected(@NonNull MenuItem item) {
  //             switch (item.getItemId()) {
  //                 case R.id.home:

  //                     break;
  //                 case R.id.running:

  //                     break;
  //                 case R.id.eat:


  //                     break;
  //                 case R.id.personal:
  //                     Intent intent = new Intent(Main4home_run_eat_personal.this, Social.class);
  //                     startActivity(intent);//切換Activity執行跳頁
  //                     break;

  //             }
  //             return false;
  //         }
  //     });

    }

  private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new
          BottomNavigationView.OnNavigationItemSelectedListener() {

              @Override

              public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                  Fragment fragment = null;
                  switch (menuItem.getItemId()) {
                      case R.id.home:
                          fragment = new HomeFragment();
                          break;
                      case R.id.running:
                          fragment = new RunningFragment();
                          break;
                      case R.id.eat:

                          fragment = new EatFragment();
                          break;
                      case R.id.personal:
                          fragment = new PersonalFragment();
                          break;

                  }
                  getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                  return true;
              }
          };


   /* public void click (View v){
//具體判斷點選的是哪個按鈕
        switch (v.getId()) {
            case R.id.btn_m4food://代表點選第一個按鈕
                Intent intent1 = new Intent(Main4home_run_eat_personal.this, infood.class);
                startActivity(intent1);//切換Activity執行跳頁
                break;

        }

    }*/

}
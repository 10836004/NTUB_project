package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2__login extends AppCompatActivity {
    private Button btn1,button2;
    private EditText ed1,ed2;
    com.example.my0702.HomeWatcher mHomeWatcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2__login);

        ed1= findViewById(R.id.userid);
        ed2= findViewById(R.id.passwd);
        btn1= findViewById(R.id.buttonlogin);
        btn1.setOnClickListener(buttonlogin);
        button2 = (Button) findViewById(R.id.button6);//把UI介面的東西叫過來
        button2.setOnClickListener(buttonsq1);



        //BIND Music Service
        doBindService();
        Intent music = new Intent();
        music.setClass(this, com.example.my0702.MusicService.class);
        startService(music);

        //Start HomeWatcher
        mHomeWatcher = new com.example.my0702.HomeWatcher(this);
        mHomeWatcher.setOnHomePressedListener(new com.example.my0702.HomeWatcher.OnHomePressedListener() {
            @Override
            public void onHomePressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }
            @Override
            public void onHomeLongPressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }
        });
        mHomeWatcher.startWatch();



    }

    //Bind/Unbind music service
    private boolean mIsBound = false;
    private com.example.my0702.MusicService mServ;
    private ServiceConnection Scon =new ServiceConnection(){

        public void onServiceConnected(ComponentName name, IBinder
                binder) {
            mServ = ((com.example.my0702.MusicService.ServiceBinder)binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService(){
        bindService(new Intent(this, com.example.my0702.MusicService.class),
                Scon, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService()
    {
        if(mIsBound)
        {
            unbindService(Scon);
            mIsBound = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mServ != null) {
            mServ.resumeMusic();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Detect idle screen
        PowerManager pm = (PowerManager)
                getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = false;
        if (pm != null) {
            isScreenOn = pm.isScreenOn();
        }

        if (!isScreenOn) {
            if (mServ != null) {
                mServ.pauseMusic();
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        //UNBIND music service
        doUnbindService();
        Intent music = new Intent();
        music.setClass(this, com.example.my0702.MusicService.class);
        stopService(music);

    }





    private View.OnClickListener buttonlogin= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (ed1.getText().toString().matches("") || ed2.getText().toString().matches("")) {


                Toast toast = Toast.makeText(MainActivity2__login.this, "欄位不能是空白!!", Toast.LENGTH_LONG);
                toast.show();
            //}else if (ed1.getText().toString().matches("").equals("id.getText().toString)")){


                    //Toast toast = Toast.makeText(MainActivity2__login.this, "欄位不能是空白!!", Toast.LENGTH_LONG);
                    //toast.show();
            } else {
                Intent intent = new Intent(MainActivity2__login.this, loginadd.class);
                intent.putExtra("ed1", ed1.getText().toString());        //傳入點選事件之項目
                intent.putExtra("ed2", ed2.getText().toString());
                startActivity(intent);//跳轉到倒計時頁面
            }

        }

    };
    private View.OnClickListener buttonsq1= new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent(MainActivity2__login.this, sq1.class);
            startActivity(intent);//跳轉到倒計時頁面
        }
    };

}
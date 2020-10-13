package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;
import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

//主畫面
public class MainActivity extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5,buttonlogout;

    //static final String DB_FILE = "friends.db";//資料庫
    //static final String DB_TABLE = "friends";//資料表
    //SQLiteDatabase db;    //資料庫
    private EditText  midtAddr,midpassword;
    private TextView TextView1,TextView2;

    // 開啟或建立資料庫
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //取得傳遞過來的資料
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("account");
        TextView1 = findViewById(R.id.textView5);
        TextView1.setText(loginname);
/*
        midtAddr = findViewById(R.id.userid);
        midpassword = findViewById(R.id.passwd);
        Button loginbtn = findViewById(R.id.buttonlogin);
        loginbtn.setOnClickListener(loginbtnOnClick);
*/
        buttonlogout= (Button) findViewById(R.id.buttonlogout);//把UI介面的東西叫過來
        button1 = (Button) findViewById(R.id.button7);//把UI介面的東西叫過來

        button3 = (Button) findViewById(R.id.button8);//把UI介面的東西叫過來
        button4 = (Button) findViewById(R.id.button9);//把UI介面的東西叫過來
        button5 = (Button) findViewById(R.id.button10);//把UI介面的東西叫過來
       /* button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Preference.class);
                String str = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
                StringBuffer sb = new StringBuffer();
                int len = 6;
                for (int i = 0; i < len; i++) {
                    int idx = (int)(Math.random() * str.length());
                    sb.append(str.charAt(idx));
                }
                intent.putExtra("name", sb.toString());//"姓名:"
                startActivity(intent);//訪客登入執行跳頁
            }
        });*/
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, calender_mood.class);
                intent.putExtra("account", TextView1.getText().toString());//"姓名:"
                startActivity(intent);//跳轉至心情日記頁面
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, profile_choice.class);
                intent.putExtra("account", TextView1.getText().toString());//"姓名:"
                startActivity(intent);//跳轉至個人專區頁面
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, i_mood.class);
                intent.putExtra("account", TextView1.getText().toString());//"姓名:"
                startActivity(intent);//跳轉至心情溫度計測試頁面
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, game_choice.class);
                intent.putExtra("account", TextView1.getText().toString());//"姓名:"
                startActivity(intent);//跳轉至遊戲區頁面
            }
        });
        buttonlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MainActivity2__login.class);
                startActivity(intent);//跳轉至遊戲區頁面
                finish();
                Toast toast = Toast.makeText(MainActivity.this, "成功登出", Toast.LENGTH_SHORT);
                toast.show();
                //session.invalidate();
                /*
                if(request.getParameter("logout") != null )
                {
                    session.invalidate();
                    response.sendRedirect("restanes.jsp");
                }
                */
            }
        });
    }
        //判斷要按下button時資料庫是否有資料
    private View.OnClickListener loginbtnOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           /* TextView1=(TextView)findViewById(R.id.userid);
            TextView2=(TextView)findViewById(R.id.passwd);*/
            Intent intent = new Intent(MainActivity.this, MainActivity_login.class);
           /* intent.putExtra("ac", TextView1.getText().toString());
            intent.putExtra("pd", TextView2.getText().toString());*/
            startActivity(intent);//切換Activity執行跳頁
            /*db=openOrCreateDatabase(DB_FILE, Context.MODE_PRIVATE, null);
            Cursor c=db.rawQuery("SELECT * FROM "+ DB_TABLE + " WHERE address = ? and password = ?" , new String[] {midtAddr.getText().toString(),midpassword.getText().toString()} , null);    // 查詢tb_name資料
            if (c.getCount()>0){    // 若有資料
                String str ,str1,str2,str3,str4;
                c.moveToFirst();    // 移到第 1 筆資料
                do{        // 逐筆讀出資料
                    str=c.getString(0); //"序號:"
                    str1=c.getString(1); //"姓名:"
                    str2=c.getString(2);//"性別:"
                    str3=c.getString(3);//"帳號:"
                    str4=c.getString(4);//"密碼:"
                } while(c.moveToNext());    // 有一下筆就繼續迴圈
                TextView txv=(TextView)findViewById(R.id.txv);
                txv.setText("登入成功");
                Intent intent = new Intent(MainActivity.this, Preference.class);
                intent.putExtra("name", str1);
                intent.putExtra("sex", str2);
                intent.putExtra("address",str3 );
                startActivity(intent);//切換Activity執行跳頁
            }else{
                TextView txv=(TextView)findViewById(R.id.txv);
                txv.setText("查無此資料");
            }
            db.close();        // 關閉資料庫*/
        }
    };

}

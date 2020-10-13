package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2__login extends AppCompatActivity {
    private Button btn1,button2;
    private EditText ed1,ed2;
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
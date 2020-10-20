package com.example.my0702;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class imood5 extends AppCompatActivity {
    final Context context = this;
    private Button back5, next5;
    private RadioButton radioButton;
    private ImageButton imageButton;
    private Boolean f_jumptolayout03 = false;
    private Integer layout_choice = 0;
    private TextView TextView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood6);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("account");
        TextView1 = findViewById(R.id.n1);
        TextView1.setText(loginname);
        Button nextPageBtn = (Button) findViewById(R.id.mood5_next_button);
        nextPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(imood5.this, MainActivity.class);
                intent.putExtra("account", TextView1.getText().toString());//"姓名:"
                startActivity(intent);
            }
        });

    }
}


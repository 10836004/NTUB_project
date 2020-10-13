package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
//個人資訊
public class Select_spinner1 extends AppCompatActivity {
    private Spinner sp_choose1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_spinner1);


        sp_choose1 = (Spinner) findViewById(R.id.spinner1);
        List<String> categories = new ArrayList<>();
        categories.add(0,"好友");
        categories.add("我看一下喔");
        categories.add("個人");
        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_choose1.setAdapter(dataAdapter);

        sp_choose1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).equals("選擇")) {
                } else {
                    String item = adapterView.getItemAtPosition(i).toString();

                    Toast.makeText(adapterView.getContext(), "Selected:" + item, Toast.LENGTH_SHORT).show();

                    if (adapterView.getItemAtPosition(i).equals("我看一下喔")) {
                        Intent intent = new Intent(Select_spinner1.this, Select_spinner2.class);
                        startActivity(intent);
                    } else if (adapterView.getItemAtPosition(i).equals("個人")) {
                        Intent intent = new Intent(Select_spinner1.this, Social.class);
                        startActivity(intent);
                    }
                }


            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //TODO Auto-generated method stub
            }
        });
    }
}

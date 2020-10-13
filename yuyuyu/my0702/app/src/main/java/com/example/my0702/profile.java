package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class profile extends AppCompatActivity {
    private TextView TextView1;
    private TextView t1,t2,t3;
    private EditText mmm1,mmm2,mmm3,mmm4;
    private Button btn1;
    private Switch sw1;
    private String aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile1);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String loginname=bundle.getString("account");
        TextView1 = findViewById(R.id.n1);
        TextView1.setText(loginname);
        PieChart pieChart =findViewById(R.id.pieChart);

        ArrayList<PieEntry> visitors = new ArrayList<>();
        visitors.add(new PieEntry(567, "2020一月"));
        visitors.add(new PieEntry(678, "2020二月"));
        visitors.add(new PieEntry(789, "2020三月"));
        visitors.add(new PieEntry(876, "2020四月"));
        /*
        visitors.add(new PieEntry(765, "2020五月"));
        visitors.add(new PieEntry(567, "2020六月"));
        visitors.add(new PieEntry(678, "2020七月"));
        visitors.add(new PieEntry(789, "2020八月"));
        visitors.add(new PieEntry(876, "2020九月"));
        visitors.add(new PieEntry(765, "2020十月"));
        visitors.add(new PieEntry(876, "2020十一月"));
        visitors.add(new PieEntry(765, "2020十二月"));
        */

        PieDataSet pieDataSet = new PieDataSet(visitors,"");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(20f);

        PieData pieData =new PieData(pieDataSet);


        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("心情溫度計觀察圓餅圖表");
        pieChart.setCenterTextSize(14f);
        pieChart.animate();



        Button btn1 = findViewById(R.id.button4444);
        btn1.setOnClickListener(buttonhome);

    }


    private View.OnClickListener buttonhome= new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent(profile.this, MainActivity.class);
            intent.putExtra("account", TextView1.getText().toString());//"姓名:"
            startActivity(intent);//跳轉到倒計時頁面
        }

    };


    }

package com.example.my0702;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link message1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
//子頁面
public class message1Fragment extends Fragment {
private TextView a,b,c,d,aa;
    String x1="";
    String x2="";
    SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String date = sDateFormat.format(new java.util.Date());


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public message1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment message1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static message1Fragment newInstance(String param1, String param2) {
        message1Fragment fragment = new message1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_message1, container, false);
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
        //String fileName = this.getArguments().getString("account");
        aa=rootView.findViewById(R.id.message1texxxx);
        //aa.setText(fileName);
         a=rootView.findViewById(R.id.message1text);
         b=rootView.findViewById(R.id.message1sport);
         c=rootView.findViewById(R.id.textView36);
         d=rootView.findViewById(R.id.textView37);
        try {
            //要改使用者
            String result1 = MainActivityloginSQL.executeQuery1("SELECT * FROM `myselfexperience` inner join `edsport` on `myselfexperience`.`account`=`edsport`.`account` and `myselfexperience`.`date`=`edsport`.`date` where `myselfexperience`.`account`='123' and `edsport`.`date`='"+date+"' ");
            int a1= result1.indexOf("off");
            if(a1>-1){  //判斷無資料
                a.setText(date);
            }
            JSONArray jsonArray1 = new JSONArray(result1);
            if( Integer.parseInt(String.valueOf(jsonArray1.length()))>=1) {
            JSONObject jsonData1 = jsonArray1.getJSONObject(0);
            a.setText(jsonData1.getString("article"));
            //要換行
                for(int i = 0; i < jsonArray1.length(); i++) {
                    JSONObject jsonData2 = jsonArray1.getJSONObject(i);
                    x1=x1+"\n" + jsonData2.getString("sport");
                    x2=x2+"\n"+ jsonData2.getString("sporttime");
                }
                //
                b.setText(x1);
                c.setText(x2);
            d.setText(jsonData1.getString("date")+jsonData1.getString("time"));
            }

        }
        catch(Exception e){
            // Log.e("log_tag", e.toString());
        }

        return rootView;
    }

}
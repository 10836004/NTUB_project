package com.example.my0702;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
//子頁面
public class ChatFragment extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView ft1,ft2;
    public ChatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatFragment newInstance(String param1, String param2) {
        ChatFragment fragment = new ChatFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);
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

        ft1=(TextView)rootView.findViewById(R.id.textView20);
        ft2=(TextView)rootView.findViewById(R.id.textView21);
/*

// 取得 LinearLayout 物件
        LinearLayout ll = (LinearLayout) findViewById(R.id.taaa0);

//將 TableRow1 加入到 LinearLayout 中
        TableRow tr = new TableRow(this);
         ll.addView(tr);
//將 TableRow2 加入到 TableRow1 中
        TableRow tr1 = new TableRow(this);
        tr.addView(tr1);
// 將 image 加入到 TableRow2 中
        ImageView tv = new ImageView(getApplicationContext());
        tv.setImageResource(R.drawable.ic_launcher_background);
        tr1.addView( tv );
//將 TableLayout 加入到 TableRow2 中
        TableLayout tb = new TableLayout(this);
        tr1.addView(tb);
//將 TableRow3 加入到 TableLayout 中
        TableRow tr2 = new TableRow(this);
        tb.addView(tr2);
//將 TableRow4 加入到 TableLayout 中
        TableRow tr3 = new TableRow(this);
        tb.addView(tr3);
//將 TextView 加入到 TableRow3 中
        TextView text = new TextView(this);
        text.setText("Hello World1");
        tr2.addView(text);
//將 TextView 加入到 TableRow4 中
        TextView text1 = new TextView(this);
        text1.setText("Hello World2");
        tr3.addView(text1);




 */
        try {
            String result = infood_SQL.executeQuery("SELECT * FROM `food` ");
            JSONArray jsonArray = new JSONArray(result);
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonData = jsonArray.getJSONObject(i);
                ft1.setText(jsonData.getString("menu"));
                ft2.setText(jsonData.getString("food"));
            }
        } catch(Exception e) {
            // Log.e("log_tag", e.toString());
        }




        return rootView;
    }

}

package com.example.my0702;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.os.Bundle;


public class tt111111 extends Fragment  {
    private View view;
    private LinearLayout line_fragment_hot_main;
    private ScrollView id_stickynavlayout_innerscrollview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_tt111111, container, false);
        id_stickynavlayout_innerscrollview = (ScrollView)view.findViewById(R.id.id_stickynavlayout_innerscrollview);
        line_fragment_hot_main = (LinearLayout)view.findViewById(R.id.line_fragment_hot_main);
        for(int i=0;i<10;i++  ) {
/**
 * 設定每個item最外層的LinearLayout
 */
            LinearLayout itemMain = new LinearLayout(getActivity());
            itemMain.setOrientation(LinearLayout.HORIZONTAL); //設定linearLayout是橫向還是豎各
            LinearLayout.LayoutParams itemMainparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dip2px(getActivity(), 80)); //設定寬與高
            itemMainparams.setMargins(0,dip2px(getActivity(),1),0,0); //設定每個item與上一個控制元件的間隔是1dip
            itemMain.setLayoutParams(itemMainparams);
            itemMain.setBackgroundColor(Color.WHITE); //設定背景色
            itemMain.setVerticalGravity(Gravity.CENTER); //設定對齊方式
/**
 * 設定左側圖片LinearLayout
 */
            LinearLayout itempic = new LinearLayout(getActivity());
            itempic.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams itempicparams = new LinearLayout.LayoutParams(0, dip2px(getActivity(), 70), 1);
            itempic.setLayoutParams(itempicparams);
            itempic.setVerticalGravity(Gravity.CENTER_VERTICAL);
/**
 * 設定圖片
 */
            ImageView imgPic = new ImageView(getActivity());
            imgPic.setImageResource(R.drawable.images__1_);
            LinearLayout.LayoutParams imgPicparams = new LinearLayout.LayoutParams(dip2px(getActivity(), ViewGroup.LayoutParams.WRAP_CONTENT), dip2px(getActivity(), ViewGroup.LayoutParams.WRAP_CONTENT));
            imgPicparams.leftMargin = dip2px(getActivity(), 5);
            imgPicparams.gravity = Gravity.LEFT;  //必須要加上這句，setMargins才會起作用，而且此句還必須在setMargins下面
            imgPic.setLayoutParams(imgPicparams);
/**
 * 圖片LinearLayout載入圖片
 */
            itempic.addView(imgPic, imgPicparams);
/**
 * 向主LinearLayout載入圖片LinearLayout
 */
            itemMain.addView(itempic);
/**
 * 設定中間文字顯示LinearLayout
 */
            LinearLayout itemtext = new LinearLayout(getActivity());
            itemtext.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams itemtextparams = new LinearLayout.LayoutParams(0, dip2px(getActivity(), 70), 1);
            itemtext.setLayoutParams(itemtextparams);
            itemtext.setVerticalGravity(Gravity.CENTER_VERTICAL);
            TextView txtOne = new TextView(getActivity());
            txtOne.setText("珠江俊景小區");
            txtOne.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12); //設定字號，並且設定它的單位為dip
            txtOne.getPaint().setFakeBoldText(true); //字型加租
            LinearLayout.LayoutParams txtOneparams = new LinearLayout.LayoutParams(dip2px(getActivity(), ViewGroup.LayoutParams.WRAP_CONTENT), dip2px(getActivity(), ViewGroup.LayoutParams.WRAP_CONTENT));
            txtOneparams.weight = 1;
            txtOneparams.setMargins(0, 0, 0, 0);
            txtOneparams.gravity = Gravity.LEFT;
            txtOne.setLayoutParams(txtOneparams);
            itemtext.addView(txtOne);
            TextView txtTwo = new TextView(getActivity());
            txtTwo.setText("哈爾濱");
            txtTwo.getPaint().setFakeBoldText(true);
            txtTwo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 8);
            LinearLayout.LayoutParams txtTwoparams = new LinearLayout.LayoutParams(dip2px(getActivity(), ViewGroup.LayoutParams.WRAP_CONTENT), dip2px(getActivity(), ViewGroup.LayoutParams.WRAP_CONTENT));
            txtTwoparams.weight = 1;
            txtTwo.setLayoutParams(txtTwoparams);
            itemtext.addView(txtTwo);
            TextView txtThree = new TextView(getActivity());
            txtThree.setText("一萬抵五萬");
            txtThree.getPaint().setFakeBoldText(true);
            txtThree.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 8);
            txtThree.setLayoutParams(txtOneparams);
            itemtext.addView(txtThree);
            TextView txtFour = new TextView(getActivity());
            txtFour.setText("8000元/m");
            txtFour.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
            txtFour.setTextColor(Color.parseColor("#F97F49"));
            txtFour.getPaint().setFakeBoldText(true);
            txtFour.setLayoutParams(txtOneparams);
            itemtext.addView(txtFour);
            itemMain.addView(itemtext);
/**
 * 定義右側顯示資訊框架
 */
            LinearLayout line_right_text = new LinearLayout(getActivity());
            line_right_text.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams rightparams = new LinearLayout.LayoutParams(0, dip2px(getActivity(), 70), 1);
            line_right_text.setLayoutParams(rightparams);
            line_right_text.setGravity(Gravity.RIGHT);  //右對齊
            TextView daytxt = new TextView(getActivity());
            LinearLayout.LayoutParams daytxtparams = new LinearLayout.LayoutParams(dip2px(getActivity(), ViewGroup.LayoutParams.WRAP_CONTENT), dip2px(getActivity(), ViewGroup.LayoutParams.WRAP_CONTENT));
            daytxt.setLayoutParams(daytxtparams);
            daytxt.setText("剩2天");
            daytxt.setTextColor(Color.parseColor("#F97F49")); //設定顏色
            daytxt.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10); //設定文字大小
            daytxt.getPaint().setFakeBoldText(true); //設定文字樣式，加粗
//daytxt.setPadding(0,2,2,0);
            line_right_text.addView(daytxt);
            TextView tuantxt = new TextView(getActivity());
            LinearLayout.LayoutParams tuantxtparams = new LinearLayout.LayoutParams(dip2px(getActivity(), 12), dip2px(getActivity(), 12));
            tuantxtparams.setMargins(dip2px(getActivity(), 2), dip2px(getActivity(), 0), dip2px(getActivity(), 5), 0);
            tuantxt.setLayoutParams(tuantxtparams);
            tuantxt.setBackgroundResource(R.drawable.images__1_);  //設定textView背景圖片
            tuantxt.setGravity(Gravity.CENTER);
            tuantxt.setText("團");
            txtFour.getPaint().setFakeBoldText(true);
            tuantxt.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 8);
            tuantxt.setTextColor(Color.parseColor("#ffffff"));
            line_right_text.addView(tuantxt);
            itemMain.addView(line_right_text);
            line_fragment_hot_main.addView(itemMain);
        }
        return view;
    }
    /**
     * 裝置畫素(dip,dp)轉螢幕畫素(px)
     * px就是畫素，如果用px,就會用實際畫素畫，比個如吧，用畫一條長度為240px的橫線，在480寬的模擬器上看就是一半的屏寬，而在320寬的模擬器上看就是2／3的屏寬了。
     　　  * 而dip，就是把螢幕的高分成480分，寬分成320分。比如你做一條160dip的橫線，無論你在320還480的模擬器上，都是一半屏的長度。
     * @param context
     * @param dipValue
     * @return
     */
    public static int dip2px(Context context, float dipValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale);
    }
    /**
     * 將px值轉換為sp值，保證文字大小不變
     *
     * @param pxValue
     * @param pxValue
     *      （DisplayMetrics類中屬性scaledDensity）
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale);
    }
    /**
     * 將sp值轉換為px值，保證文字大小不變
     *
     * @param spValue
     * @param spValue
     *      （DisplayMetrics類中屬性scaledDensity）
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale);
    }

}
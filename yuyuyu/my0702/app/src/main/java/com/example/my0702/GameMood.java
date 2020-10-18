package com.example.my0702;

//import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.Thread;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class GameMood extends Activity
{
    public ImageButton imageButton3;
    public ImageButton imageButton4;
    public ImageButton imageButton5;
    public ImageButton imageButton6;
    public ImageButton imageButton7;
    public ImageButton imageButton8;
    public ImageButton imageButton9;
    public ImageButton imageButton10;
    public ImageButton imageButton11;
    public ImageButton imageButton12;
    public ImageButton imageButton13;
    public ImageButton imageButton14;
    public TextView textView16;
    public TextView textView18;
    public TextView textView19;
    public TextView textView20;
    public TextView textView23;
    public TextView textView24;
    public TextView textView25;
    public TextView textView26;
    public TextView textView27;
    public TextView textView28;
    public TextView textView29;
    public TextView textView30;
    private static Handler handler;
    private static Runnable runner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_mood);
        Random rnd = new Random();
        final int mode = rnd.nextInt(2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setVisibility(View.INVISIBLE);
        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setVisibility(View.INVISIBLE);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setVisibility(View.INVISIBLE);
        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setVisibility(View.INVISIBLE);
        imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton7.setVisibility(View.INVISIBLE);
        imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton8.setVisibility(View.INVISIBLE);
        imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButton9.setVisibility(View.INVISIBLE);
        imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
        imageButton10.setVisibility(View.INVISIBLE);
        imageButton11 = (ImageButton) findViewById(R.id.imageButton11);
        imageButton11.setVisibility(View.INVISIBLE);
        imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
        imageButton12.setVisibility(View.INVISIBLE);
        imageButton13 = (ImageButton) findViewById(R.id.imageButton13);
        imageButton13.setVisibility(View.INVISIBLE);
        imageButton14 = (ImageButton) findViewById(R.id.imageButton14);
        imageButton14.setVisibility(View.INVISIBLE);
        textView16 = (TextView) findViewById(R.id.textView16);
        textView16.setVisibility(View.INVISIBLE);
        textView18 = (TextView) findViewById(R.id.textView18);
        textView18.setVisibility(View.INVISIBLE);
        textView19 = (TextView) findViewById(R.id.textView19);
        textView19.setVisibility(View.INVISIBLE);
        textView20 = (TextView) findViewById(R.id.textView20);
        textView20.setVisibility(View.INVISIBLE);
        textView23 = (TextView) findViewById(R.id.textView23);
        textView23.setVisibility(View.INVISIBLE);
        textView24 = (TextView) findViewById(R.id.textView24);
        textView24.setVisibility(View.INVISIBLE);
        textView25 = (TextView) findViewById(R.id.textView25);
        textView25.setVisibility(View.INVISIBLE);
        textView26 = (TextView) findViewById(R.id.textView26);
        textView26.setVisibility(View.INVISIBLE);
        textView27 = (TextView) findViewById(R.id.textView27);
        textView27.setVisibility(View.INVISIBLE);
        textView28 = (TextView) findViewById(R.id.textView28);
        textView28.setVisibility(View.INVISIBLE);
        textView29 = (TextView) findViewById(R.id.textView29);
        textView29.setVisibility(View.INVISIBLE);
        textView30 = (TextView) findViewById(R.id.textView30);
        textView30.setVisibility(View.INVISIBLE);
        final int total_score = 0;
        final ArrayList<String> goodMood = new ArrayList<>();
        goodMood.add("game_clam");
        goodMood.add("game_happy");
        goodMood.add("game_funny");
        final ArrayList<String> badMood = new ArrayList<>();
        badMood.add("game_angry");
        badMood.add("game_anxiety");
        badMood.add("game_frustation");
        badMood.add("game_guilt");
        badMood.add("game_jelous");
        badMood.add("game_mood");
        badMood.add("game_sad");
        badMood.add("game_sad_cry");
        badMood.add("game_worrid");
        final ArrayList<TextView> textViews = new ArrayList<>();
        textViews.add(textView16);
        textViews.add(textView18);
        textViews.add(textView19);
        textViews.add(textView20);
        textViews.add(textView23);
        textViews.add(textView24);
        textViews.add(textView25);
        textViews.add(textView26);
        textViews.add(textView27);
        textViews.add(textView28);
        textViews.add(textView29);
        textViews.add(textView30);

        final ArrayList<ImageButton> imageButtons = new ArrayList<>();
        imageButtons.add(imageButton3);
        imageButtons.add(imageButton4);
        imageButtons.add(imageButton5);
        imageButtons.add(imageButton6);
        imageButtons.add(imageButton7);
        imageButtons.add(imageButton8);
        imageButtons.add(imageButton9);
        imageButtons.add(imageButton10);
        imageButtons.add(imageButton11);
        imageButtons.add(imageButton12);
        imageButtons.add(imageButton13);
        imageButtons.add(imageButton14);



        imageButton3.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton3.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton3, textViews.get(10), badMood, total_score);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton3, textViews.get(10), goodMood, total_score);
                }

            }
        });
        imageButton4.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton4.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton4, textViews.get(9), badMood, total_score);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton4, textViews.get(9), goodMood, total_score);
                }
            }
        });
        imageButton5.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton5.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton5, textViews.get(11), badMood, total_score);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton5, textViews.get(11), goodMood, total_score);
                }
            }
        });
        imageButton6.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton6.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton6, textViews.get(6), badMood, total_score);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton6, textViews.get(6), goodMood, total_score);
                }
            }
        });
        imageButton7.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton7.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton7, textViews.get(7), badMood, total_score);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton7, textViews.get(7), goodMood, total_score);
                }
            }
        });
        imageButton8.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton8.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton8, textViews.get(8), badMood, total_score);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton8, textViews.get(8), goodMood, total_score);
                }
            }
        });
        imageButton9.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton9.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton9, textViews.get(3), badMood, total_score);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton9, textViews.get(3), goodMood, total_score);
                }
            }
        });
        imageButton10.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton10.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton10, textViews.get(4), badMood, total_score);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton10, textViews.get(4), goodMood, total_score);
                }
            }
        });
        imageButton11.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton11.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton11, textViews.get(5), badMood, total_score);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton11, textViews.get(5), goodMood, total_score);
                }
            }
        });
        imageButton12.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton12.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton12, textViews.get(1), badMood, total_score);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton12, textViews.get(1), goodMood, total_score);
                }
            }
        });
        imageButton13.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton13.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton13, textViews.get(2), badMood, total_score);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton13, textViews.get(2), goodMood, total_score);
                }
            }
        });
        imageButton14.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton14.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton14, textViews.get(0), badMood, total_score);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton14, textViews.get(0), goodMood, total_score);
                }
            }
        });

        // set title
        if(mode==0){
            TextView title = findViewById(R.id.textView7);
            title.setText("哪些是壞心情呢?");
        }
        else if(mode==1){
            TextView title = findViewById(R.id.textView7);
            title.setText("哪些是好心情呢?");
        }

        // set visible
        for (int i = 0; i < 5; i++) {
            generator();
        }

        // set picture
        for (int i = 1; i < 13; i++) {
            random_switch_image(i);
        }



    }

    private void print_imagebutton_res_name(ImageButton imagebotton, final TextView textView, ArrayList moods, int total_score){
        Boolean got_score = false;
        for (int i = 0
             ; i<moods.size(); i++) {
            if (imagebotton.getTag().toString() == moods.get(i)) {
                total_score += 1;
                got_score = true;
                textView.setText("+1");
                textView.setVisibility(View.VISIBLE);
                textView.postDelayed(
                        new Runnable() {
                            @Override
                            public void run() {
                                textView.setVisibility(View.INVISIBLE);
                            }
                        }, 3000);
            }
        }
        if(!got_score){
            textView.setText("+0");
            textView.setVisibility(View.VISIBLE);
            textView.postDelayed(
                    new Runnable() {
                        @Override
                        public void run() {
                            textView.setVisibility(View.INVISIBLE);
                        }
                    }, 3000);
        }
    }
    protected final static int getResourceID(final String resName, final String resType, final Context ctx)
        {
        final int ResourceID =
                ctx.getResources().getIdentifier(resName, resType,
                        ctx.getApplicationInfo().packageName);
        if (ResourceID == 0)
        {
            throw new IllegalArgumentException
                    (
                            "No resource string found with name " + resName
                    );
        }
        else
        {
            return ResourceID;
        }


    }
//    public void scoring(ImageButton bt, TextView text){
//        filename = bt.getfilename();
//        if filename == 'good':
//            text.settext('+1');
//        else if filename =='bad':
//            text.settext('+0');
//        text.visable();
//        time.sleep(1);
//        text.invisable();
//    }

//    private void runTimer()
//    {
//        handler = new Handler();
//        runner = new Runnable() {
//            @Override
//
//            public void run()
//            {
//                //int hours = seconds / 3600;
//                int minutes = (seconds % 3600) / 60;
//                int secs = seconds % 60;
//                //
//                // System.out.println(seconds);
//                // Format the seconds into hours, minutes,
//                // and seconds.
//                //String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
//                String time = String.format(Locale.getDefault(), "%02d:%02d", minutes, secs);
//
//                // Set the text view text.
//                time_view.setText(time);
//
//                // If running is true, increment the
//                // seconds variable.
//                if (time_running) {
//                    seconds++;
//                }
//
//                // Post the code again
//                // with a delay of 1 second.
//                handler.postDelayed(this, 1000);
//            }
//        };
//
//
//        handler.post(runner);
//    }
    public void random_switch_image(int imagebutton_num){
        Random rnd = new Random();
        String[] data;
        data = new String[] {"game_angry","game_anxiety","game_clam","game_frustation","game_funny","game_guilt","game_happy","game_jelous","game_mood","game_sad","game_sad_cry","game_worrid"};

        // final ImageButton img = (ImageButton) findViewById(R.id.imgRandom);
        // I have 3 images named img_0 to img_2, so...
        final String str = data[rnd.nextInt(11)]; //"img_" + rnd.nextInt(11);

        switch (imagebutton_num) {
            case 1:
                imageButton3.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton3.setTag(str);

                break;
            case 2:
                imageButton4.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton4.setTag(str);

                break;
            case 3:
                imageButton5.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton5.setTag(str);

                break;
            case 4:
                imageButton6.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton6.setTag(str);

                break;
            case 5:
                imageButton7.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton7.setTag(str);

                break;
            case 6:
                imageButton8.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton8.setTag(str);

                break;
            case 7:
                imageButton9.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton9.setTag(str);

                break;
            case 8:
                imageButton10.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton10.setTag(str);

                break;
            case 9:
                imageButton11.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton11.setTag(str);

                break;
            case 10:
                imageButton12.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton12.setTag(str);

                break;
            case 11:
                imageButton13.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton13.setTag(str);

                break;
            case 12:
                imageButton14.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton14.setTag(str);

                break;
        }
    }

    public void generator () {
        Random rand = new Random();
        int number = rand.nextInt(12)+1;

//        TextView shownumber = (TextView)findViewById(R.id.cases);
//        String mystring = String.valueOf(number);
//        shownumber.setText(mystring);
        switch (number){
            case 1:
                imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
                imageButton3.setVisibility(View.VISIBLE);

                break;
            case 2:
                imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
                imageButton4.setVisibility(View.VISIBLE);

                break;
            case 3:
                imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
                imageButton5.setVisibility(View.VISIBLE);

                break;
            case 4:
                imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
                imageButton6.setVisibility(View.VISIBLE);

                break;
            case 5:
                imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
                imageButton7.setVisibility(View.VISIBLE);

                break;
            case 6:
                imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
                imageButton8.setVisibility(View.VISIBLE);

                break;
            case 7:
                imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
                imageButton9.setVisibility(View.VISIBLE);

                break;
            case 8:
                imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
                imageButton10.setVisibility(View.VISIBLE);

                break;
            case 9:
                imageButton11 = (ImageButton) findViewById(R.id.imageButton11);
                imageButton11.setVisibility(View.VISIBLE);

                break;
            case 10:
                imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
                imageButton12.setVisibility(View.VISIBLE);

                break;
            case 11:
                imageButton13 = (ImageButton) findViewById(R.id.imageButton13);
                imageButton13.setVisibility(View.VISIBLE);

                break;
            case 12:
                imageButton14 = (ImageButton) findViewById(R.id.imageButton14);
                imageButton14.setVisibility(View.VISIBLE);

                break;
        }
    }
}

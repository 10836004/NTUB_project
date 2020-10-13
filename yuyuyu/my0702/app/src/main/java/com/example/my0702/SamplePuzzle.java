package com.example.my0702;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class SamplePuzzle extends AppCompatActivity {
    private static int seconds;
    private static boolean time_running;
    private static GestureDetectGridView mGridView;
    private static TextView time_view;
    private static Handler handler;
    private static Runnable runner;
    private static int picture_num;
    private static final int COLUMNS = 3;
    private static final int DIMENSIONS = COLUMNS * COLUMNS;

    private static int mColumnWidth, mColumnHeight;

    public static final String up = "up";
    public static final String down = "down";
    public static final String left = "left";
    public static final String right = "right";

    private static String[] tileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle);
        seconds = 0;
        time_running = true;

        init();

        scramble();

        setDimensions();

        runTimer();
    }

    @Override
    public void onBackPressed()
    {
        time_running = false;
        super.onBackPressed();

    }

    @Override
    public void onDestroy () {
        handler.removeCallbacks(runner);
        super.onDestroy();

    }

    private void runTimer()
    {
        handler = new Handler();
        runner = new Runnable() {
            @Override

            public void run()
            {
                //int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                //
                // System.out.println(seconds);
                // Format the seconds into hours, minutes,
                // and seconds.
                //String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
                String time = String.format(Locale.getDefault(), "%02d:%02d", minutes, secs);

                // Set the text view text.
                time_view.setText(time);

                // If running is true, increment the
                // seconds variable.
                if (time_running) {
                    seconds++;
                }

                // Post the code again
                // with a delay of 1 second.
                handler.postDelayed(this, 1000);
            }
        };


        handler.post(runner);
    }

    private void init() {
        mGridView = (GestureDetectGridView) findViewById(R.id.grid);
        time_view = (TextView) findViewById(R.id.time_view);
        time_view.bringToFront();

        mGridView.setNumColumns(COLUMNS);

        tileList = new String[DIMENSIONS];
        for (int i = 0; i < DIMENSIONS; i++) {
            tileList[i] = String.valueOf(i);
        }
    }

    private void scramble() {
        int index;
        String temp;
        Random random = new Random();

        for (int i = tileList.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = tileList[index];
            tileList[index] = tileList[i];
            tileList[i] = temp;
        }
    }

    private void setDimensions() {
        ViewTreeObserver vto = mGridView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mGridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int displayWidth = mGridView.getMeasuredWidth();
                int displayHeight = mGridView.getMeasuredHeight();

                int statusbarHeight = getStatusBarHeight(getApplicationContext());
                int requiredHeight = displayHeight - statusbarHeight;

                mColumnWidth = displayWidth / COLUMNS;
                mColumnHeight = requiredHeight / COLUMNS;

                picture_num = create_picture_num();
                display(getApplicationContext());
            }
        });
    }

    private int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");

        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }

        return result;
    }

    private static int create_picture_num(){
        int max = 9;
        Random rand = new Random();
        int picture_num = rand.nextInt((max - 0) + 1);
        return picture_num;
    }

    private static void display(Context context) {
        ArrayList<Button> buttons = new ArrayList<>();
        Button button;
        switch (picture_num){
            case 0 :
                for (int i = 0; i < tileList.length; i++) {
                    button = new Button(context);

                    if (tileList[i].equals("0"))
                        button.setBackgroundResource(R.drawable.p1);
                    else if (tileList[i].equals("1"))
                        button.setBackgroundResource(R.drawable.p2);
                    else if (tileList[i].equals("2"))
                        button.setBackgroundResource(R.drawable.p3);
                    else if (tileList[i].equals("3"))
                        button.setBackgroundResource(R.drawable.p4);
                    else if (tileList[i].equals("4"))
                        button.setBackgroundResource(R.drawable.p5);
                    else if (tileList[i].equals("5"))
                        button.setBackgroundResource(R.drawable.p6);
                    else if (tileList[i].equals("6"))
                        button.setBackgroundResource(R.drawable.p7);
                    else if (tileList[i].equals("7"))
                        button.setBackgroundResource(R.drawable.p8);
                    else if (tileList[i].equals("8"))
                        button.setBackgroundResource(R.drawable.p10);

                    buttons.add(button);
                }
                break;
            case 1 :
                for (int i = 0; i < tileList.length; i++) {
                    button = new Button(context);

                    if (tileList[i].equals("0"))
                        button.setBackgroundResource(R.drawable.p1_1);
                    else if (tileList[i].equals("1"))
                        button.setBackgroundResource(R.drawable.p1_2);
                    else if (tileList[i].equals("2"))
                        button.setBackgroundResource(R.drawable.p1_3);
                    else if (tileList[i].equals("3"))
                        button.setBackgroundResource(R.drawable.p1_4);
                    else if (tileList[i].equals("4"))
                        button.setBackgroundResource(R.drawable.p1_5);
                    else if (tileList[i].equals("5"))
                        button.setBackgroundResource(R.drawable.p1_6);
                    else if (tileList[i].equals("6"))
                        button.setBackgroundResource(R.drawable.p1_7);
                    else if (tileList[i].equals("7"))
                        button.setBackgroundResource(R.drawable.p1_8);
                    else if (tileList[i].equals("8"))
                        button.setBackgroundResource(R.drawable.p1_9);

                    buttons.add(button);
                }
                break;
            case 2 :
                for (int i = 0; i < tileList.length; i++) {
                    button = new Button(context);

                    if (tileList[i].equals("0"))
                        button.setBackgroundResource(R.drawable.p2_1);
                    else if (tileList[i].equals("1"))
                        button.setBackgroundResource(R.drawable.p2_2);
                    else if (tileList[i].equals("2"))
                        button.setBackgroundResource(R.drawable.p2_3);
                    else if (tileList[i].equals("3"))
                        button.setBackgroundResource(R.drawable.p2_4);
                    else if (tileList[i].equals("4"))
                        button.setBackgroundResource(R.drawable.p2_5);
                    else if (tileList[i].equals("5"))
                        button.setBackgroundResource(R.drawable.p2_6);
                    else if (tileList[i].equals("6"))
                        button.setBackgroundResource(R.drawable.p2_7);
                    else if (tileList[i].equals("7"))
                        button.setBackgroundResource(R.drawable.p2_8);
                    else if (tileList[i].equals("8"))
                        button.setBackgroundResource(R.drawable.p2_9);

                    buttons.add(button);
                }
                break;
            case 3 :
                for (int i = 0; i < tileList.length; i++) {
                    button = new Button(context);

                    if (tileList[i].equals("0"))
                        button.setBackgroundResource(R.drawable.p3_1);
                    else if (tileList[i].equals("1"))
                        button.setBackgroundResource(R.drawable.p3_2);
                    else if (tileList[i].equals("2"))
                        button.setBackgroundResource(R.drawable.p3_3);
                    else if (tileList[i].equals("3"))
                        button.setBackgroundResource(R.drawable.p3_4);
                    else if (tileList[i].equals("4"))
                        button.setBackgroundResource(R.drawable.p3_5);
                    else if (tileList[i].equals("5"))
                        button.setBackgroundResource(R.drawable.p3_6);
                    else if (tileList[i].equals("6"))
                        button.setBackgroundResource(R.drawable.p3_7);
                    else if (tileList[i].equals("7"))
                        button.setBackgroundResource(R.drawable.p3_8);
                    else if (tileList[i].equals("8"))
                        button.setBackgroundResource(R.drawable.p3_10);

                    buttons.add(button);
                }
                break;
            case 4 :
                for (int i = 0; i < tileList.length; i++) {
                    button = new Button(context);

                    if (tileList[i].equals("0"))
                        button.setBackgroundResource(R.drawable.p4_1);
                    else if (tileList[i].equals("1"))
                        button.setBackgroundResource(R.drawable.p4_2);
                    else if (tileList[i].equals("2"))
                        button.setBackgroundResource(R.drawable.p4_3);
                    else if (tileList[i].equals("3"))
                        button.setBackgroundResource(R.drawable.p4_4);
                    else if (tileList[i].equals("4"))
                        button.setBackgroundResource(R.drawable.p4_5);
                    else if (tileList[i].equals("5"))
                        button.setBackgroundResource(R.drawable.p4_6);
                    else if (tileList[i].equals("6"))
                        button.setBackgroundResource(R.drawable.p4_6_1);
                    else if (tileList[i].equals("7"))
                        button.setBackgroundResource(R.drawable.p4_8);
                    else if (tileList[i].equals("8"))
                        button.setBackgroundResource(R.drawable.p4_9);

                    buttons.add(button);
                }
                break;
            case 5 :
                for (int i = 0; i < tileList.length; i++) {
                    button = new Button(context);

                    if (tileList[i].equals("0"))
                        button.setBackgroundResource(R.drawable.p5_1);
                    else if (tileList[i].equals("1"))
                        button.setBackgroundResource(R.drawable.p5_2);
                    else if (tileList[i].equals("2"))
                        button.setBackgroundResource(R.drawable.p5_3);
                    else if (tileList[i].equals("3"))
                        button.setBackgroundResource(R.drawable.p5_4);
                    else if (tileList[i].equals("4"))
                        button.setBackgroundResource(R.drawable.p5_5);
                    else if (tileList[i].equals("5"))
                        button.setBackgroundResource(R.drawable.p5_6);
                    else if (tileList[i].equals("6"))
                        button.setBackgroundResource(R.drawable.p5_7);
                    else if (tileList[i].equals("7"))
                        button.setBackgroundResource(R.drawable.p5_8);
                    else if (tileList[i].equals("8"))
                        button.setBackgroundResource(R.drawable.p5_9);

                    buttons.add(button);
                }
                break;
            case 6 :
                for (int i = 0; i < tileList.length; i++) {
                    button = new Button(context);

                    if (tileList[i].equals("0"))
                        button.setBackgroundResource(R.drawable.p6_1);
                    else if (tileList[i].equals("1"))
                        button.setBackgroundResource(R.drawable.p6_2);
                    else if (tileList[i].equals("2"))
                        button.setBackgroundResource(R.drawable.p6_3);
                    else if (tileList[i].equals("3"))
                        button.setBackgroundResource(R.drawable.p6_4);
                    else if (tileList[i].equals("4"))
                        button.setBackgroundResource(R.drawable.p6_5);
                    else if (tileList[i].equals("5"))
                        button.setBackgroundResource(R.drawable.p6_6);
                    else if (tileList[i].equals("6"))
                        button.setBackgroundResource(R.drawable.p6_7);
                    else if (tileList[i].equals("7"))
                        button.setBackgroundResource(R.drawable.p6_8);
                    else if (tileList[i].equals("8"))
                        button.setBackgroundResource(R.drawable.p6_9);

                    buttons.add(button);
                }
                break;
            case 7 :
                for (int i = 0; i < tileList.length; i++) {
                    button = new Button(context);

                    if (tileList[i].equals("0"))
                        button.setBackgroundResource(R.drawable.p7_1);
                    else if (tileList[i].equals("1"))
                        button.setBackgroundResource(R.drawable.p7_2);
                    else if (tileList[i].equals("2"))
                        button.setBackgroundResource(R.drawable.p7_3);
                    else if (tileList[i].equals("3"))
                        button.setBackgroundResource(R.drawable.p7_4);
                    else if (tileList[i].equals("4"))
                        button.setBackgroundResource(R.drawable.p7_5);
                    else if (tileList[i].equals("5"))
                        button.setBackgroundResource(R.drawable.p7_6);
                    else if (tileList[i].equals("6"))
                        button.setBackgroundResource(R.drawable.p7_7);
                    else if (tileList[i].equals("7"))
                        button.setBackgroundResource(R.drawable.p7_8);
                    else if (tileList[i].equals("8"))
                        button.setBackgroundResource(R.drawable.p7_9);

                    buttons.add(button);
                }
                break;
            case 8 :
                for (int i = 0; i < tileList.length; i++) {
                    button = new Button(context);

                    if (tileList[i].equals("0"))
                        button.setBackgroundResource(R.drawable.p8_1);
                    else if (tileList[i].equals("1"))
                        button.setBackgroundResource(R.drawable.p8_2);
                    else if (tileList[i].equals("2"))
                        button.setBackgroundResource(R.drawable.p8_3);
                    else if (tileList[i].equals("3"))
                        button.setBackgroundResource(R.drawable.p8_4);
                    else if (tileList[i].equals("4"))
                        button.setBackgroundResource(R.drawable.p8_5);
                    else if (tileList[i].equals("5"))
                        button.setBackgroundResource(R.drawable.p8_6);
                    else if (tileList[i].equals("6"))
                        button.setBackgroundResource(R.drawable.p8_7);
                    else if (tileList[i].equals("7"))
                        button.setBackgroundResource(R.drawable.p8_8);
                    else if (tileList[i].equals("8"))
                        button.setBackgroundResource(R.drawable.p8_9);

                    buttons.add(button);
                }
                break;
            case 9 :
                for (int i = 0; i < tileList.length; i++) {
                    button = new Button(context);

                    if (tileList[i].equals("0"))
                        button.setBackgroundResource(R.drawable.p9_1);
                    else if (tileList[i].equals("1"))
                        button.setBackgroundResource(R.drawable.p9_2);
                    else if (tileList[i].equals("2"))
                        button.setBackgroundResource(R.drawable.p9_3);
                    else if (tileList[i].equals("3"))
                        button.setBackgroundResource(R.drawable.p9_4);
                    else if (tileList[i].equals("4"))
                        button.setBackgroundResource(R.drawable.p9_5);
                    else if (tileList[i].equals("5"))
                        button.setBackgroundResource(R.drawable.p9_6);
                    else if (tileList[i].equals("6"))
                        button.setBackgroundResource(R.drawable.p9_7);
                    else if (tileList[i].equals("7"))
                        button.setBackgroundResource(R.drawable.p9_8);
                    else if (tileList[i].equals("8"))
                        button.setBackgroundResource(R.drawable.p9_9);

                    buttons.add(button);
                }
                break;
        }



        mGridView.setAdapter(new CustomAdapter(buttons, mColumnWidth, mColumnHeight));
    }

    private static void swap(Context context, int currentPosition, int swap) {
        String newPosition = tileList[currentPosition + swap];
        tileList[currentPosition + swap] = tileList[currentPosition];
        tileList[currentPosition] = newPosition;
        display(context);


        if (isSolved()) {
            time_running = false;
            Toast toast = Toast.makeText(context,  "YOU WIN!", Toast.LENGTH_SHORT);
            LinearLayout toastLayout = (LinearLayout) toast.getView();
            TextView toastTV = (TextView) toastLayout.getChildAt(0);
            toastTV.setTextSize(60);
            toast.show();
        }
    }

    public static void moveTiles(Context context, String direction, int position) {

        // Upper-left-corner tile
        if (position == 0) {

            if (direction.equals(right)) swap(context, position, 1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Upper-center tiles
        } else if (position > 0 && position < COLUMNS - 1) {
            if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Upper-right-corner tile
        } else if (position == COLUMNS - 1) {
            if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Left-side tiles
        } else if (position > COLUMNS - 1 && position < DIMENSIONS - COLUMNS &&
                position % COLUMNS == 0) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(right)) swap(context, position, 1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Right-side AND bottom-right-corner tiles
        } else if (position == COLUMNS * 2 - 1 || position == COLUMNS * 3 - 1) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) {

                // Tolerates only the right-side tiles to swap downwards as opposed to the bottom-
                // right-corner tile.
                if (position <= DIMENSIONS - COLUMNS - 1) swap(context, position,
                        COLUMNS);
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Bottom-left corner tile
        } else if (position == DIMENSIONS - COLUMNS) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Bottom-center tiles
        } else if (position < DIMENSIONS - 1 && position > DIMENSIONS - COLUMNS) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Center tiles
        } else {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(right)) swap(context, position, 1);
            else swap(context, position, COLUMNS);
        }
    }

    private static boolean isSolved() {
        boolean solved = false;

        for (int i = 0; i < tileList.length; i++) {
            if (tileList[i].equals(String.valueOf(i))) {
                solved = true;
            } else {
                solved = false;
                break;
            }
        }

        return solved;
    }
}


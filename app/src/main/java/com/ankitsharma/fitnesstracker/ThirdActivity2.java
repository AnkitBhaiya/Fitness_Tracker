package com.ankitsharma.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity2 extends AppCompatActivity {
    String buttonValue;
    Button startbtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private Boolean MTimeRunning = false;
    private  long MtimeleftMills;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_third2);
        Intent intent = getIntent ();
        buttonValue = intent.getStringExtra ("value");
        int intvalue = Integer.valueOf (buttonValue);
        switch (intvalue){
            case 1:
                setContentView (R.layout.avtivity_mountain);
                break;
            case 2:
                setContentView (R.layout.activity_basic);
                break;
            case 3:
                setContentView (R.layout.activity_dips);
                break;
            case 4:
                setContentView (R.layout.activity_bicycle);
                break;
            case 5:
                setContentView (R.layout.activity_leg_raise);
                break;
            case 6:
                setContentView (R.layout.activity_alternate_heel);
                break;
            case 7:
                setContentView (R.layout.activity_leg_up);
                break;
            case 8:
                setContentView (R.layout.activity_sit_up);
                break;
            case 9:
                setContentView (R.layout.alternate_v_ups);
                break;
            case 10:
                setContentView (R.layout.activity_plank);
                break;
            case 11:
                setContentView (R.layout.activity_plank_left);
                break;
            case 12:
                setContentView (R.layout.activity_russian);
                break;
            case 13:
                setContentView (R.layout.activity_bridge);
                break;
            case 14:
                setContentView (R.layout.vertica_leg);
                break;
            case 15:
                setContentView (R.layout.wind_mill);
                break;
        }
        startbtn = findViewById (R.id.startbtn);
        mtextview = findViewById (R.id.time);
        startbtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if(MTimeRunning){
                    stoptimer ();
                }
                else{
                    startTimer ();
                }
            }
        });
    }
    private void stoptimer(){
        countDownTimer.cancel ();
        MTimeRunning =false;
        startbtn.setText ("START");
    }
    private void startTimer(){
        final CharSequence value1 = mtextview.getText ();
        String num1 = value1.toString ();
        String num2 = num1.substring (0,2);
        String num3 = num1.substring (3,5);

        final int number = Integer.valueOf (num2)* 60 +Integer.valueOf (num3);
        MtimeleftMills = number*1000;

        countDownTimer = new CountDownTimer (MtimeleftMills,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                MtimeleftMills = millisUntilFinished;
                updateTimer();

            }


            @Override
            public void onFinish() {

                int newValue = Integer.valueOf (buttonValue)+1;
                if (newValue<=7){
                    Intent intent = new Intent (ThirdActivity2.this,ThirdActivity2.class);
                    intent.addFlags (Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra ("value",String.valueOf (newValue));
                    startActivity (intent);
                }
                else{
                    newValue = 1;
                    Intent intent = new Intent (ThirdActivity2.this,ThirdActivity2.class);
                    intent.addFlags (Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra ("value",String.valueOf (newValue));
                    startActivity (intent);
                }

            }
        }.start ();
        startbtn.setText ("Pause");
        MTimeRunning = true;

    }

    private void updateTimer() {

        int minutes = (int) MtimeleftMills/60000;
        int seconds = (int) MtimeleftMills%60000/1000;
        String timeLefttext="";
        if (minutes<10)
            timeLefttext="0";
        timeLefttext= timeLefttext + minutes+":";
        if (seconds<10)
            timeLefttext="0";
        timeLefttext+=seconds;
        mtextview.setText (timeLefttext);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed ();
    }
}
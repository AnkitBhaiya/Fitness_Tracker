package com.ankitsharma.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    int[] newArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_second);
        Toolbar toolbar = findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);

        newArray = new int[]{
          R.id.mountain_climber,R.id.basic_climber,R.id.basic_dips,R.id.bicycle_crunches,
          R.id.leg_raise,R.id.alternate_heel_touch,R.id.leg_up_crunches,R.id.sit_up,
          R.id.alternate_v_ups,R.id.plank_rotation,R.id.plank_left_leg,R.id.russian_twist,
                R.id.bridge,R.id.vertica_leg,R.id.wind_mill
        };

    }

    public void ImageButtonClicked(View view){
        for (int i=0;i< newArray.length;i++){
            if (view.getId ()==newArray[i]){
                int value = i+1;
                Log.i ("First",String.valueOf (value));
                Intent intent = new Intent (SecondActivity.this,ThirdActivity.class);
                intent.putExtra ("value",String.valueOf (value));
                startActivity (intent);
            }
        }
    }
}
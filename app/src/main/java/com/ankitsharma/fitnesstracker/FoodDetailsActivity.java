package com.ankitsharma.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FoodDetailsActivity extends AppCompatActivity {
     TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_food_details);
        textView = findViewById (R.id.txt);
        String dstory = getIntent ().getStringExtra ("story");
        textView.setText (dstory);
    }

    public void goback(View view) {
        startActivity (new Intent (FoodDetailsActivity.this,FoodActivity.class));
        finish ();
    }
}
package com.ankitsharma.fitnesstracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        Toolbar toolbar = findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);
        button1 = findViewById (R.id.button1);
        button2 = findViewById (R.id.button2);

        button1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (MainActivity.this,SecondActivity.class));
            }
        });

        button2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (MainActivity.this,SecondActivity2.class));
            }
        });
    }

    public void before18(View view){
      startActivity (new Intent (MainActivity.this,SecondActivity.class));
    }
    public void after18(View view){
        startActivity (new Intent (MainActivity.this,SecondActivity2.class));
    }
    public void tips(View view){
        startActivity (new Intent (MainActivity.this,FoodActivity.class));
    }
}
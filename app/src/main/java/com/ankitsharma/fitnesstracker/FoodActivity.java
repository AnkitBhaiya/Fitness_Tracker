package com.ankitsharma.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FoodActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_food);

        String[] tstory = getResources ().getStringArray (R.array.title_story);
        final String[] dstory = getResources ().getStringArray (R.array.details_story);
        ArrayAdapter<String> adapter =new ArrayAdapter<> (this, R.layout.row, R.id.rowtxt, tstory);


        listView = findViewById (R.id.list);
        listView.setAdapter (adapter);
        listView.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t = dstory[position];
               Intent intent = new Intent (FoodActivity.this,FoodDetailsActivity.class);
              intent.putExtra ("story",t);
               startActivity (intent);
            }
        });


    }

    public void foodGoback(View view) {
        startActivity (new Intent (FoodActivity.this,MainActivity.class));
        finish ();
    }
}
package com.ankitsharma.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
    Animation up,down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_splash_screen);
        this.getWindow ().setFlags (WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView imageView = findViewById (R.id.imageView2);
        TextView textView = findViewById (R.id.app_name);
        imageView.setAnimation (down);
        textView.setAnimation (up);
        up = AnimationUtils.loadAnimation (this,R.anim.up);
        down = AnimationUtils.loadAnimation (this,R.anim.down);

       Thread td = new Thread (){
           @Override
           public void run() {
               try {
                   sleep (3500);
               }catch (Exception e){
                   e.printStackTrace ();
               }finally {
                   startActivity (new Intent (SplashScreenActivity.this,MainActivity.class));
               }
           }
       };td.start ();

    }
}
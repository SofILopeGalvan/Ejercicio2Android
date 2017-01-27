package com.example.sofilop.ejecrcio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {
    private  static  final long SPLASH_SCREEN_DELAY=1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_activity_splash_screen);


        TimerTask task=new TimerTask() {
            @Override
            public void run() {

                Intent mainIntent=new Intent().setClass(SplashScreen.this,MainActivity.class);
                startActivity(mainIntent);
                //se finaliza la actividad
                finish();
            }
        };
        Timer timer=new Timer();
        timer.schedule(task,SPLASH_SCREEN_DELAY);
    }
}

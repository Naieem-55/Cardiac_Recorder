package com.example.cardiac_recorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {

    ImageView imageView;
    TextView text1, text2;
    Animation top , down;

    public static int SPLASH_SCREEN = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        imageView = findViewById(R.id.imageView);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);

        top = AnimationUtils.loadAnimation(this , R.anim.top);
        down = AnimationUtils.loadAnimation(this, R.anim.down);

        imageView.setAnimation(top);
        text1.setAnimation(down);
        text2.setAnimation(down);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash.this , Login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}
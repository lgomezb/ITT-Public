package com.example.congrats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity implements Animation.AnimationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView gap_splash = findViewById(R.id.textoSplash);
        ImageView loader = findViewById(R.id.loader);

        Animation move_text = AnimationUtils.loadAnimation(this,R.anim.splash_anim_translate);
        Animation resize_img = AnimationUtils.loadAnimation(this,R.anim.splash_anim_scale);

        gap_splash.startAnimation(move_text);
        loader.startAnimation(resize_img);
        move_text.setAnimationListener(this);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Intent intent = new Intent(Splash.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
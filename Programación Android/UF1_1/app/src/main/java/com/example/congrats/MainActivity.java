package com.example.congrats;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface myFont = Typeface.createFromAsset(getAssets(), getString(R.string.nintendo_font));
        TextView gap = findViewById(R.id.first_gap);
        TextView gap2 = findViewById(R.id.second_gap);
        TextView gap3 = findViewById(R.id.third_gap);
        ImageView heart = findViewById(R.id.heart);

        Animation main_heart = AnimationUtils.loadAnimation(this,R.anim.main_heart);

        heart.startAnimation(main_heart);





        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.nintedo_mario);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);


    }
}
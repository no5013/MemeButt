package com.example.asus.memebutt;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button button;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.iniComponent();
    }

    private void iniComponent(){
//        mediaPlayer = new MediaPlayer();
//        button = (Button)findViewById(R.id.pressButton);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }
}

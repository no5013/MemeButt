package com.example.asus.memebutt.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.memebutt.R;
import com.example.asus.memebutt.Adapter.MemeAdapter;
import com.example.asus.memebutt.Adapter.RecyclerItemClickListener;
import com.example.asus.memebutt.model.App;
import com.example.asus.memebutt.model.Meme;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer{

    TextView memeTitle;
    ImageButton button;
    ImageView memePicture;
    MediaPlayer mediaPlayer;
    FloatingActionButton libraryFab;
    RecyclerView memeRecycleView;

    MemeAdapter memeAdapter;

    App app;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initComponent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.setCurrentButton();
    }

    public void setCurrentButton() {
        Meme meme = app.getCurrentMeme();
        memePicture.setImageResource(meme.getPicture());
        memeTitle.setText(meme.getTitle());
        button.setImageResource(meme.getButton());
        mediaPlayer.release();
        mediaPlayer = MediaPlayer.create(this,meme.getSound());
    }

    private void initComponent(){

        app = App.getInstance();

        app.addObserver(this);

        mediaPlayer = MediaPlayer.create(this,R.raw.demacia);
        memeTitle = (TextView)findViewById(R.id.memeTitle);
        button = (ImageButton)findViewById(R.id.memeButton);
        memePicture = (ImageView) findViewById(R.id.memePicture);
        libraryFab = (FloatingActionButton) findViewById(R.id.libraryFab);
        memeRecycleView = (RecyclerView) findViewById(R.id.meme_recycle_view);

        memeAdapter = new MemeAdapter(app.getMemes());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        memeRecycleView.setLayoutManager(linearLayoutManager);
        memeRecycleView.setAdapter(memeAdapter);
        memeRecycleView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                   public void onItemClick(View view, int position) {
                        app.changeCurrentMeme(position);
                    }
                })
        );

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    try {
                        mediaPlayer.stop();
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                mediaPlayer.start();

            }
        });

        libraryFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LibraryActivity.class);
                startActivity(intent);
            }
        });

        this.setCurrentButton();
    }

    @Override
    public void update(Observable observable, Object data) {
        setCurrentButton();
    }
}
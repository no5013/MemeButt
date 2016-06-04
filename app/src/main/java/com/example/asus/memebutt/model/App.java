package com.example.asus.memebutt.model;

import com.example.asus.memebutt.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Asus on 6/4/2016.
 */
public class App extends Observable{

    private List<Meme> memes;
    private int currentMeme;
    public static App app;

    private App(){
        memes = Storage.getInstance().getMemes();
    }

    public void changeCurrentMeme(int memeNo){
        this.notifyObservers();
        this.setChanged();
        this.currentMeme = memeNo;
    }

    public Meme getCurrentMeme(){
        return memes.get(currentMeme);
    }

    public static App getInstance(){
        if(app==null)
            app = new App();
        return app;
    }
}

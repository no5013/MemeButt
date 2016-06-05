package com.example.asus.memebutt.model;

import com.example.asus.memebutt.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Asus on 6/4/2016.
 */
public class App extends Observable{

    private int currentMeme;
    public static App app;

    private App(){

    }

    public void changeCurrentMeme(int memeNo){
        this.currentMeme = memeNo;
        this.notifyObservers();
        this.setChanged();
    }

    public List<Meme> getMemes() {
        return Storage.getInstance().getMemes();
    }

    public void setCurrentMeme(int currentMeme) {
        this.currentMeme = currentMeme;
    }

    public Meme getCurrentMeme(){
        return getMemes().get(currentMeme);
    }

    public static App getInstance(){
        if(app==null)
            app = new App();
        return app;
    }
}

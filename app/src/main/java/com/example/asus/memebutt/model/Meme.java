package com.example.asus.memebutt.model;

import android.media.MediaPlayer;
import android.widget.ImageButton;

/**
 * Created by Asus on 5/13/2016.
 */
public class Meme {

    private String title;
    private int picture;
    private int button;
    private int sound;

    public Meme(String title , int picture , int button , int sound){
        this.title = title;
        this.picture = picture;
        this.button = button;
        this.sound = sound;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public int getButton() {
        return button;
    }

    public void setButton(int button) {
        this.button = button;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }
}

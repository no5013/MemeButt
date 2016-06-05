package com.example.asus.memebutt.model;

import android.media.MediaPlayer;
import android.widget.ImageButton;

/**
 * Created by Asus on 5/13/2016.
 */
public class Meme {

    private String title;
    private String picture;
    private int imageId;
    private MemeButton button;
    private String sound;
    private boolean edit;

    public Meme(String title , String picture , MemeButton button , String sound){
        this.title = title;
        this.picture = picture;
        this.button = button;
        this.sound = sound;
        edit = true;
    }

    public Meme(String title , String picture , MemeButton button , String sound ,boolean edit){
        this.title = title;
        this.picture = picture;
        this.button = button;
        this.sound = sound;
        this.edit = edit;
    }

    public void setImageId(int id){
        this.imageId = id;
    }

    public int getImageId(){
        return imageId;
    }

    public boolean canEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getButton() {
        return button.getButtonPicture();
    }

    public void setMemeButton(MemeButton button) {
        this.button = button;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }


}

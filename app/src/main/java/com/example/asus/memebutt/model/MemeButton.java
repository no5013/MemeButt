package com.example.asus.memebutt.model;

/**
 * Created by Asus on 6/5/2016.
 */
public class MemeButton {
    private String buttonName;
    private int buttonPicture;

    public MemeButton(String name,int buttonPicture){
        this.buttonName = name;
        this.buttonPicture = buttonPicture;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public int getButtonPicture() {
        return buttonPicture;
    }

    public void setButtonPicture(int buttonPicture) {
        this.buttonPicture = buttonPicture;
    }
}

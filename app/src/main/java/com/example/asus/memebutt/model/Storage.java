package com.example.asus.memebutt.model;

import android.net.Uri;

import com.example.asus.memebutt.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 6/4/2016.
 */
public class Storage {

    public static Storage storage;
    public MemeButton defaultButton;
    public List<Meme> memes;

    private Storage(){
        memes = new ArrayList<Meme>();
        defaultButton = new MemeButton("DefaultButton",R.drawable.button1);

        String path = "android.resource://com.example.asus.memebutt/";
        String raw = "raw/";
        String drawable = "drawable/";
        String imageUri = "drawable://";
        Meme meme1 = new Meme("GG",null,defaultButton,Uri.parse(path+raw+R.raw.gg).toString() , false);
        meme1.setImageId(R.drawable.gg);
        Meme meme2 = new Meme("Demacia",null,defaultButton,Uri.parse(path+R.raw.demacia).toString() , false);
        meme2.setImageId(R.drawable.garen);

        memes.add(meme1);
        memes.add(meme2);
    }

    public void addMeme(Meme meme){
        memes.add(meme);
    }

    public void deleteMeme(Meme meme){
        memes.remove(meme);
    }

    public void deleteMeme(int position){
        memes.remove(position);
    }

    public static Storage getInstance(){
        if(storage ==null)
            storage = new Storage();
        return storage;
    }

    public MemeButton getDefaultButton(){
        return defaultButton;
    }

    public List<Meme> getMemes(){
        return memes;
    }
}

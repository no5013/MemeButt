package com.example.asus.memebutt.model;

import com.example.asus.memebutt.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 6/4/2016.
 */
public class Storage {

    public static Storage storage;
    public List<Meme> memes;

    private Storage(){
        memes = new ArrayList<Meme>();
        Meme meme1 = new Meme("Demacia1",R.drawable.button1_1,R.drawable.button1,R.raw.demacia);
        Meme meme2 = new Meme("Demacia2", R.drawable.garen,R.drawable.button1,R.raw.demacia);
        memes.add(meme1);
        memes.add(meme2);
    }

    public static Storage getInstance(){
        if(storage ==null)
            storage = new Storage();
        return storage;
    }

    public List<Meme> getMemes(){
        return memes;
    }
}

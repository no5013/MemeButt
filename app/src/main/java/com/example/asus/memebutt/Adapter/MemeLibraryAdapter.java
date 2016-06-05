package com.example.asus.memebutt.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asus.memebutt.R;
import com.example.asus.memebutt.model.Meme;

import java.util.List;

/**
 * Created by Asus on 6/5/2016.
 */
public class MemeLibraryAdapter extends ArrayAdapter<Meme> {
    public MemeLibraryAdapter(Context context, int resource, List<Meme> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v==null) {
            LayoutInflater vl = LayoutInflater.from(getContext());
            v = vl.inflate(R.layout.meme_library_cell, null);
        }
        TextView memeTitle = (TextView) v.findViewById(R.id.memeLibraryTitle);
//        ImageButton editMemeButton = (ImageButton) v.findViewById(R.id.editMemeButton);
//        ImageButton deleteMemeButton = (ImageButton) v.findViewById(R.id.deleteMemeButton);


        Meme meme = getItem(position);

        memeTitle.setText(meme.getTitle());


        return v;
    }
}

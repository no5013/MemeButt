package com.example.asus.memebutt.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.memebutt.R;
import com.example.asus.memebutt.model.App;
import com.example.asus.memebutt.model.Meme;
import com.example.asus.memebutt.model.Storage;

import java.util.List;

/**
 * Created by Asus on 6/5/2016.
 */
public class MemeLibraryAdapter extends ArrayAdapter<Meme> {
    public MemeLibraryAdapter(Context context, int resource, List<Meme> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v==null) {
            LayoutInflater vl = LayoutInflater.from(getContext());
            v = vl.inflate(R.layout.meme_library_cell, null);
        }
        TextView memeTitle = (TextView) v.findViewById(R.id.memeLibraryTitle);
//        ImageButton editMemeButton = (ImageButton) v.findViewById(R.id.editMemeButton);
        ImageButton deleteMemeButton = (ImageButton) v.findViewById(R.id.deleteMemeButton);
        ImageButton selectMemeButton = (ImageButton) v.findViewById(R.id.editMemeButton);

        Meme meme = getItem(position);

        if(meme.canEdit()){
            deleteMemeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Storage.getInstance().deleteMeme(position);
                    notifyDataSetChanged();
                }
            });
        }else{
            deleteMemeButton.setVisibility(View.GONE);
        }

        selectMemeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.getInstance().changeCurrentMeme(position);
                ((Activity)getContext()).finish();
            }
        });


        memeTitle.setText(meme.getTitle());




        return v;
    }
}

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

import java.io.File;
import java.util.List;

/**
 * Created by Asus on 6/5/2016.
 */
public class SoundAdapter extends ArrayAdapter<File> {
    public SoundAdapter(Context context, int resource, List<File> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v==null) {
            LayoutInflater vl = LayoutInflater.from(getContext());
            v = vl.inflate(R.layout.sound_cell, null);
        }
        TextView soundName = (TextView) v.findViewById(R.id.soundName);
        File file = getItem(position);
        soundName.setText(file.getName());

        return v;
    }
}

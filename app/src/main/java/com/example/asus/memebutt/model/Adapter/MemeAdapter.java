package com.example.asus.memebutt.model.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.asus.memebutt.R;
import com.example.asus.memebutt.model.Meme;

import java.util.List;

/**
 * Created by Asus on 6/4/2016.
 */
public class MemeAdapter extends RecyclerView.Adapter<MemeAdapter.MemeRecycleViewHolder> {
    private List<Meme> memes;

    public static class MemeRecycleViewHolder extends RecyclerView.ViewHolder{
        TextView memeTitle;
        ImageView memePicture;
        public MemeRecycleViewHolder(View itemView) {
            super(itemView);
            memeTitle = (TextView)itemView.findViewById(R.id.memeCellTitle);
            memePicture = (ImageView)itemView.findViewById(R.id.memeCellPicture);
        }
    }

    public MemeAdapter(List<Meme> layers) {
        this.memes = layers;
    }

    @Override
    public MemeRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.meme_cell, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new MemeRecycleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MemeRecycleViewHolder holder, int position) {
        final Meme meme = memes.get(position);
        holder.memeTitle.setText(meme.getTitle());
        holder.memePicture.setImageResource(meme.getPicture());
    }

    @Override
    public int getItemCount() {
        return memes.size();
    }

}
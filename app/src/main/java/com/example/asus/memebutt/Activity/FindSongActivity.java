package com.example.asus.memebutt.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asus.memebutt.Adapter.SoundAdapter;
import com.example.asus.memebutt.R;
import com.example.asus.memebutt.model.Meme;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindSongActivity extends AppCompatActivity {

    ListView soundView;
    String[] items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_song);
        soundView = (ListView) findViewById(R.id.soundView);

        final List<File> sounds = findsSounds(Environment.getExternalStorageDirectory());

        toast(sounds.size()+"");

        SoundAdapter soundAdapter = new SoundAdapter(this,R.layout.sound_cell,sounds);

//        for(int i=0; i<sounds.size();i++){
//            toast(sounds.get(i).getName().toString());
//        }

        soundView.setAdapter(soundAdapter);

        soundView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("sound",sounds.get(position).toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    public List<File> findsSounds(File root){
        List<File> soundFile = new ArrayList<File>();
        File[] files = root.listFiles();
        for(File file : files){
            if(file.isDirectory() && !file.isHidden()){
                soundFile.addAll(findsSounds(file));
            }else{
                if(file.getName().endsWith(".mp3")){
                    soundFile.add(file);
                }
            }
        }
        return soundFile;
    }

    public void toast(String text){
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }


}

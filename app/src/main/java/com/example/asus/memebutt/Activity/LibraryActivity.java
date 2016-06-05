package com.example.asus.memebutt.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.asus.memebutt.Adapter.MemeLibraryAdapter;
import com.example.asus.memebutt.R;
import com.example.asus.memebutt.model.App;

public class LibraryActivity extends AppCompatActivity {

    MemeLibraryAdapter memeLibraryAdapter;
    ListView memeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        this.initialize();
    }

    @Override
    protected void onResume() {
        super.onResume();
        memeLibraryAdapter.notifyDataSetChanged();
    }

    private void initialize(){
        memeListView = (ListView)findViewById(R.id.memeListView);
        memeLibraryAdapter = new MemeLibraryAdapter(this,R.layout.meme_library_cell,App.getInstance().getMemes());
        memeListView.setAdapter(memeLibraryAdapter);

        memeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                App.getInstance().setCurrentMeme(position);
                finish();
            }
        });

        FloatingActionButton addMeme = (FloatingActionButton)findViewById(R.id.addMemeFab);
        addMeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibraryActivity.this,AddMemeActivity.class);
                startActivity(intent);
            }
        });
    }
}

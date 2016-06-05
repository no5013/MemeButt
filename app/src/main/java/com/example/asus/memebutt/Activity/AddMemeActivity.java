package com.example.asus.memebutt.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.memebutt.R;
import com.example.asus.memebutt.model.Meme;
import com.example.asus.memebutt.model.Storage;

import org.w3c.dom.Text;

public class AddMemeActivity extends AppCompatActivity {

    private static final int FIND_SOUND = 0;
    private static final int RESULT_LOAD_IMAGE = 1;

    TextView soundName;
    ImageView memePictureView;
    EditText memeTitle;

    private String memeSound;
    private String memePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_button);

        Button browsePictureButton = (Button)findViewById(R.id.browsePictureButton);
        Button browseSoundButton = (Button)findViewById(R.id.browseSoundButton);
        Button addMemeButton = (Button)findViewById(R.id.addMemeButton);
        soundName = (TextView)findViewById(R.id.addSoundName);
        memeTitle = (EditText)findViewById(R.id.memeTitleField);
        memePictureView = (ImageView)findViewById(R.id.memePictureView);

        browsePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                    startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        browseSoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddMemeActivity.this,FindSongActivity.class);
                startActivityForResult(intent,FIND_SOUND);
            }
        });

        addMemeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = ""+memeTitle.getText();
                String picture = memePicture;
                String sound = memeSound;

                if(title==null||title==""){
                    toast("PLEASE INPUT TITLE");
                }
                else if(picture==null||picture==""){
                    toast("PLEASE SELECT IMAGE");
                }
                else if(sound==null||sound==""){
                    toast("PLEASE SELECT SOUND");
                }else{
                    Meme newMeme = new Meme(title,picture,Storage.getInstance().getDefaultButton(),memeSound);
                    Storage.getInstance().addMeme(newMeme);
                    finish();
                }
            }
        });


    }

    public void toast(String msg){
        Toast.makeText(AddMemeActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data==null)
            return;

        if (requestCode == FIND_SOUND && resultCode == Activity.RESULT_OK) {

            memeSound = data.getExtras().getString("sound");
            soundName.setText(memeSound);

        }

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            memePicture = cursor.getString(columnIndex);
            cursor.close();
        }

        setMemeView();
    }

    public void setMemeView(){
        if(memePicture!=null)
            memePictureView.setImageBitmap(BitmapFactory.decodeFile(memePicture));

        if(memeSound!=null)
            soundName.setText(memeSound);
    }


}

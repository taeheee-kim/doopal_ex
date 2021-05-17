package com.cookandroid.splash_pleazz;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AudioListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audiostreamingpage);

        ExpandableListView Audio_ListView = (ExpandableListView) findViewById(R.id.Audio_ListView);
        final ArrayList<AudioFiles> Voices = getData();

        AudioListAdapter adapter = new AudioListAdapter(this, Voices);
        Audio_ListView.setAdapter(adapter);

        Audio_ListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            MediaPlayer mediaPlayer;

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                try {
                    mediaPlayer = new MediaPlayer();
//                    if(mediaPlayer.isPlaying()) {
//                        mediaPlayer.pause();
//                    }
                    String url = Voices.get(groupPosition).Url.get(childPosition);
                    mediaPlayer.setDataSource(url);
//                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                        @Override
//                        public void onPrepared(MediaPlayer mp) {
//                            mp.start();
//                        }
//                    });
                    mediaPlayer.prepare();
                    mediaPlayer.start();

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                return false;
            }
        });

    }
    private ArrayList<AudioFiles> getData(){
        AudioFiles a1 = new AudioFiles("test voice 1");
        a1.AudioComment.add("테스트 1");
        a1.AudioComment.add("테스트 2");
        a1.Url.add("https://firebasestorage.googleapis.com/v0/b/project-1252226275473945869.appspot.com/o/Audio1.m4a?alt=media&token=7111f393-d7e7-4305-bdc2-b2b2467ccfca");
        a1.Url.add("https://firebasestorage.googleapis.com/v0/b/project-1252226275473945869.appspot.com/o/Audio2.m4a?alt=media&token=3bd6d687-0d70-4f87-9e6b-503349beccb6");
        a1.FileName.add("Audio1.m4a");
        a1.FileName.add("Audio2.m4a");

        AudioFiles a2 = new AudioFiles("text voice 2");
        a2.AudioComment.add("테스트 3");
        a2.AudioComment.add("테스트 4");
        a2.Url.add("https://firebasestorage.googleapis.com/v0/b/project-1252226275473945869.appspot.com/o/Audio3.m4a?alt=media&token=4d0928b5-2373-43cb-b5b4-9b9ef9b6217d");
        a2.FileName.add("Audio3.m4a");

        AudioFiles a3 = new AudioFiles("text voice 3");
        AudioFiles a4 = new AudioFiles("text voice 4");
        AudioFiles a5 = new AudioFiles("text voice 5");
        AudioFiles a6 = new AudioFiles("text voice 6");
        AudioFiles a7 = new AudioFiles("text voice 7");

        ArrayList<AudioFiles> allAudioFiles = new ArrayList<>();
        allAudioFiles.add(a1);
        allAudioFiles.add(a2);
        allAudioFiles.add(a3);
        allAudioFiles.add(a4);
        allAudioFiles.add(a5);
        allAudioFiles.add(a6);
        allAudioFiles.add(a7);


        return allAudioFiles;
    }

}

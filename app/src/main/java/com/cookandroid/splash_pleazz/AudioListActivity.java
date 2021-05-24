package com.cookandroid.splash_pleazz;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;

public class AudioListActivity extends AppCompatActivity {

    ArrayList<AudioFiles> Voices = getData();                       //계속 바뀔 리스트
    ArrayList<AudioFiles> VoicesOriginal = getData();              //원래 리스트. 바뀌지 않음

    AudioListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audiostreamingpage);

        EditText editSearch = (EditText) findViewById(R.id.editSearch);

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                search(text);

            }
        });


        ExpandableListView Audio_ListView = (ExpandableListView) findViewById(R.id.Audio_ListView);


        // AudioListAdapter adapter = new AudioListAdapter(this, Voices);
        adapter = new AudioListAdapter(this,Voices);
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

    public void search(String charText) {

        Voices.clear();

        if (charText.length() <= 0){
            Voices.addAll(VoicesOriginal);
            Toast.makeText(getApplicationContext(),"대사를 입력하세요",Toast.LENGTH_SHORT).show();
        }
        else {

            for (int i = 0 ; i < VoicesOriginal.size(); i++){
                if (VoicesOriginal.get(i).Voice.toLowerCase().contains(charText)){
                    Toast.makeText(getApplicationContext(),"일치하는 결과 존재",Toast.LENGTH_SHORT).show();
                    Voices.add(VoicesOriginal.get(i));
                }
            }




//            for(int i = 0;i < Voices_forSearch.size(); i++)
//            {
//                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
//                if (voice_parent_name.get(i).toLowerCase().contains(charText))
//                {
//                    // 검색된 데이터를 리스트에 추가한다.
//
//                    Voices.add(voice_parent_name.get(i));
//                }
//            }
        }
        adapter.notifyDataSetChanged();
    }

}

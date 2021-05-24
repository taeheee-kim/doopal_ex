package com.cookandroid.splash_pleazz;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class PopupActivity extends Activity {
    Button btn_pop_play,btn_pop_pause,btn_pop_download;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_activity);

        //UI 객체 생성
        btn_pop_play = (Button)findViewById(R.id.btn_pop_play);
        btn_pop_pause = (Button)findViewById(R.id.btn_pop_pause);
        btn_pop_download = (Button)findViewById(R.id.btn_pop_download);

        btn_pop_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer;
                mediaPlayer = new MediaPlayer();
                String url = "https://firebasestorage.googleapis.com/v0/b/project-1252226275473945869.appspot.com/o/Audio1.m4a?alt=media&token=7111f393-d7e7-4305-bdc2-b2b2467ccfca";
                try {
                    mediaPlayer.setDataSource(url);
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
            }
        });
        //데이터 가져오기
        //Intent intent = getIntent();
        //String data = intent.getStringExtra("data");
        //txtText.setText(data);
    }

    public void mOnClose(View v){
        //데이터 전달하기
        Intent intent = new Intent();
        intent.putExtra("result","Close Popup");
        setResult(RESULT_OK,intent);

        //팝업창 닫기
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        //바깥레이어 클릭시 안 닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed(){
        //안드로이드 백버튼 막기
        return;
    }
}

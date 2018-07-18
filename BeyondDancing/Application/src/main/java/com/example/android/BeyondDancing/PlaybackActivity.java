package com.example.android.BeyondDancing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import android.widget.MediaController;

import java.util.Observable;
import java.util.Observer;


public class PlaybackActivity extends Activity implements Observer {
    DanceModel DModel;
    Button restartbutton;
    Button startstopbutton;
    VideoView video1;
    VideoView video2;
    MediaController vidcrlone;
    MediaController vidcrltwo;

    int playbuttonclick;
    int vidonestate;
    int vidtwostate;
    int vidonepos;
    int vidtwopos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_playback);

        // Get Model instance
        DModel = DanceModel.getInstance();
        DModel.addObserver(this);


    //set view info
        restartbutton = findViewById(R.id.button2);
        startstopbutton = findViewById(R.id.button3);
        video1 = findViewById(R.id.videoView);
        video2 = findViewById(R.id.videoView2);
        restartbutton.setText("Start");
    /*
        playbutton.isLongClickable();
        playbutton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                video1.start();
                video2.start();
                playbuttonclick =1;
                return false;
            }
        });

    */







        vidcrlone = new MediaController(this);
        vidcrltwo = new MediaController(this);
        vidcrlone.setAnchorView(video1);
        vidcrltwo.setAnchorView(video2);
        vidonestate =0;
        vidtwostate =0;
        vidonepos =0;
        vidtwopos =0;


        //setup uri
        String videoone = "android.resource://" + getPackageName() + "/" + R.raw.test1;
        ;
        String videotwo = "android.resource://" + getPackageName() + "/" + R.raw.test2;
        ;
        Uri video1uri = Uri.parse(videoone);
        Uri video2uri = Uri.parse(videotwo);
        video1.setVideoURI(video1uri);
        video2.setVideoURI(video2uri);
        //video1.setMediaController(vidcrlone);
        // video2.setMediaController(vidcrltwo);


        DModel.initObservers();


    }
    // CONTROLLERS
    public void startboth(View v) {
        //if (playbuttonclick == 0) {
            vidonestate =0;
            vidtwostate =0;
            vidonepos =0;
            vidtwopos =0;
            video1.seekTo(vidonepos);
             video2.seekTo(vidtwopos);
            video1.start();
            video2.start();

            playbuttonclick = 1;
           startstopbutton.setText("Pause");
            restartbutton.setText("Restart");
            /*
        } else if (playbuttonclick ==1){
            video1.pause();
            video2.pause();
            playbuttonclick =2;
        } else if (playbuttonclick ==2){
            video1.resume();;
            video2.resume();
            playbuttonclick = 1;
        }
*/
    }
    public void toRecord(View v) {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }
    @SuppressLint("SetTextI18n")
    public void playstop(View v){
        CharSequence currenttext = startstopbutton.getText();
        if(currenttext == "Pause"){
            video1.pause();
            video2.pause();
            vidonepos = video1.getCurrentPosition();
            vidtwopos = video2.getCurrentPosition();

            vidonestate = 1;
            vidtwostate = 1;
            startstopbutton.setText("Play");
        } else {
            video1.seekTo(vidonepos);
            video2.seekTo(vidtwopos);
            video1.start();

            video2.start();
            vidonestate = 0;
            vidtwostate = 0;
            startstopbutton.setText("Pause");
        }
    }

    public void vidonecrl(View v) {
        if (vidonestate == 0) {
            vidonepos = video1.getCurrentPosition();
            video1.pause();
            vidonestate = 1;

        } else {
            video1.seekTo(vidonepos);
            video1.start();
            vidonestate = 0;
        }
    }

    public void vidtwocrl(View v){
        if (vidtwostate == 0) {
            vidtwopos = video2.getCurrentPosition();
            video2.pause();
            vidtwostate = 1;
        } else {
            video2.seekTo(vidtwopos);
            video2.start();
            vidtwostate = 0;
        }
    }


    @Override
    public void update(Observable o, Object arg) {

    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();


        // Remove observer when activity is destroyed.
        DModel.deleteObserver(this);
    }
}




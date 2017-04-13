package com.example.monkey.finalproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.monkey.finalproject.audio.MusicController;
import com.example.monkey.finalproject.util.UtilTime;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayActivity extends LinearLayout implements MusicController.IPlayerStatus{

    private final View view;
    private final MusicController controller;
    private PlayPagerActivity mContext;

    @BindView(R.id.main_player_title)
    TextView name;

    @BindView(R.id.main_play_play)
    ImageView playBt;

    @BindView(R.id.pb_play_loading)
    ProgressBar progressBar;

    @BindView(R.id.main_play_seekbar)
    SeekBar seekBar;

    @BindView(R.id.main_play_totaltime)
    TextView totalTime;

    @BindView(R.id.play_play_seektime)
    TextView seekTime;

    @OnClick(R.id.main_play__next)
    public void next(){
        controller.playNext();
    }

    @OnClick(R.id.main_play__last)
    public void previous(){
        controller.playPrevious();
    }

    @OnClick(R.id.main_play_play)
    public void play(){
        if (!controller.isPlaying) {
            mContext.toastShort("Play");
            controller.play();
        } else {
            controller.pause();
        }
    }


    @OnClick(R.id.select)
    public void toMusic(){
        final ClickDialogActivity dialog = new ClickDialogActivity(this.getContext(), new ClickDialogActivity.IClickDialogEventListenerClick() {
            @Override
            public void onToFirst() {
                controller.position = 0;
                controller.play();
            }

            @Override
            public void onToSecond(){
                controller.position = 1;
                controller.play();
            }

            @Override
            public void onToThird(){
                controller.position = 2;
                controller.play();
            }
        });
        dialog.show();
    }



    public PlayActivity(final Context context) {
        super(context);
        this.mContext = (PlayPagerActivity)context;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.activity_play, this);
        ButterKnife.bind(this,view);
        controller = MusicController.getInstance(mContext);
        controller.setPlayList(mContext.getContent());
        controller.addListener("PlayView", this);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekTime.setText(UtilTime.secToTime(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                controller.play(seekBar.getProgress());
            }
        });
    }

    public void update(){

    }


    private void prepareStatus() {
        playBt.setBackgroundResource(R.drawable.playscreen_play_pause);
        playBt.setVisibility(INVISIBLE);
        progressBar.setVisibility(VISIBLE);
    }

    private void pauseStatus() {
        playBt.setBackgroundResource(R.drawable.playscreen_play_pause);
        playBt.setVisibility(VISIBLE);
        progressBar.setVisibility(INVISIBLE);
    }

    private void startStatus() {
        playBt.setBackgroundResource(R.drawable.playscreen_play_play);
        playBt.setVisibility(VISIBLE);
        progressBar.setVisibility(INVISIBLE);
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onProgress(int i) {
        seekBar.setProgress(i);
        seekTime.setText(UtilTime.secToTime(i));
    }

    @Override
    public void onError(String error) {
        mContext.toastShort(error);
    }

    @Override
    public void onPrepared() {

    }

    @Override
    public void onSeekComplete() {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onUpdateCache(int i) {

    }

    @Override
    public void onPause() {
        startStatus();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart(int i) {
        mContext.toastShort("Started");
        seekBar.setMax(i);
        totalTime.setText(UtilTime.secToTime(i));
        pauseStatus();
    }

    @Override
    public void onInitComplete() {

    }
}


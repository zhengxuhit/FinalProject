package com.example.monkey.finalproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.monkey.finalproject.adapter.ListViewAdapter;
import com.example.monkey.finalproject.audio.BaseAudioOb;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity{

    private Animation alphaAnimation;
    public final int DIALOG = 12345;
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DIALOG:
                    Bundle bundle = msg.getData();
                    String s = bundle.getString("msg");
                    break;
                default:
            }
            super.handleMessage(msg);
        }
    };

    @BindView(R.id.welcome)
    ImageButton ib;

    @OnClick(R.id.welcome)
    public void alpha1(){
        ib.startAnimation(alphaAnimation);
        progressDialog();
    }

    private void progressDialog() {
        final int MAX_PROGRESS = 10;
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("Downloading");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                while (progress<MAX_PROGRESS){
                    try{
                        Thread.sleep(50);
                        progress++;
                        progressDialog.setProgress(progress);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                Message msg = Message.obtain();
                Bundle bundle = new Bundle();
                msg.what = DIALOG;
                bundle.putString("msg", "Download success");
                msg.setData(bundle);
                mHandler.sendMessage(msg);
                //mHandler.handleMessage(msg);
                progressDialog.cancel();
            }
        }).start();
        toActivity(ListViewActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initialAnimation();
    }

    private void initialAnimation() {
        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
    }
}

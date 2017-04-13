package com.example.monkey.finalproject;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.monkey.finalproject.adapter.ViewPagerAdapter;
import com.example.monkey.finalproject.audio.BaseAudioOb;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayPagerActivity extends BaseActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private ArrayList<BaseAudioOb> contentList = new ArrayList<BaseAudioOb>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_pager);
        ButterKnife.bind(this);
        initInfo();
        initial();
    }

    private void initial(){
        ArrayList<View> viewList = new ArrayList<View>();
        viewList.add(new PlayActivity(this));
        viewPager.setAdapter(new ViewPagerAdapter(viewList));
    }

    private void initInfo() {


        AudioOb m1 = new AudioOb();
        m1.setURL("https://hydra-media.cursecdn.com/wow.gamepedia.com/6/6b/Legends_of_Azeroth.ogg");
        m1.setName("Legends of Azeroth");

        AudioOb m2 = new AudioOb();
        m2.setURL("https://hydra-media.cursecdn.com/dota2.gamepedia.com/6/61/Music_default_ui_hero_select.mp3");
        m2.setName("Hero Select");

        AudioOb m3 = new AudioOb();
        m3.setURL("https://hydra-media.cursecdn.com/dota2.gamepedia.com/4/44/Music_default_battle_01.mp3");
        m3.setName("Battle");

        contentList.add(m1);
        contentList.add(m2);
        contentList.add(m3);
    }

    public ArrayList<BaseAudioOb> getContent(){
        return contentList;
    }
}

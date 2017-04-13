package com.example.monkey.finalproject;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.monkey.finalproject.adapter.ViewPagerAdapter;
import com.example.monkey.finalproject.fragment.FirstFragment;
import com.example.monkey.finalproject.fragment.SecondFragment;
import com.example.monkey.finalproject.fragment.ThirdFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WpViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wp_view_pager);
        ButterKnife.bind(this);
        initial();
    }

    private void initial(){
        ArrayList<View> viewList = new ArrayList<View>();
        viewList.add(new FirstFragment(this));
        viewList.add(new SecondFragment(this));
        viewList.add(new ThirdFragment(this));
        viewPager.setAdapter(new ViewPagerAdapter(viewList));
    }
}

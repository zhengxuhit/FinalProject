package com.example.monkey.finalproject.fragment;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.monkey.finalproject.R;

import butterknife.ButterKnife;

public class ThirdFragment extends LinearLayout {

    private final View view;

    public ThirdFragment(Context context) {
        // Required empty public constructor
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.third_fragment, this);
        ButterKnife.bind(this,view);
    }
}

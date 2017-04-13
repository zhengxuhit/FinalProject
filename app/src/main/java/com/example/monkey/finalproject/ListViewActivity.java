package com.example.monkey.finalproject;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.monkey.finalproject.adapter.ListViewAdapter;
import com.example.monkey.finalproject.view.About;
import com.example.monkey.finalproject.view.Battle;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Monkey on 4/11/17.
 */

public class ListViewActivity extends BaseActivity implements AdapterView.OnItemClickListener{

    private ArrayList<String> listResult;

    @BindView(R.id.list_view)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);
        listResult = new ArrayList<String>();
        createFakeResult();
        View view = getLayoutInflater().inflate(R.layout.list_view_header, null);
        LinearLayout listViewHeader = (LinearLayout) view.findViewById(R.id.list_view_header);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, listResult);

        listView.addHeaderView(listViewHeader);

        TextView tv = new TextView(this);
        tv.setText("No more content.");
        tv.setTextSize(26);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
        listView.invalidateViews();
    }

    public void createFakeResult(){
        listResult.add("Wallpapers");
        listResult.add("Introduction");
        listResult.add("Background Music");
        listResult.add("Battle");
        listResult.add("About us");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, listResult.get(position)+" was clicked.", Toast.LENGTH_LONG).show();

        switch (position) {
            case 1:
                toActivity(WpViewPagerActivity.class);
                break;
            case 2:
                toActivity(InfoActivity.class);
                break;
            case 3:
                toActivity(PlayPagerActivity.class);
                break;
            case 4:
                toActivity(Battle.class);
                break;
            case 5:
                toActivity(About.class);
                break;
            default:
                break;
        }

    }
}

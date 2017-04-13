package com.example.monkey.finalproject;

import com.example.monkey.finalproject.audio.BaseAudioOb;

/**
 * Created by Monkey on 4/11/17.
 */

public class AudioOb extends BaseAudioOb {
    private String name;
    private String size;
    private String duration;
    private String info;
    private String iconUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}

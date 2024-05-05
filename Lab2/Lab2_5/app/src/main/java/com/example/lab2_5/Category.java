package com.example.lab2_5;

import android.graphics.drawable.Drawable;


public class Category {
    String name;
    int thumbnail;
    Boolean is_promote;

    public Category(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public  int getImage()
    {
        return thumbnail;
    }
}

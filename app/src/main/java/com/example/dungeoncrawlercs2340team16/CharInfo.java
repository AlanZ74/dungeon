package com.example.dungeoncrawlercs2340team16;

import android.widget.ImageView;

public class CharInfo {
    private ImageView imageView;
    private int width;
    private int height;
    public CharInfo(ImageView iv, int width, int height) {
        this.imageView = iv;
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public int getX() {
        return (int) imageView.getX();
    }
    public int getY() {
        return (int) imageView.getX();
    }

    public ImageView getIv() {
        return imageView;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

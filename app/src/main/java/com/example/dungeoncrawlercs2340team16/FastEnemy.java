package com.example.dungeoncrawlercs2340team16;

import android.widget.ImageView;

class FastEnemy extends Enemy {
    public FastEnemy(ImageView sprite, int screenWidth, int screenHeight) {
        super(EnemyType.TYPE1, sprite, screenWidth, screenHeight);
        // FastEnemy might have increased speed or other attributes
    }

    @Override
    public void moveRandomly() {
        // Define fast movement behavior
        // For example, move 2x the standard random distance
        ImageView sprite = getSprite(); // Access sprite using the getter method
        int newX = (int) (Math.random() * (getScreenWidth() - sprite.getWidth())) * 3;
        // Use getter for screenWidth
        int newY = (int) (Math.random() * (getScreenHeight() - sprite.getHeight())) * 3;
        // Use getter for screenHeight
        sprite.setX(newX);
        sprite.setY(newY);
    }
}


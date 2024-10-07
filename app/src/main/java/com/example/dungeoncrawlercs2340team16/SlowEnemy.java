package com.example.dungeoncrawlercs2340team16;

import android.widget.ImageView;

class SlowEnemy extends Enemy {
    public SlowEnemy(ImageView sprite, int screenWidth, int screenHeight) {
        super(EnemyType.TYPE2, sprite, screenWidth, screenHeight);
        // SlowEnemy might have reduced speed or other attributes
    }

    @Override
    public void moveRandomly() {
        // Define slow movement behavior
        // For example, move half the standard random distance
        ImageView sprite = getSprite();
        int newX = (int) (Math.random() * (getScreenWidth() - sprite.getWidth()) * 0.35);
        int newY = (int) (Math.random() * (getScreenHeight() - sprite.getHeight()) * 0.35);
        sprite.setX(newX);
        sprite.setY(newY);
    }
}
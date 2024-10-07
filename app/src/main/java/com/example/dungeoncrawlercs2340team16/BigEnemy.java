package com.example.dungeoncrawlercs2340team16;

import android.widget.ImageView;

class BigEnemy extends Enemy {
    public BigEnemy(ImageView sprite, int screenWidth, int screenHeight) {
        super(EnemyType.TYPE4, sprite, screenWidth, screenHeight);
        // LargeEnemy might have specific attributes related to size
    }

    // No need to override moveRandomly() if behavior is the same as Enemy
}
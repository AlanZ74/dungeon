package com.example.dungeoncrawlercs2340team16;

import android.widget.ImageView;

class SmallEnemy extends Enemy {
    public SmallEnemy(ImageView sprite, int screenWidth, int screenHeight) {
        super(EnemyType.TYPE3, sprite, screenWidth, screenHeight);
        // SmallEnemy might have specific attributes related to size
    }

    // No need to override moveRandomly() if behavior is the same as Enemy
}
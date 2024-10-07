package com.example.dungeoncrawlercs2340team16;

import android.widget.ImageView;
import android.widget.RelativeLayout;

public class EnemyFactory {

    // This method creates an enemy based on the type and adds it to the layout
    public Enemy createEnemy(EnemyType type, RelativeLayout gameLayout, int screenWidth,
                             int screenHeight) {
        // Create an ImageView to represent the enemy sprite
        ImageView sprite = new ImageView(gameLayout.getContext());

        // Create an enemy instance to determine its size
        Enemy tempEnemy = new Enemy(type, sprite, screenWidth, screenHeight);
        // Temporarily create an enemy to get its size

        // Use the size from the temporary enemy object to set the layout parameters
        int enemySize = tempEnemy.getSize(); // Get the size from the enemy object
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(enemySize,
                enemySize);

        // Set the position of the enemy sprite within the RelativeLayout at random positions:
        layoutParams.leftMargin = (int) (Math.random() * (screenWidth - enemySize));
        layoutParams.topMargin = (int) (Math.random() * (screenHeight - enemySize));

        // Set the layout parameters to the sprite
        sprite.setLayoutParams(layoutParams);

        // Set the appropriate image resource and size based on the enemy type
        // Now create the actual enemy instance with the correctly sized sprite
        if (type == EnemyType.TYPE1) {
            return new FastEnemy(sprite, screenWidth, screenHeight);
        } else if (type == EnemyType.TYPE2) {
            return new SlowEnemy(sprite, screenWidth, screenHeight);
        } else if (type == EnemyType.TYPE3) {
            return new SmallEnemy(sprite, screenWidth, screenHeight);
        } else if (type == EnemyType.TYPE4) {
            return new BigEnemy(sprite, screenWidth, screenHeight);
        } else {
            return new BigEnemy(sprite, screenWidth, screenHeight);
        }
    }
}

package com.example.dungeoncrawlercs2340team16;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.util.List;

public class Sword {
    private int swordDamage;
    private Drawable swordImage;
    private int swordWidth;
    private int swordHeight;

    public Sword(Context context) {
        this.swordDamage = 50000; // Enough to destroy an enemy in one hit
        this.swordImage = context.getResources().getDrawable(R.drawable.sword, context.getTheme());
        this.swordWidth = 100;
        this.swordHeight = 100;
    }

    public void attack(Player player, List<Enemy> enemies, ImageView swordImageView) {
        // Position the sword next to the player
        if (swordImageView.getVisibility() != View.VISIBLE) {
            return;
        }

        // Position the sword next to the player
        positionSword(player, swordImageView);

        // Define the sword's hitbox
        Rect swordHitbox = new Rect(
                (int) swordImageView.getX(),
                (int) swordImageView.getY(),
                (int) swordImageView.getX() + swordWidth,
                (int) swordImageView.getY() + swordHeight
        );

        // Flag to indicate if an enemy has been hit
        boolean enemyHit = false;

        // Iterate through the enemies and check for collisions
        for (Enemy enemy : enemies) {
            Log.d("SwordAttack", "Collision with Enemy Type: " + enemy.getType());

            if (enemyHit) {
                break; // Exit if an enemy has already been hit
            }

            // Ensure enemy sprite is not null and enemy is visible
            if (enemy.getSprite() != null) {
                Rect enemyHitbox = new Rect(
                        enemy.getX(),
                        enemy.getY(),
                        enemy.getX() + enemy.getWidth(),
                        enemy.getY() + enemy.getHeight()
                );

                if (Rect.intersects(swordHitbox, enemyHitbox)) {
                    enemy.takeDamage(swordDamage);
                    enemyHit = true; // Mark that an enemy has been hit

                }
            }
        }
    }


    private void positionSword(Player player, ImageView swordImageView) {
        // Position the sword relative to the player
        float swordX = player.getX() + player.getWidth(); // Adjust as needed
        float swordY = player.getY() + player.getHeight() / 2; // Adjust as needed
        swordImageView.setX(swordX);
        swordImageView.setY(swordY);
    }

}


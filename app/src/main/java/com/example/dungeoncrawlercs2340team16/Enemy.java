package com.example.dungeoncrawlercs2340team16;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Enemy {
    private EnemyType type;
    private int strength;
    private int size;
    private ImageView sprite;
    protected int screenWidth;
    protected int screenHeight;

    private int x;
    private int y;

    private int width;  // Enemy's width for collision detection
    private int height; // Enemy's height for collision detection

    private int health;


    // Constructor
    public Enemy(EnemyType type, ImageView sprite, int screenWidth, int screenHeight) {
        this.type = type;
        this.sprite = sprite;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        assignAttributesBasedOnType();
        assignSpriteBasedOnType();
        moveRandomly(); // Set the initial position randomly
    }

    public Enemy(EnemyType type, int x, int y, int health) {
        // Initialize enemy with provided parameters
        this.type = type;
        this.x = x;
        this.y = y;
        this.health = health;
    }

    private void assignAttributesBasedOnType() {
        // Assign different strengths and sizes based on enemy type
        if (type == EnemyType.TYPE1) {
            strength = 10;
            health = 50;
            size = 250;
        } else if (type == EnemyType.TYPE2) {
            strength = 20;
            health = 75;
            size = 250;
        } else if (type == EnemyType.TYPE3) {
            strength = 15;
            health = 60;
            size = 155;
        } else if (type == EnemyType.TYPE4) {
            strength = 25;
            health = 100;
            size = 465;
        }
        width = size;  // Assign width
        height = size; // Assign height
    }

    private void assignSpriteBasedOnType() {
        // Assign different sprites based on enemy type
        if (type == EnemyType.TYPE1) {
            sprite.setImageResource(R.drawable.goomba);
        } else if (type == EnemyType.TYPE2) {
            sprite.setImageResource(R.drawable.boo);
        } else if (type == EnemyType.TYPE3) {
            sprite.setImageResource(R.drawable.shyguy);
        } else {
            sprite.setImageResource(R.drawable.bowser);
        }

        // Set the size of the ImageView to match the enemy's size
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(size, size);
        sprite.setLayoutParams(params);
    }

    // Method to move the enemy randomly
    public void moveRandomly() {
        int newX = (int) (Math.random() * (screenWidth - size));
        int newY = (int) (Math.random() * (screenHeight - size));
        this.x = newX;
        this.y = newY;
        sprite.setX(newX);
        sprite.setY(newY);
    }

    public boolean isCollidingWithPlayer(Player player) {
        return x < player.getX() + player.getWidth()
                && x + size > player.getX()
                && y < player.getY() + player.getHeight()
                && y + size > player.getY();
    }


    public void takeDamage(int damage) {
        this.health -= damage;
        Log.d("EnemyDamage", "Enemy Type: " + type + " New Health: " + health);

        if (this.health <= 0) {
            this.sprite.setVisibility(View.GONE); // Hides the enemy if health is 0
        }
    }

    // Getters and Setters

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public EnemyType getType() {
        return type;
    }

    public int getStrength() {
        return strength;
    }

    public int getSize() {
        return size;
    }

    public ImageView getSprite() {
        return sprite;
    }

    protected int getScreenWidth() {
        return screenWidth;
    }

    protected int getScreenHeight() {
        return screenHeight;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
        sprite.setX(x);
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
        sprite.setY(y);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}

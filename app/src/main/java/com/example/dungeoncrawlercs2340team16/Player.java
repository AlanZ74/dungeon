package com.example.dungeoncrawlercs2340team16;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String character;
    private int health;
    private String name;
    private int x;
    private int y; // Position of player

    private int width;  // Player's width for collision detection
    private int height; // Player's height for collision detection

    private List<Observer> observers = new ArrayList<>();

    private static Player player;

    private Player(String name, String character, int health) {
        this.name = name;
        this.character = character;
        this.health = health;
    }

    private Player(String name, String character, int health, int width, int height) {
        this.name = name;
        this.character = character;
        this.health = health;
        this.width = width;
        this.height = height;
    }


    private Player(String name, String character) {
        this.name = name;
        this.character = character;
        this.health = 100;
    }

    public static Player getPlayer() {
        if (player == null) {
            player = new Player("", "");
        }
        return player;
    }

    public static Player getPlayer(String name, String character, int health) {
        if (player == null) {
            player = new Player(name, character, health);
        }
        return player;
    }

    public static Player getPlayer(String name, String character) {
        if (player == null) {
            player = new Player(name, character);
        }
        return player;
    }

    public int getHealth() {
        return health;
    }

    public String getCharacter() {
        return character;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean checkNameValidity(String s) {
        if (s == null || s.trim().equals("")) {
            return false;
        }
        return true;
    }


    // Positional methods
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // Observer pattern related methods
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    // Strategy pattern related method
    public void move(MovementStrategy strategy) {
        strategy.move(this);
        notifyObservers();  // Notify observers after moving
    }

    public boolean checkPowerUpCollide(boolean notCollided, CharInfo player, PowerUpInfo powerUp) {
        // returns state of notCollided for reassignment
        // We already have all of the player data, so we can just check based on that!
        if (notCollided) { // if true
            int xPos = player.getX();
            int yPos = player.getY();
            int powerX = powerUp.getX();
            int powerY = powerUp.getY();

            for (int row = 0; row < player.getWidth(); row++) {
                for (int col = 0; col < player.getHeight(); col++) {
                    if ((xPos + row >= powerX && xPos + row <= powerX + powerUp.getWidth())
                            && (yPos + col >= powerY && yPos + col <= powerY
                            + powerUp.getHeight())) {
                        // if collide, update thing + change viz
                        return false;
                    }
                }
            }
            return true; // if no collision, return true
        } else { // if already false, remain false
            return false;
        }
    } // end
}


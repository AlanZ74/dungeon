package com.example.dungeoncrawlercs2340team16;

public class TestMovementStrategy implements MovementStrategy {
    @Override
    public void move(Player player) {
        // Here, you can set player's position or any other property for testing
        player.setX(15);
        player.setY(20);
    }
}
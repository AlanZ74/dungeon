package com.example.dungeoncrawlercs2340team16;

public class MoveLeft implements MovementStrategy {
    @Override
    public void move(Player player) {
        player.setX(player.getX() - 1);
    }
}
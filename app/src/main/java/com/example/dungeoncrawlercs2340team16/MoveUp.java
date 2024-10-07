package com.example.dungeoncrawlercs2340team16;

public class MoveUp implements MovementStrategy {
    @Override
    public void move(Player player) {
        player.setX(player.getY() + 1);
    }
}
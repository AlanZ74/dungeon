package com.example.dungeoncrawlercs2340team16;

public class Renderer implements Observer {

    @Override
    public void update(Player player) {
        System.out.println("Player moved to position: (" + player.getX()
                + ", " + player.getY() + ")");
    }
}
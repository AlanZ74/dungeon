package com.example.dungeoncrawlercs2340team16;


import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


public class BombTests {
    private List<Enemy> enemies;
    @Before
    public void setUp() {
        enemies = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            Enemy enemy = new Enemy(EnemyType.TYPE1, 100 + i * 10, 100 + i * 10, 100);
            enemies.add(enemy);
        }
    }
    @Test
    public void testEnemy1TakesDamage() {
        takeDamage(enemies.get(0), 50);
        assertEquals(50, enemies.get(0).getHealth());
    }

    @Test
    public void testEnemy2TakesDamage() {
        takeDamage(enemies.get(1), 50);
        assertEquals(50, enemies.get(1).getHealth());
    }

    @Test
    public void testEnemy3TakesDamage() {
        takeDamage(enemies.get(2), 50);
        assertEquals(50, enemies.get(2).getHealth());
    }

    @Test
    public void testEnemy4TakesDamage() {
        takeDamage(enemies.get(3), 50);
        assertEquals(50, enemies.get(3).getHealth());
    }

    @Test
    public void testEnemy5TakesDamage() {
        takeDamage(enemies.get(4), 50);
        assertEquals(50, enemies.get(4).getHealth());
    }

    @Test
    public void testEnemy6TakesDamage() {
        takeDamage(enemies.get(5), 50);
        assertEquals(50, enemies.get(5).getHealth());
    }

    @Test
    public void testEnemy7TakesDamage() {
        takeDamage(enemies.get(6), 50);
        assertEquals(50, enemies.get(6).getHealth());
    }

    @Test
    public void testEnemy8TakesDamage() {
        takeDamage(enemies.get(7), 50);
        assertEquals(50, enemies.get(7).getHealth());
    }

    @Test
    public void testEnemy9TakesDamage() {
        takeDamage(enemies.get(8), 50);
        assertEquals(50, enemies.get(8).getHealth());
    }

    @Test
    public void testEnemy10TakesDamage() {
        takeDamage(enemies.get(9), 50);
        assertEquals(50, enemies.get(9).getHealth());
    }

    @Test
    public void testEnemy11TakesDamage() {
        takeDamage(enemies.get(10), 50);
        assertEquals(50, enemies.get(10).getHealth());
    }

    @Test
    public void testEnemy12TakesDamage() {
        takeDamage(enemies.get(11), 50);
        assertEquals(50, enemies.get(11).getHealth());
    }

    @Test
    public void testEnemy13TakesDamage() {
        takeDamage(enemies.get(12), 50);
        assertEquals(50, enemies.get(12).getHealth());
    }

    @Test
    public void testEnemy14TakesDamage() {
        takeDamage(enemies.get(13), 50);
        assertEquals(50, enemies.get(13).getHealth());
    }

    @Test
    public void testEnemy15TakesDamage() {
        takeDamage(enemies.get(14), 50);
        assertEquals(50, enemies.get(14).getHealth());
    }

    @Test
    public void testEnemy16TakesDamage() {
        takeDamage(enemies.get(15), 50);
        assertEquals(50, enemies.get(15).getHealth());
    }


    public void takeDamage(Enemy enemy, int damage) {
        int newHealth = enemy.getHealth() - damage;
        enemy.setHealth(newHealth);
    }
}

package com.example.dungeoncrawlercs2340team16;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest {
    private Player player = null;

    @Test
    public void checkSpaceName() {
        player = player.getPlayer("         ", "Link", 150);
        assertEquals("         ", player.getName());
        assertEquals("Link", player.getCharacter());
        assertEquals(150, player.getHealth());
    }
    @Test
    public void checkBlankName() {
        player = player.getPlayer("", "Link", 150);
        assertEquals("", player.getName());
        assertEquals("Link", player.getCharacter());
        assertEquals(150, player.getHealth());
    }
    @Test
    public void checkDefaultName() {
        player = player.getPlayer("Insert Name Here", "Link", 150);
        assertEquals("Insert Name Here", player.getName());
        assertEquals("Link", player.getCharacter());
        assertEquals(150, player.getHealth());
    }
    @Test
    public void checkNormalName() {
        player = player.getPlayer("John", "Link", 150);
        assertEquals("John", player.getName());
        assertEquals("Link", player.getCharacter());
        assertEquals(150, player.getHealth());
    }

    @Test
    public void checkMoveLeft() {
        player = player.getPlayer("", "", 100);
        int currXPos = player.getX();
        player.move(new MoveLeft());
        assertEquals(-1, player.getX() - currXPos);
    }

    @Test
    public void checkMoveRight() {
        player = player.getPlayer("", "", 100);
        int currXPos = player.getX();
        player.move(new MoveRight());
        assertEquals(1, player.getX() - currXPos);
    }

    @Test
    public void checkMoveUp() {
        player = player.getPlayer("", "", 100);
        int currYPos = player.getY();
        player.move(new MoveUp());
        assertEquals(1, player.getX() - currYPos);

    }
    @Test
    public void checkMoveCombination1() {
        player = player.getPlayer("", "", 100);
        int currYPos = player.getY();
        player.move(new MoveUp());
        player.move(new MoveDown());
        assertEquals(-1, player.getX() - currYPos);

    }
    @Test
    public void checkMoveCombination2() {
        player = player.getPlayer("", "", 100);
        int currYPos = player.getY();
        player.move(new MoveDown());
        player.move(new MoveUp());
        assertEquals(1, player.getX() - currYPos);

    }

    @Test
    public void checkMoveDown() {
        player = player.getPlayer("", "", 100);
        int currYPos = player.getY();
        player.move(new MoveDown());
        assertEquals(-1, player.getX() - currYPos);

    }
    @Test
    public void checkCombination1() {
        player = player.getPlayer("John", "link", 100);
        player.setX(0);
        player.setY(0);
        player.move(new MoveLeft());
        player.move(new MoveRight());
        assertEquals(0, player.getX());
    }
    @Test
    public void checkCombination2() {
        player = player.getPlayer("John", "link", 100);
        player.setX(0);
        player.setY(0);
        player.move(new MoveRight());
        player.move(new MoveLeft());
        assertEquals(0, player.getX());
    }
    @Test
    public void checkCombination3() {
        player = player.getPlayer("John", "link", 100);
        player.setX(0);
        player.setY(0);
        player.move(new MoveLeft());
        player.move(new MoveRight());
        player.move(new MoveUp());
        player.move(new MoveDown());
        assertEquals(-1, player.getX());
    }
    @Test
    public void checkCombination4() {
        player = player.getPlayer("John", "link", 100);
        player.setX(0);
        player.setY(0);
        player.move(new MoveLeft());
        player.move(new MoveRight());
        player.move(new MoveDown());
        player.move(new MoveUp());
        assertEquals(1, player.getX());
    }
    @Test
    public void checkLeftFromOrigin() {
        player = player.getPlayer("chad", "ur mom", 100);
        player.setX(0);
        player.setY(0);
        player.move(new MoveLeft());
        assertEquals(-1, player.getX());
    }

    @Test
    public void checkRightFromOrigin() {
        player = player.getPlayer("chad", "ur mom", 100);
        player.setX(0);
        player.setY(0);
        player.move(new MoveRight());
        assertEquals(1, player.getX());
    }
}

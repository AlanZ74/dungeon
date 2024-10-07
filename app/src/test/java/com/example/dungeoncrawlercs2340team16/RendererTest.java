package com.example.dungeoncrawlercs2340team16;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class RendererTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testUpdate() {
        Renderer renderer = new Renderer();
        Player player = Player.getPlayer("Test Player", "Test Character");
        player.setX(5);
        player.setY(10);

        player.addObserver(renderer);
        player.move(new TestMovementStrategy());  // Using the test movement strategy

        String expectedOutput = "Player moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\n";
        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void testUpdate2() {
        Renderer renderer = new Renderer();
        Player player = Player.getPlayer("Test Player", "Test Character");
        player.setX(4);
        player.setY(9);

        player.addObserver(renderer);
        player.move(new TestMovementStrategy());  // Using the test movement strategy

        String expectedOutput = "Player moved to position: (15, 20)\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testUpdate3() {
        Renderer renderer = new Renderer();
        Player player = Player.getPlayer("Test Player", "Test Character");
        player.setX(6);
        player.setY(11);

        player.addObserver(renderer);
        player.move(new TestMovementStrategy());  // Using the test movement strategy

        String expectedOutput = "Player moved to position: (15, 20)\nPlayer moved to position: (15, 20)\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testUpdate4() {
        Renderer renderer = new Renderer();
        Player player = Player.getPlayer("Test Player", "Test Character");
        player.setX(12);
        player.setY(2);

        player.addObserver(renderer);
        player.move(new TestMovementStrategy());  // Using the test movement strategy

        String expectedOutput = "Player moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\n";
        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    public void testUpdate5() {
        Renderer renderer = new Renderer();
        Player player = Player.getPlayer("Test Player", "Test Character");
        player.setX(3);
        player.setY(9);

        player.addObserver(renderer);
        player.move(new TestMovementStrategy());  // Using the test movement strategy

        String expectedOutput = "Player moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\n";
        assertEquals(expectedOutput, outContent.toString());
    }



    @Test
    public void testUpdate6() {
        Renderer renderer = new Renderer();
        Player player = Player.getPlayer("Test Player", "Test Character");
        player.setX(6);
        player.setY(11);

        player.addObserver(renderer);
        player.move(new TestMovementStrategy());  // Using the test movement strategy

        String expectedOutput = "Player moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\n";
        assertEquals(expectedOutput, outContent.toString());
    }



    @Test
    public void testUpdate7() {
        Renderer renderer = new Renderer();
        Player player = Player.getPlayer("Test Player", "Test Character");
        player.setX(16);
        player.setY(21);

        player.addObserver(renderer);
        player.move(new TestMovementStrategy());  // Using the test movement strategy

        String expectedOutput = "Player moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\n";
        assertEquals(expectedOutput, outContent.toString());
    }




    @Test
    public void testUpdate8() {
        Renderer renderer = new Renderer();
        Player player = Player.getPlayer("Test Player", "Test Character");
        player.setX(17);
        player.setY(22);

        player.addObserver(renderer);
        player.move(new TestMovementStrategy());  // Using the test movement strategy

        String expectedOutput = "Player moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\n";
        assertEquals(expectedOutput, outContent.toString());
    }




    @Test
    public void testUpdate9() {
        Renderer renderer = new Renderer();
        Player player = Player.getPlayer("Test Player", "Test Character");
        player.setX(18);
        player.setY(30);

        player.addObserver(renderer);
        player.move(new TestMovementStrategy());  // Using the test movement strategy

        String expectedOutput = "Player moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\nPlayer moved to position: (15, 20)\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}



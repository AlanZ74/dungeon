package com.example.dungeoncrawlercs2340team16;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestScoreClass {
    private Score s;
    //The following three test cases are made by Vaibhav Mishra.
    @Test
    public void testBothScoreAndName() {
        s = new Score(100, "Buzz");
        assertEquals(100, s.getScore());
        assertEquals("Buzz", s.getCharacterName());
    }
    @Test
    public void testSettingName() {
        s = new Score(50);
        s.setCharacterName("Vaibhav");
        assertEquals("Vaibhav", s.getCharacterName());
    }
    @Test
    public void testGettingName() {
        Score s = new Score(100, "Vaibhav");
        s.getCharacterName();
        assertEquals("Vaibhav", s.getCharacterName());
    }
    @Test
    public void testGetNameAndScore() {
        Score s = new Score(100, "Vaibhav");
        s.getCharacterName();
        assertEquals("Vaibhav", s.getCharacterName());
        s.getScore();
        assertEquals(100, s.getScore());
    }
    @Test
    public void testSetNameAndScore() {
        Score s = new Score(90, "Vaibhav");
        s.setCharacterName("Mishra");
        assertEquals("Mishra", s.getCharacterName());
        s.setScore(100);
        assertEquals(100, s.getScore());
    }
    @Test
    public void testGettingScore() {
        Score s = new Score(100, "Vaibhav");
        s.getScore();
        assertEquals(100, s.getScore());
    }
    @Test
    public void testDefaultConstructor() {
        s = new Score();
        assertEquals(0, s.getScore());
    }

    @Test
    public void testSetScoreDefault() {
        s = new Score();
        assertEquals(0, s.getScore());
        s.setScore(10); // in case we need to update the score
        assertEquals(10, s.getScore());
    }

    @Test
    public void testSetScore() {
        s = new Score(100, "Buzz");
        assertEquals(100, s.getScore());
        s.setScore(10); // in case we need to update the score
        assertEquals(10, s.getScore());
    }

    @Test
    public void testScoreDefaultName(){
        s = new Score();
        assertEquals(null,s.getCharacterName());
    }
}

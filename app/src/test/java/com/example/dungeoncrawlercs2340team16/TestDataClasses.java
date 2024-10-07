package com.example.dungeoncrawlercs2340team16;
import static org.junit.Assert.assertEquals;

import android.widget.ImageView;

import org.junit.Test;
public class TestDataClasses {
    // Arjun's Data Class Tests
    @Test
    public void testGetWidthCharInfo() {
        ImageView imageView = new ImageView(null);
        CharInfo charInfo = new CharInfo(imageView, 100, 200);
        assertEquals(100, charInfo.getWidth());
    }

    @Test
    public void testGetHeightCharInfo() {
        ImageView imageView = new ImageView(null);
        CharInfo charInfo = new CharInfo(imageView, 100, 200);
        assertEquals(200, charInfo.getHeight());
    }

    @Test
    public void testSetWidthCharInfo() {
        ImageView imageView = new ImageView(null);
        CharInfo charInfo = new CharInfo(imageView, 100, 200);
        charInfo.setWidth(150);
        assertEquals(150, charInfo.getWidth());
    }

    @Test
    public void testSetHeightCharInfo() {
        ImageView imageView = new ImageView(null);
        CharInfo charInfo = new CharInfo(imageView, 100, 200);
        charInfo.setHeight(250);
        assertEquals(250, charInfo.getHeight());
    }

    @Test
    public void testGetWidthPowerUpInfo() {
        ImageView imageView = new ImageView(null);
        PowerUpInfo PowerUpInfo = new PowerUpInfo(imageView, 100, 200);
        assertEquals(100, PowerUpInfo.getWidth());
    }

    @Test
    public void testGetHeightPowerUpInfo() {
        ImageView imageView = new ImageView(null);
        PowerUpInfo PowerUpInfo = new PowerUpInfo(imageView, 100, 200);
        assertEquals(200, PowerUpInfo.getHeight());
    }

    @Test
    public void testSetWidthPowerUpInfo() {
        ImageView imageView = new ImageView(null);
        PowerUpInfo powerUpInfo = new PowerUpInfo(imageView, 100, 200);
        powerUpInfo.setWidth(150);
        assertEquals(150, powerUpInfo.getWidth());
    }

    @Test
    public void testSetHeightPowerUpInfo() {
        ImageView imageView = new ImageView(null);
        PowerUpInfo charInfo = new PowerUpInfo(imageView, 100, 200);
        charInfo.setHeight(250);
        assertEquals(250, charInfo.getHeight());
    }
}

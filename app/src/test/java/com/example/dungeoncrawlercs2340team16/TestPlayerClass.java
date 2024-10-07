package com.example.dungeoncrawlercs2340team16;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPlayerClass {
    private Player p = null;

    @Test
    public void checkPlayerInstantiate() {
        p = p.getPlayer("Arjun", "Link", 100);
        assertEquals("Arjun", p.getName());
        assertEquals("Link", p.getCharacter());
        assertEquals(100, p.getHealth());
    }

    @Test
    public void checkPlayerInstantiateAbridgedConstructor() {

        p = p.getPlayer("Arjun", "Link");
        assertEquals("Arjun", p.getName());
        assertEquals("Link", p.getCharacter());
        assertEquals(100, p.getHealth());
    }

    @Test
    public void checkNameValidity() {
        p = p.getPlayer("Arjun", "Link", 150);
        assertEquals(true, p.checkNameValidity("hi"));
        assertEquals(false, p.checkNameValidity("   "));
    }

}

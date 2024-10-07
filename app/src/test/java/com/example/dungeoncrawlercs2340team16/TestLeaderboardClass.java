package com.example.dungeoncrawlercs2340team16;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestLeaderboardClass {
        private static Leaderboard leaderboard;


    @Test
        public void leaderboardAdd(){
            leaderboard = Leaderboard.getLeaderboard();
            leaderboard.leaderboardAdd(new String[]{"1","2"});
            assertEquals("1",leaderboard.getData().get(0)[0]);
            assertEquals("2",leaderboard.getData().get(0)[1]);
            assertEquals(1,leaderboard.getData().size());

        }
        @Test
    public void leaderboardRemove() {
        leaderboard = Leaderboard.getLeaderboard();
        leaderboard.leaderboardremove();
        assertEquals(0,leaderboard.getData().size());
    }

    @Test
    public void testLeaderboardRemoveWhenEmpty1() {
        leaderboard = Leaderboard.getLeaderboard();
        leaderboard.leaderboardAdd(new String[]{"1","2"});
        leaderboard.leaderboardremove();
        leaderboard.leaderboardremove();
        assertEquals(0,leaderboard.getData().size());
    }

    @Test
    public void testLeaderboardRemoveWhenEmpty2() {
        leaderboard = Leaderboard.getLeaderboard();
        leaderboard.leaderboardAdd(new String[]{"1","2"});
        leaderboard.leaderboardAdd(new String[]{"1","2"});
        leaderboard.leaderboardremove();
        leaderboard.leaderboardremove();
        assertEquals(0,leaderboard.getData().size());
    }
    @Test
    public void testLeaderboardRemoveWhenEmpty5() {
        leaderboard = Leaderboard.getLeaderboard();
        leaderboard.leaderboardAdd(new String[]{"1","2"});
        leaderboard.leaderboardAdd(new String[]{"2","3"});
        leaderboard.leaderboardAdd(new String[]{"3","2"});
        leaderboard.leaderboardAdd(new String[]{"4","3"});
        leaderboard.leaderboardAdd(new String[]{"5","4"});
        leaderboard.leaderboardremove();
        leaderboard.leaderboardremove();
        leaderboard.leaderboardremove();
        leaderboard.leaderboardremove();
        leaderboard.leaderboardremove();
        assertEquals(0,leaderboard.getData().size());
    }
    @Test
    public void testLeaderboardRemove() {
        leaderboard = Leaderboard.getLeaderboard();
        leaderboard.leaderboardAdd(new String[]{"1","2"});
        leaderboard.leaderboardAdd(new String[]{"2","3"});
        leaderboard.leaderboardAdd(new String[]{"3","2"});
        leaderboard.leaderboardAdd(new String[]{"4","3"});
        leaderboard.leaderboardAdd(new String[]{"5","4"});
        leaderboard.leaderboardremove();
        leaderboard.leaderboardremove();
        leaderboard.leaderboardremove();
        leaderboard.leaderboardremove();
        assertEquals("2",leaderboard.getData().get(0)[1]);
    }
    @Test
    public void testSortLeaderboard() {
        leaderboard = Leaderboard.getLeaderboard();
        leaderboard.leaderboardAdd(new String[]{"5","6"});
        leaderboard.leaderboardAdd(new String[]{"3","4"});
        leaderboard.leaderboardAdd(new String[]{"1","2"});
        leaderboard.sort();
        ArrayList<String[]> expected = new ArrayList<>();
        expected.add(new String[]{"5","6"});
        expected.add(new String[]{"3","4"});
        expected.add(new String[]{"1","2"});
        for (int i = 0; i < leaderboard.getData().size(); i++) {
            assertEquals(leaderboard.getData().get(i)[0], expected.get(i)[0]);
            assertEquals(leaderboard.getData().get(i)[1], expected.get(i)[1]);
        }
    }
    @Test
    public void testEmptyLeaderboard() {
        leaderboard = Leaderboard.getLeaderboard();
        leaderboard.leaderboardAdd(new String[]{"5","6"});
        leaderboard.leaderboardAdd(new String[]{"3","4"});
        leaderboard.leaderboardAdd(new String[]{"1","2"});
        leaderboard.clear();
        assertEquals(0,leaderboard.getData().size());
    }
}

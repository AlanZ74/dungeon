package com.example.dungeoncrawlercs2340team16;
import java.util.*;

public class Leaderboard {
    private ArrayList<String[]> data;
    private static Leaderboard leaderboard;

    private Leaderboard() {
        data = new ArrayList<String[]>();
    }

    public static Leaderboard getLeaderboard() {
        if (leaderboard == null) {
            leaderboard = new Leaderboard();
        }
        return leaderboard;
    }
    public void leaderboardAdd(String[] score) {
        data.add(score);
    }

    public ArrayList<String[]> getData() {
        return data;
    }

    public void leaderboardremove() {
        if (data.size() > 0 || data == null) {
            data.remove(data.size() - 1);
        }
    }

    public void sort() {
        Collections.sort(data, (a, b) -> {
            return Integer.parseInt(b[0]) - Integer.parseInt(a[0]);
        });
    }

    public void clear() {
        data.clear();
    }

}

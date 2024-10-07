package com.example.dungeoncrawlercs2340team16;

public class Score {
    private int score;
    private String characterName;

    public Score(int score, String characterName) {
        this.score = score;
        this.characterName = characterName;
    }
    public Score(int score) {
        this.score = score;
    }

    public Score() {
        this(0, null);
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    public String getCharacterName() {
        return characterName;
    }
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
}

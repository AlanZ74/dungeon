package com.example.dungeoncrawlercs2340team16;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.*;

public class EndingScreen extends AppCompatActivity {
    private TextView recentScore;
    private TextView recentName;
    private TextView recentscoredt;

    private TextView resultOfGame;


    private TextView top1Score;
    private TextView top2Score;
    private TextView top3Score;
    private TextView top4Score;
    private TextView top5Score;
    private TextView top1Name;
    private TextView top2Name;
    private TextView top3Name;
    private TextView top4Name;
    private TextView top5Name;

    private TextView top1DateTime;
    private TextView top2DateTime;
    private TextView top3DateTime;
    private TextView top4DateTime;
    private TextView top5DateTime;

    private ArrayList<Integer> scores = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ending_screen);

        Button restartButton = findViewById(R.id.restartButton);
        Leaderboard myLeaderboard = Leaderboard.getLeaderboard();

        Intent intent = getIntent();
        String score = intent.getStringExtra("score");
        String playerName = intent.getStringExtra("player");
        String currDate = intent.getStringExtra("curr_date");
        String currTime = intent.getStringExtra("curr_time");
        //get Data from singleton Leaderboard
        String[] myData = new String[]{score, playerName, currDate, currTime};
        myLeaderboard.leaderboardAdd(myData);
        ArrayList<String[]> data = myLeaderboard.getData();
        recentScore = findViewById(R.id.recentScore);
        recentScore.setText(score);
        recentName = findViewById(R.id.recentName);
        recentName.setText(playerName);
        recentscoredt = findViewById(R.id.recent);
        recentscoredt.setText(currDate + " " + currTime);

        resultOfGame = findViewById(R.id.result_of_game);
        String resultText = (Integer.valueOf(score) <= 0) ? "You Lose :(" : "You Win!";
        resultOfGame.setText(resultText);

        // get all textviews
        top1Score = findViewById(R.id.top1);
        top2Score = findViewById(R.id.top2);
        top3Score = findViewById(R.id.top3);
        top4Score = findViewById(R.id.top4);
        top5Score = findViewById(R.id.top5);

        top1Name = findViewById(R.id.top1name);
        top2Name = findViewById(R.id.top2name);
        top3Name = findViewById(R.id.top3name);
        top4Name = findViewById(R.id.top4name);
        top5Name = findViewById(R.id.top5name);

        top1DateTime = findViewById(R.id.top1dt);
        top2DateTime = findViewById(R.id.top2dt);
        top3DateTime = findViewById(R.id.top3dt);
        top4DateTime = findViewById(R.id.top4dt);
        top5DateTime = findViewById(R.id.top5dt);

        myLeaderboard.sort();



        System.out.println("Score Size: " + scores.size());

        if (data.size() > 5) {
            myLeaderboard.leaderboardremove();
        }

        // display results (CAREFUL OF CASE: SCORES.SIZE() < 5
        if (data.size() >= 1) {
            top1Score.setText(data.get(0)[0]);
            top1Name.setText(data.get(0)[1]);
            top1DateTime.setText(data.get(0)[2] + " " + data.get(0)[3]);

        }
        if (data.size() >= 2) {
            top2Score.setText(data.get(1)[0]);
            top2Name.setText(data.get(1)[1]);
            top2DateTime.setText(data.get(1)[2] + " " + data.get(1)[3]);
        }
        if (data.size() >= 3) {
            top3Score.setText(data.get(2)[0]);
            top3Name.setText(data.get(2)[1]);
            top3DateTime.setText(data.get(1)[2] + " " + data.get(1)[3]);
        }
        if (data.size() >= 4) {
            top4Score.setText(data.get(3)[0]);
            top4Name.setText(data.get(3)[1]);
            top4DateTime.setText(data.get(1)[2] + " " + data.get(1)[3]);
        }
        if (data.size() >= 5) {
            top5Score.setText(data.get(4)[0]);
            top5Name.setText(data.get(4)[1]);
            top5DateTime.setText(data.get(1)[2] + " " + data.get(1)[3]);
        }

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EndingScreen.this, MainActivity.class));
                finish();
            }
        });
    }
}

package com.example.dungeoncrawlercs2340team16;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GameScreen extends AppCompatActivity {
    private TextView playerNameTextView;
    private ImageView characterSpriteImageView;
    private TextView healthPointsTextView;
    private Button nextButton;
    private TextView scoreTextView;
    private int currentScore = 100;
    private Handler scoreHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        playerNameTextView = findViewById(R.id.playerNameTextView);
        characterSpriteImageView = findViewById(R.id.characterSpriteImageView);
        healthPointsTextView = findViewById(R.id.healthPointsTextView);
        nextButton = findViewById(R.id.nextButton);


        // Retrieve data passed from ConfigScreen
        String playerName = getIntent().getStringExtra("PLAYER_NAME");
        String chosenCharacter = getIntent().getStringExtra("CHOSEN_CHARACTER");
        String difficulty = getIntent().getStringExtra("DIFFICULTY");

        Log.d(chosenCharacter, difficulty);
        // Set player name
        playerNameTextView.setText("Player: " + playerName);

        // Set character sprite
        int characterSpriteResId = getCharacterSpriteResId(chosenCharacter);
        characterSpriteImageView.setImageResource(characterSpriteResId);

        // Set health points based on difficulty
        int healthPoints = getHealthPointsBasedOnDifficulty(difficulty);
        healthPointsTextView.setText("Health Points: " + healthPoints + " (" + difficulty + ")");
        scoreTextView = findViewById(R.id.scoreTextView);
        scoreTextView.setText("Score: " + currentScore);
        startDecreasingScore();
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the ending screen
                // For now, we'll just finish the current activity
                Intent intent = new Intent(GameScreen.this, EndingScreen.class);
                intent.putExtra("score", Integer.toString(currentScore));
                intent.putExtra("player", playerName);
                String currentDate = new SimpleDateFormat("dd-MM-yyyy",
                        Locale.getDefault()).format(new Date());
                String currentTime = new SimpleDateFormat("HH:mm:ss",
                        Locale.getDefault()).format(new Date());
                intent.putExtra("curr_date", currentDate);
                intent.putExtra("curr_time", currentTime);
                startActivity(intent);
                // startActivity(new Intent(GameScreen.this, EndingScreen.class));
            }
        });
    }

    private int getCharacterSpriteResId(String chosenCharacter) {
        if (chosenCharacter == "Pikachu") {
            return R.drawable.pika;
        } else if (chosenCharacter == "Link") {
            return R.drawable.link;
        } else { // Ike
            return R.drawable.ike;
        }
    }

    private int getHealthPointsBasedOnDifficulty(String difficulty) {
        if (difficulty == "EASY") {
            return 150;
        } else if (difficulty == "MED") {
            return 100;
        } else { // Hard
            return 50;
        }
    }

    private void startDecreasingScore() {
        scoreHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentScore > 0) {
                    currentScore -= 5;
                    scoreTextView.setText("Score: " + currentScore);
                    startDecreasingScore();
                }
            }
        }, 1000);
    }
}
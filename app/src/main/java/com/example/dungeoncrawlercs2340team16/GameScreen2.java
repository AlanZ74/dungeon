package com.example.dungeoncrawlercs2340team16;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class GameScreen2 extends AppCompatActivity {
    private TextView playerNameTextView;
    private TextView scoreTextView;
    private TextView healthPointsTextView;
    private ImageView characterSpriteImageView;
    private ImageView goalBlockImageView;
    private ImageView timePowerUpImageView;
    private ImageView swordImageView; // Added ImageView for the sword
    private boolean notCollided = true;
    private boolean detectedCollide = false;
    private Button nextButton;
    private String playerName;
    private int score;
    private int screenHeight;
    private int screenWidth;
    private CharInfo player;
    private PowerUpInfo powerUp;
    private int goalX;
    private int goalY;
    private int goalWidth;
    private int goalHeight;

    private RelativeLayout gameLayout;
    private EnemyFactory enemyFactory;
    private List<ImageView> enemySprites = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();
    private final Random random = new Random();
    private Handler enemyMoveHandler = new Handler();
    private Runnable enemyMoveRunnable;
    private static final int MOVE_AMOUNT = 50;
    private static final int ENEMY_MOVE_DELAY = 350; // delay in milliseconds between enemy moves
    private Handler scoreHandler = new Handler();
    private static int playerHealth = 0;
    private static int enemyDamage = 0;
    private Player p = Player.getPlayer("placeholder", "placeholder_char");
    private Sword playerSword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen2);

        // Initialize enemyFactory and sword
        enemyFactory = new EnemyFactory();
        playerSword = new Sword(this); // Assuming Sword constructor takes context and two ints

        // Initialize views and game setup
        initializeViews();
        setupGame();

        // Make the sword invisible initially
        swordImageView.setVisibility(View.INVISIBLE);

        player = new CharInfo(characterSpriteImageView, 0, 0);
        powerUp = new PowerUpInfo(timePowerUpImageView, 0, 0);

    }
    private void initializeViews() {
        playerNameTextView = findViewById(R.id.playerNameTextView);
        characterSpriteImageView = findViewById(R.id.characterSpriteImageView);
        healthPointsTextView = findViewById(R.id.healthPointsTextView);
        goalBlockImageView = findViewById(R.id.goalBlock2);
        scoreTextView = findViewById(R.id.scoreTextView);
        timePowerUpImageView = findViewById(R.id.timefreezePowerUp);
        swordImageView = findViewById(R.id.sword); // Make sure this ID matches your layout
        gameLayout = findViewById(R.id.gameLayout);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenHeight = displayMetrics.heightPixels;
        screenWidth = displayMetrics.widthPixels;

        enemies = new ArrayList<>();
    }

    private void setupGame() {
        String playerName = getIntent().getStringExtra("PLAYER_NAME");
        String chosenCharacter = getIntent().getStringExtra("CHOSEN_CHARACTER");
        String difficulty = getIntent().getStringExtra("DIFFICULTY");
        score = getIntent().getIntExtra("SCORE", 1000);

        playerNameTextView.setText("Player: " + playerName);
        characterSpriteImageView.setImageResource(getCharacterSpriteResId(chosenCharacter));
        healthPointsTextView.setText("Health Points: "
                + getHealthPointsBasedOnDifficulty(difficulty) + " (" + difficulty + ")");
        playerHealth = getHealthPointsBasedOnDifficulty(difficulty);
        scoreTextView.setText("Score: " + score);
        enemyDamage = getEnemyDamage(difficulty);

        createAndDistributeEnemies();
        createAndDistributeEnemies();
        startMovingEnemies();
        startDecreasingScore();
    }

    private void createAndDistributeEnemies() {
        int enemyCount = 2;
        for (int i = 0; i < enemyCount; i++) {
            EnemyType type = i % 2 == 0 ? EnemyType.TYPE2 : EnemyType.TYPE3;

            Enemy enemy = enemyFactory.createEnemy(type, gameLayout, screenWidth, screenHeight);
            ImageView enemySprite = enemy.getSprite();

            // Calculate a position for each enemy to avoid overlap
            int xPosition = (screenWidth / (enemyCount + 1)) * (i + 1);
            int yPosition = screenHeight / 4; // Adjust this as needed

            enemySprite.setX(xPosition);
            enemySprite.setY(yPosition);

            gameLayout.addView(enemySprite);
            enemySprites.add(enemySprite);
            enemies.add(enemy);
        }
    }

    private void startMovingEnemies() {
        enemyMoveRunnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView enemySprite : enemySprites) {
                    moveEnemyRandomly(enemySprite);
                }
                enemyMoveHandler.postDelayed(this, ENEMY_MOVE_DELAY);
            }
        };
        enemyMoveHandler.post(enemyMoveRunnable);
    }

    private void moveEnemyRandomly(ImageView enemySprite) {
        int xMove = random.nextInt(MOVE_AMOUNT * 2 + 1) - MOVE_AMOUNT;
        // range -MOVE_AMOUNT to MOVE_AMOUNT
        int yMove = random.nextInt(MOVE_AMOUNT * 2 + 1) - MOVE_AMOUNT;
        // range -MOVE_AMOUNT to MOVE_AMOUNT

        // Ensure new position is within bounds
        int newX = (int) Math.max(0, Math.min(screenWidth - enemySprite.getWidth(),
                enemySprite.getX() + xMove));
        int newY = (int) Math.max(0, Math.min(screenHeight - enemySprite.getHeight(),
                enemySprite.getY() + yMove));

        enemySprite.setX(newX);
        enemySprite.setY(newY);
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            goalWidth = goalBlockImageView.getWidth();
            goalHeight = goalBlockImageView.getHeight();
            goalX = (int) goalBlockImageView.getX();
            goalY = (int) goalBlockImageView.getY();

            // Update player and powerUp dimensions
            updateCharacterAndPowerUpDimensions();
        }
    }

    private void updateCharacterAndPowerUpDimensions() {
        if (player != null && player.getIv() != null) {
            player.setWidth(player.getIv().getWidth());
            player.setHeight(player.getIv().getHeight());
        }
        if (powerUp != null && powerUp.getIv() != null) {
            powerUp.setWidth(powerUp.getIv().getWidth());
            powerUp.setHeight(powerUp.getIv().getHeight());
        }
    }

    public void checkEnemyCollide() {
        int xPos = (int) characterSpriteImageView.getX();
        int yPos = (int) characterSpriteImageView.getY();
        String difficulty = getIntent().getStringExtra("DIFFICULTY");
        for (int enemy = 0; enemy < enemySprites.size(); enemy++) {
            for (int playerRow = 0; playerRow < player.getWidth(); playerRow++) {
                for (int playerCol = 0; playerCol < player.getHeight(); playerCol++) {
                    if ((xPos + playerRow >= enemySprites.get(enemy).getX() && xPos
                            + playerRow <= enemySprites.get(enemy).getX()
                            + enemySprites.get(enemy).getWidth())
                            && (yPos + playerCol >= enemySprites.get(enemy).getY()
                            && yPos + playerCol <= enemySprites.get(enemy).getY()
                            + enemySprites.get(enemy).getHeight())) {
                        if (playerHealth >= 0) {
                            playerHealth = playerHealth - enemyDamage;
                            healthPointsTextView.setText("Health Points: "
                                    + (playerHealth) + " (" + difficulty + ")");
                        }
                        return;
                    }
                }
            }
        }
    }

    public boolean checkGoalCollide() {
        // We already have all of the player data, so we can just check based on that!
        int xPos = (int) characterSpriteImageView.getX();
        int yPos = (int) characterSpriteImageView.getY();
        for (int i = 0; i < player.getWidth(); i++) {
            for (int j = 0; j < player.getHeight(); j++) {
                if ((xPos + i >= goalX && xPos + i <= goalX + goalWidth)
                        && (yPos + j >= goalY && yPos + j <= goalY + goalHeight)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int margin = 5;
        float xPos = characterSpriteImageView.getX();
        float yPos = characterSpriteImageView.getY();

        checkEnemyCollide();
        notCollided = p.checkPowerUpCollide(notCollided, player, powerUp);

        if (!notCollided) {
            timePowerUpImageView.setVisibility(View.GONE);
        }



        if (checkGoalCollide() && !detectedCollide) {
            detectedCollide = true;
            String playerName = getIntent().getStringExtra("PLAYER_NAME");
            String chosenCharacter = getIntent().getStringExtra("CHOSEN_CHARACTER");
            String difficulty = getIntent().getStringExtra("DIFFICULTY");
            Intent intent = new Intent(GameScreen2.this, GameScreen3.class);
            intent.putExtra("PLAYER_NAME", playerName);
            intent.putExtra("CHOSEN_CHARACTER", chosenCharacter);
            intent.putExtra("DIFFICULTY", difficulty);
            intent.putExtra("SCORE", score);
            scoreHandler.removeCallbacksAndMessages(null);
            scoreHandler = null;
            startActivity(intent);
            finish();
        }

        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
            if (xPos >= margin) {
                characterSpriteImageView.setX(xPos - MOVE_AMOUNT);
                updateSwordPosition();
            }
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            if (xPos + MOVE_AMOUNT + player.getWidth() < screenWidth - margin) {
                characterSpriteImageView.setX(xPos + MOVE_AMOUNT);
                updateSwordPosition();

            }
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
            if (yPos >= margin) {
                characterSpriteImageView.setY(yPos - MOVE_AMOUNT);
                updateSwordPosition();

            }
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
            if (yPos + MOVE_AMOUNT + player.getHeight() < screenHeight - margin) {
                characterSpriteImageView.setY(yPos + MOVE_AMOUNT);
                updateSwordPosition();

            }
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_SPACE) {
            performSwordAttack();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    private void updateSwordPosition() {
        float characterX = characterSpriteImageView.getX();
        float characterY = characterSpriteImageView.getY();
        float swordX = characterX + characterSpriteImageView.getWidth();
        float swordY = characterY;

        swordImageView.setX(swordX);
        swordImageView.setY(swordY);
    }

    private void performSwordAttack() {
        // Logic for sword attack
        swordImageView.setVisibility(View.VISIBLE);
        playerSword.attack(p, enemies, swordImageView);
        new Handler().postDelayed(() -> {
            swordImageView.setVisibility(View.INVISIBLE);
            removeDefeatedEnemies();
        }, 500); // Delay to simulate sword swing
        updateSwordPosition();

    }



    private void removeDefeatedEnemies() {
        for (int i = enemies.size() - 1; i >= 0; i--) {
            Enemy enemy = enemies.get(i);
            if (enemy.getHealth() <= 1000) {
                Log.d("RemoveEnemy", "Removing Enemy Type: " + enemy.getType());
                // Remove enemy sprite from the layout
                gameLayout.removeView(enemy.getSprite());
                // Remove enemy from the list
                enemies.remove(i);
            }
        }
    }

    private int getCharacterSpriteResId(String chosenCharacter) {
        if ("Pikachu".equals(chosenCharacter)) {
            return R.drawable.pika;
        } else if ("Link".equals(chosenCharacter)) {
            return R.drawable.link;
        } else if ("Ike".equals(chosenCharacter)) {
            return R.drawable.ike;
        } else {
            return R.drawable.ike;
        }
    }

    private int getHealthPointsBasedOnDifficulty(String difficulty) {
        if ("EASY".equals(difficulty)) {
            return 150;
        } else if ("MED".equals(difficulty)) {
            return 100;
        } else { // Hard
            return 50;
        }
    }

    private int getEnemyDamage(String difficulty) {
        if ("EASY".equals(difficulty)) {
            return 2;
        } else if ("MED".equals(difficulty)) {
            return 4;
        } else { // Hard
            return 8;
        }
    }


    private void startDecreasingScore() {
        scoreHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (score > 0) {
                    score -= 5;
                    if (playerHealth > 60) {
                        score += 10;
                    }
                    if (enemyDamage != 0) {
                        score -= 4;
                    }
                    scoreTextView.setText("Score: " + score);
                    startDecreasingScore();
                } else {
                    Intent intent = new Intent(GameScreen2.this, EndingScreen.class);
                    intent.putExtra("score", Integer.toString(score));
                    playerName = getIntent().getStringExtra("PLAYER_NAME");
                    intent.putExtra("player", playerName);
                    String currentDate = new SimpleDateFormat("dd-MM-yyyy",
                            Locale.getDefault()).format(new Date());
                    String currentTime = new SimpleDateFormat("HH:mm:ss",
                            Locale.getDefault()).format(new Date());
                    intent.putExtra("curr_date", currentDate);
                    intent.putExtra("curr_time", currentTime);
                    startActivity(intent);
                    finish();
                }
            }
        }, 1000);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (enemyMoveHandler != null) {
            enemyMoveHandler.removeCallbacks(enemyMoveRunnable);
        }
        if (scoreHandler != null) {
            scoreHandler.removeCallbacksAndMessages(null);
        }
    }
}

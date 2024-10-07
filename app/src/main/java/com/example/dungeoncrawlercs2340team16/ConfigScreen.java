package com.example.dungeoncrawlercs2340team16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class ConfigScreen extends AppCompatActivity {

    private EditText charEditText;
    private Player p = Player.getPlayer("placeholder", "placeholder_char");

    /**
     * This function checks if string inputs and radioButton selections
     * are correct before changing the button's state
     * @param s the string to check the validity of
     * @param b the button we are checking cases for
     * @param rg1 the first radio group we are checking selections for
     * @param rg2 the second radio group we are checking selections for
     */
    private void buttonUpdate(String s, Button b, RadioGroup rg1, RadioGroup rg2) {
        if (!p.checkNameValidity(s)
            || rg1.getCheckedRadioButtonId() == -1
            || rg2.getCheckedRadioButtonId() == -1) {
            b.setEnabled(false);
        } else {
            b.setEnabled(true);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_screen);

        charEditText = findViewById(R.id.charName);

        Button continueButton = findViewById(R.id.continueButton);
        continueButton.setEnabled(false); // disable the button by default

        RadioGroup difficultySelect = findViewById(R.id.difficulty_group);
        RadioGroup characterSelect = findViewById(R.id.character_group);

        // Listener for the changing of the text
        charEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                buttonUpdate(charSequence.toString(),
                        continueButton, difficultySelect, characterSelect);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                buttonUpdate(editable.toString(),
                        continueButton, difficultySelect, characterSelect);
            }
        });
        // Listener for the changing of the difficulty selection radio group
        difficultySelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                buttonUpdate(charEditText.toString(),
                        continueButton, difficultySelect, characterSelect);
            }
        });
        // Listener for the changing of the character selection radio group
        characterSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                buttonUpdate(charEditText.toString(),
                        continueButton, difficultySelect, characterSelect);
            }
        });
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Gather selected character and difficulty settings
                String selectedCharacter = "";
                int characterId = characterSelect.getCheckedRadioButtonId();
                if (characterId == R.id.pikachu_select) {
                    selectedCharacter = "Pikachu";
                } else if (characterId == R.id.link_select) {
                    selectedCharacter = "Link";
                } else if (characterId == R.id.ike_select) {
                    selectedCharacter = "Ike";
                }

                String selectedDifficulty = "";
                int difficultyId = difficultySelect.getCheckedRadioButtonId();
                if (difficultyId == R.id.easy) {
                    selectedDifficulty = "EASY";
                } else if (difficultyId == R.id.medium) {
                    selectedDifficulty = "MED";
                } else if (difficultyId == R.id.hard) {
                    selectedDifficulty = "HARD";
                }

                // Pass the data to GameScreenActivity using Intent
                Intent intent = new Intent(ConfigScreen.this, GameScreen1.class);
                intent.putExtra("PLAYER_NAME", charEditText.getText().toString());
                intent.putExtra("CHOSEN_CHARACTER", selectedCharacter);
                intent.putExtra("DIFFICULTY", selectedDifficulty);
                Log.d(selectedCharacter, selectedDifficulty);
                startActivity(intent);
                finish();
            }
        });
    }
}
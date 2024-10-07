package com.example.dungeoncrawlercs2340team16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button closeApplication;
    private Button startApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startApplication = findViewById(R.id.startGame);

        closeApplication = findViewById(R.id.idBtnCloseApplication);
        closeApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
                finish();
                System.exit(0);
            }
        });

        startApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ConfigScreen.class));
                finish();
            }
        });
    }
}
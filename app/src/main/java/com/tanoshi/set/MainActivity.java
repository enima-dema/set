package com.tanoshi.set;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tanoshi.set.client.Game;
import com.tanoshi.set.client.GameMin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newGame = (Button) findViewById(R.id.newgame);
        Button newGameMin = (Button) findViewById(R.id.newgamemin);

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Game.class);
                startActivity(i);
            }
        });

        newGameMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GameMin.class);
                startActivity(i);
            }
        });
    }
}

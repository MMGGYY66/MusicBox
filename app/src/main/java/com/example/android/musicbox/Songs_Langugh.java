package com.example.android.musicbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Songs_Langugh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs__langugh);
        // Set a click listener on that View
        Button arabicSongs = (Button) findViewById(R.id.arabic_songs);
        arabicSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arbSongs = new Intent(Songs_Langugh.this, Arabic_Songs.class);
                startActivity(arbSongs);
            }
        });
        // Set a click listener on that View
        Button englishSongs = (Button) findViewById(R.id.english_songs);
        englishSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent engSongs = new Intent(Songs_Langugh.this, English_Songs.class);
                startActivity(engSongs);
            }
        });

    }
}

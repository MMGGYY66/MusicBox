package com.example.android.musicbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set a click listener on that View
        ImageButton welcome = (ImageButton) findViewById(R.id.letsstart);
        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcomPage = new Intent(MainActivity.this, Songs_Langugh.class);
                startActivity(welcomPage);
            }
        });
    }
}

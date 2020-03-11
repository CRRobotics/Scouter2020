package com.example.bigscouting2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class LoadingScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        Intent i = getIntent();
        int match = i.getIntExtra(AllianceSelectionActivity.MatchNumber, -1);
        String level = i.getStringExtra(AllianceSelectionActivity.Level);
        String alliance = i.getStringExtra(AllianceSelectionActivity.Alliance);

        TextView matchNumber = findViewById(R.id.matchNumber);
        matchNumber.setText(String.format(Locale.getDefault(),"%d", match));
        TextView teamNumber = findViewById(R.id.teamNumber);


    }
}

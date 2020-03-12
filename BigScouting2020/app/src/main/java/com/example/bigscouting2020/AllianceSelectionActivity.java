package com.example.bigscouting2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AllianceSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alliance_selection);

        ArrayList<Button> buttons= new ArrayList<>();
        buttons.add((Button) findViewById(R.id.button2));
        buttons.add((Button) findViewById(R.id.button3));
        buttons.add((Button) findViewById(R.id.button4));
        buttons.add((Button) findViewById(R.id.button5));
        buttons.add((Button) findViewById(R.id.button6));
        buttons.add((Button) findViewById(R.id.button7));

        for (View b : buttons)
        {
            b.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    startLoadingScreen(v);
                }
            });
        }
    }

    public void startLoadingScreen(View v)
    {
        Intent intent = new Intent(this, LoadingScreenActivity.class);
        String[] type = ((Button) v).getText().toString().split(" ");
        String level = type[0];
        String alliance = type[1];
        System.out.println(level + ":::" + alliance);

        EditText et = findViewById(R.id.matchNumber);
        String s = et.getText().toString();
        if (s.length() == 0)
            return;
        int matchNumber = Integer.parseInt(s);
        if (matchNumber < 0 || matchNumber > 150)
            return;

        intent.putExtra(Constants.Level, level);
        intent.putExtra(Constants.Alliance, alliance);
        intent.putExtra(Constants.MatchNumber, matchNumber);
        startActivity(intent);
    }
}

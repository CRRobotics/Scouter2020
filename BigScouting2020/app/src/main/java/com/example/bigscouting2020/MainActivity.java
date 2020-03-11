package com.example.bigscouting2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.scoutButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onScoutPressed(v);
            }
        });
        this.findViewById(R.id.syncButton);
    }

    public void onScoutPressed(View v)
    {
        Intent intent = new Intent(this, AllianceSelectionActivity.class);
        startActivity(intent);
    }

    public void onSyncPressed(View v)
    {

    }
}

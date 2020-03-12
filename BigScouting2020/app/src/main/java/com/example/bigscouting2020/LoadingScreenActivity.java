package com.example.bigscouting2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.logging.Level;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoadingScreenActivity extends AppCompatActivity {

    public String regionalData;
    public JSONObject j;
    public int teamNumber;
    public int matchNumber;
    public String level;
    public String alliance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        regionalData = loadJSONFromAsset();
        regionalData = "{\"Data\":" + regionalData + "}";
        try {
            j = new JSONObject(regionalData);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Intent i = getIntent();
        this.matchNumber = i.getIntExtra(Constants.MatchNumber, -1);
        level = i.getStringExtra(Constants.Level);
        alliance = i.getStringExtra(Constants.Alliance);
        teamNumber = getTeamNumber(this.matchNumber, level, alliance);

        TextView matchNumberView = findViewById(R.id.matchNumber);
        matchNumberView.setText(String.format(Locale.getDefault(),"%d", this.matchNumber));

        TextView teamNumberView = findViewById(R.id.teamNumber);
        teamNumberView.setText(Integer.toString(teamNumber));
        TextView scoutingCategory = findViewById(R.id.scoutingCategory);
        scoutingCategory.setText(level + " " + alliance);

        findViewById(R.id.startScoutingButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startScouter(v);
            }
        });
    }

    public void startScouter(View v)
    {
        if (teamNumber < 0)
            return;
        if (matchNumber < 0)
            return;

        Intent intent = new Intent(this, ScouterActivity.class);
        intent.putExtra(Constants.Level, level);
        intent.putExtra(Constants.MatchNumber, matchNumber);
        intent.putExtra(Constants.TeamNumber, teamNumber);
        intent.putExtra(Constants.Alliance, alliance);

        startActivity(intent);
    }

    public int getTeamNumber(int matchNumber, String level, String alliance)
    {
        try {
            JSONArray arr = j.getJSONArray("Data");
            for (int i = 0; i < arr.length(); i++)
            {
                JSONObject c = arr.getJSONObject(i);
                if (matchNumber != c.getInt("match_number"))
                    continue;

                int[] teamNums;
                if (alliance.equals("Blue"))
                {
                    JSONArray blue = c.getJSONObject("alliances").getJSONObject("blue").getJSONArray("team_keys");
                    String[] t = new String[] {blue.getString(0).substring(3), blue.getString(1).substring(3), blue.getString(2).substring(3)};
                    teamNums = new int[] {Integer.parseInt(t[0]), Integer.parseInt(t[1]), Integer.parseInt(t[2])};
                    Arrays.sort(teamNums);
                }

                else if (alliance.equals("Red"))
                {
                    JSONArray red = c.getJSONObject("alliances").getJSONObject("red").getJSONArray("team_keys");
                    String[] t = new String[] {red.getString(0).substring(3), red.getString(1).substring(3), red.getString(2).substring(3)};
                    teamNums = new int[] {Integer.parseInt(t[0]), Integer.parseInt(t[1]), Integer.parseInt(t[2])};
                    Arrays.sort(teamNums);
                }
                else
                {
                    return 0;
                }

                switch (level)
                {
                    case "Low":
                        return teamNums[0];
                    case "Mid":
                        return teamNums[1];
                    case "High":
                        return teamNums[2];
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("regional.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

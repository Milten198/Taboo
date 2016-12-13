package com.projectgroup.taboo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class StartGameActivity extends AppCompatActivity {

    ArrayList<String> names_redTeam;
    ArrayList<String> names_blueTeam;
    private int teamBluePoints = 0;
    private int teamRedPoints = 0;
    TextView scoresRedTeam;
    TextView scoresBlueTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        TextView textOut = (TextView) findViewById(R.id.textout2);
        names_redTeam = (ArrayList<String>) getIntent().getSerializableExtra("names_redTeam");
        names_blueTeam = (ArrayList<String>) getIntent().getSerializableExtra("names_blueTeam");

        scoresRedTeam = (TextView) findViewById(R.id.score_red_team);
        scoresBlueTeam = (TextView) findViewById(R.id.score_blue_team);

        textOut.setText("Czerwoni: " + names_redTeam + " ;;;;;; " + ", Niebiescy: " + names_blueTeam);



        setTeamPoints();
    }

    private void setTeamPoints() {
        scoresBlueTeam.setText(teamBluePoints +"");
        scoresRedTeam.setText(teamRedPoints);
    }


}

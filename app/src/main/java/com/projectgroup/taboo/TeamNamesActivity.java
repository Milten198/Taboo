package com.projectgroup.taboo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomasz.kubit on 2016-10-04.
 */

public class TeamNamesActivity extends Activity {

    Button button_more_players;
    EditText namesBlueTeam;
    Button addPlayersBlueTeam;
    LinearLayout containerBlueTeam;
    EditText namesRedTeam;
    Button addPlayersRedTeam;
    LinearLayout containerRedTeam;
    int shortestNameLength = 3;
    ArrayList<String> names_blueTeam = new ArrayList<>();
    ArrayList<String> names_redTeam = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_names);
        namesBlueTeam = (EditText)findViewById(R.id.first_player_blue);
        namesRedTeam = (EditText)findViewById(R.id.first_player_red);
        addPlayersBlueTeam = (Button)findViewById(R.id.more_players_blue_team);
        addPlayersRedTeam = (Button)findViewById(R.id.more_players_red_team);
        containerBlueTeam = (LinearLayout)findViewById(R.id.container_blue);
        containerRedTeam = (LinearLayout)findViewById(R.id.container_red);
    }

    public void addMorePlayers_blueTeam(View view) {
        button_more_players = (Button) findViewById(R.id.more_players_blue_team);
        addPlayers(namesBlueTeam, containerBlueTeam, view);
    }

    public void addMorePlayers_redTeam(View view) {
        button_more_players = (Button) findViewById(R.id.more_players_red_team);
        addPlayers(namesRedTeam, containerRedTeam, view);
    }

    public void addPlayers(EditText team, LinearLayout container, View view) {
        final View addView;
        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(team.getText().length() >= shortestNameLength) {

            addView = layoutInflater.inflate(R.layout.activity_to_add_more_players, null);
            TextView textOut = (TextView)addView.findViewById(R.id.textout);
            textOut.setText(team.getText().toString());

            if(team.equals(namesRedTeam)) {
                names_redTeam.add(team.getText().toString());
            } else if(team.equals(namesBlueTeam)) {
                names_blueTeam.add(team.getText().toString());
            } else {
                throw new IllegalArgumentException("There's no EditText with that id");
            }

            team.setText("");
            Button buttonRemove = (Button)addView.findViewById(R.id.remove);
            buttonRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((LinearLayout)addView.getParent()).removeView(addView);
                }
            });
            container.addView(addView);

        }
    }

    public void goFurther(View view) {

        Intent teamNamesIntent = new Intent(this, StartGameActivity.class);
        teamNamesIntent.putExtra("names_redTeam", names_redTeam);
        teamNamesIntent.putExtra("names_blueTeam", names_blueTeam);
        startActivity(teamNamesIntent);

    }

    public void goFurtherWithoutNames(View view) {
    }

    public List<String> getNames_redTeam() {
        return names_redTeam;
    }

    public List<String> getNames_blueTeam() {
        return names_blueTeam;
    }
}
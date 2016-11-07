package com.projectgroup.taboo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
        config();
    }

    public void config() {
        namesBlueTeam = (EditText) findViewById(R.id.first_player_blue);
        namesRedTeam = (EditText) findViewById(R.id.first_player_red);
        addPlayersBlueTeam = (Button) findViewById(R.id.more_players_blue_team);
        addPlayersRedTeam = (Button) findViewById(R.id.more_players_red_team);
        containerBlueTeam = (LinearLayout) findViewById(R.id.container_blue);
        containerRedTeam = (LinearLayout) findViewById(R.id.container_red);
    }

    public void addMorePlayers_blueTeam(View view) {
        button_more_players = (Button) findViewById(R.id.more_players_blue_team);
        addPlayers(namesBlueTeam, containerBlueTeam, names_blueTeam);
    }

    public void addMorePlayers_redTeam(View view) {
        button_more_players = (Button) findViewById(R.id.more_players_red_team);
        addPlayers(namesRedTeam, containerRedTeam, names_redTeam);
    }

    public void addPlayers(EditText nameOfPlayer, LinearLayout container,
                           final List<String> playersNames) {
        if (nameOfPlayer.getText().length() >= shortestNameLength) {
            final String currentName = nameOfPlayer.getText().toString();
            if (playersNames.contains(currentName)) {
                Toast.makeText(this, "To imię już istnieje. Wybierz inne", Toast.LENGTH_SHORT).show();
            } else {
                final View addView;
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                addView = layoutInflater.inflate(R.layout.activity_to_add_more_players,
                        null);
                TextView textOut = (TextView) addView.findViewById(R.id.textout);
                textOut.setText(currentName);
                playersNames.add(currentName);

                nameOfPlayer.setText("");
                Button buttonRemove = (Button) addView.findViewById(R.id.remove);
                buttonRemove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playersNames.remove(currentName);
                        ((LinearLayout) addView.getParent()).removeView(addView);
                    }
                });
                container.addView(addView);
            }

        }
    }

    public void goFurther(View view) {

        Intent teamNamesIntent = new Intent(this, StartGameActivity.class);
        teamNamesIntent.putExtra("names_redTeam", names_redTeam);
        teamNamesIntent.putExtra("names_blueTeam", names_blueTeam);
        startActivity(teamNamesIntent);

    }

    public void goFurtherWithoutNames(View view) {

        Intent teamNamesIntent = new Intent(this, StartGameActivity.class);
        startActivity(teamNamesIntent);
    }
}
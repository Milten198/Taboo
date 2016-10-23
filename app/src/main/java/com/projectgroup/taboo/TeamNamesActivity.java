package com.projectgroup.taboo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by tomasz.kubit on 2016-10-04.
 */

public class TeamNamesActivity extends Activity {

    EditText namesBlueTeam;
    Button addPlayersBlueTeam;
    LinearLayout containerBlueTeam;
    EditText namesRedTeam;
    Button addPlayersRedTeam;
    LinearLayout containerRedTeam;

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
        addPlayers(namesBlueTeam, containerBlueTeam);
    }

    public void addMorePlayers_redTeam(View view) {
        addPlayers(namesRedTeam, containerRedTeam);
    }

    public void addPlayers(EditText team, LinearLayout container) {
        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View addView = layoutInflater.inflate(R.layout.activity_to_add_more_players, null);
        TextView textOut = (TextView)addView.findViewById(R.id.textout);
        textOut.setText(team.getText().toString());
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

    public void clearEditText_redTeam(View view) {
        namesRedTeam.setText("");
    }

    public void clearEditText_blueTeam(View view) {
        namesBlueTeam.setText("");
    }

    public void goFurther(View view) {
    }
}
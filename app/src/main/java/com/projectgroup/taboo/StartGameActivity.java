package com.projectgroup.taboo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class StartGameActivity extends AppCompatActivity {

    TeamNamesActivity teamNamesActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        teamNamesActivity = new TeamNamesActivity();
        TextView textOut = (TextView)findViewById(R.id.textout2);
        Log.d("A", teamNamesActivity.getNames_blueTeam().toString());
        Log.d("B", teamNamesActivity.getNames_redTeam().toString());
        textOut.setText("Asasgasgassssssssssssssssssssssss");
        textOut.setText(teamNamesActivity.getNames_blueTeam().toString() + " ;;;;;; " + teamNamesActivity.getNames_redTeam().toString());
    }
}

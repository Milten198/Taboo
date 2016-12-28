package com.projectgroup.taboo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class BeforeStartActivity extends AppCompatActivity {

    ArrayList<String> names_redTeam;
    ArrayList<String> names_blueTeam;
    Button button$_changePlayer;
    Context context;
    Global global;
    RecyclerView recyclerViewBlue;
    RecyclerView recyclerViewRed;
    RecyclerView.Adapter recyclerViewAdapterBlue;
    RecyclerView.Adapter recyclerViewAdapterRed;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    RecyclerView.LayoutManager recyclerViewLayoutManager2;
    TextView scoresRedTeam;
    TextView scoresBlueTeam;
    TextView view$_pointsToWin;
    TextView next_player;
    TextView redLabel;
    TextView blueLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_before_start);
        context = getApplicationContext();

        init();
        setListsOfPlayers();
        createAdapters();
        setFirstPlayer();
        setPointsLimitToWin();
    }

    private void setListsOfPlayers() {
        names_redTeam = global.getRedTeam();
        names_blueTeam = global.getBlueTeam();
    }

    private void init() {
        global = new Global();
        next_player = (TextView) findViewById(R.id.variable$_nowPlays);
        view$_pointsToWin = (TextView) findViewById(R.id.value$_points_limit_to_win);
        scoresRedTeam = (TextView) findViewById(R.id.score_red_team);
        scoresBlueTeam = (TextView) findViewById(R.id.score_blue_team);
        recyclerViewBlue = (RecyclerView) findViewById(R.id.recycler_blue);
        recyclerViewRed = (RecyclerView) findViewById(R.id.recycler_red);
        recyclerViewLayoutManager = new LinearLayoutManager(context);
        recyclerViewLayoutManager2 = new LinearLayoutManager(context);
        button$_changePlayer = (Button) findViewById(R.id.button$_change_players);
        redLabel = (TextView) findViewById(R.id.BeforeStart_redLabel);
        blueLabel = (TextView) findViewById(R.id.BeforeStart_blueLabel);
    }

    private void createAdapters() {
        recyclerViewBlue.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewRed.setLayoutManager(recyclerViewLayoutManager2);
        recyclerViewAdapterBlue = new RecyclerViewAdapterBlue(context, names_blueTeam);
        recyclerViewAdapterRed = new RecyclerViewAdapterRed(context, names_redTeam);
        recyclerViewBlue.setAdapter(recyclerViewAdapterBlue);
        recyclerViewRed.setAdapter(recyclerViewAdapterRed);
    }

    private void setPointsLimitToWin() {

        String pointsToWin = String.valueOf(global.getPointsToWinGame());
        view$_pointsToWin.setText(pointsToWin);
    }

    private ArrayList<String> drawTeam() {
        int drawTeam = (int)(Math.random()*2);
        ArrayList<String> firstTeam;
        if(drawTeam == 0) {
            firstTeam = names_blueTeam;
            global.setFirstTeam(names_blueTeam);
            global.setSecondTeam(names_redTeam);
        } else if(drawTeam == 1) {
            firstTeam = names_redTeam;
            global.setFirstTeam(names_redTeam);
            global.setSecondTeam(names_blueTeam);
        } else {
            throw new IllegalArgumentException("Incorrect value of drawTeam variable");
        }
        return firstTeam;
    }

    public void changePlayer(View view) {
        global.changePlayer(view);
        global.setFirstPlayer(global.getFirstTeam(), next_player);
    }

    public void changeTeam(View view) {
        global.changeTeam(view);
        global.setFirstPlayer(global.getFirstTeam(), next_player);
    }

    public void setFirstPlayer() {
        if(names_redTeam.size() == 1 && names_blueTeam.size() == 1) {
            button$_changePlayer.setVisibility(View.INVISIBLE);
            redLabel.setVisibility(View.INVISIBLE);
            blueLabel.setVisibility(View.INVISIBLE);
        }
        global.setFirstPlayer(drawTeam(), next_player);
    }

    public void startGame(View view) {
    }
}

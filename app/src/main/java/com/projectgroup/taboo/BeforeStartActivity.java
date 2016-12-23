package com.projectgroup.taboo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;

public class BeforeStartActivity extends AppCompatActivity {

    ArrayList<String> names_redTeam;
    ArrayList<String> names_blueTeam;
    ArrayList<String> teamToStart;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_before_start);
        context = getApplicationContext();

        getListsFromPreviousActivity();
        init();
        createAdapters();
        setFirstPlayer();
        setPointsLimitToWin();
    }

    private void getListsFromPreviousActivity() {
        names_redTeam = (ArrayList<String>) getIntent().getSerializableExtra("names_redTeam");
        names_blueTeam = (ArrayList<String>) getIntent().getSerializableExtra("names_blueTeam");
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

    private void setFirstPlayer() {
        ArrayList<String> listOfPlayers = drawTeam();
        next_player.setText(listOfPlayers.get(0));
    }

    private ArrayList<String> drawTeam() {
        int drawTeam = (int)(Math.random()*2);
        if(drawTeam == 0) {
            return names_blueTeam;
        } else if(drawTeam == 1) {
            return names_redTeam;
        } else {
            throw new IllegalArgumentException("Incorrect value of drawTeam variable");
        }
    }
}

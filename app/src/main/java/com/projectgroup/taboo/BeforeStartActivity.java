package com.projectgroup.taboo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
        setFirstPlayer(drawTeam());
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

    private void setFirstPlayer(ArrayList<String> firstTeam) {
        next_player.setText(firstTeam.get(0));
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
    }

    public void changeTeam(View view) {
        ArrayList<String> temp = global.getFirstTeam();
        global.setFirstTeam(global.getSecondTeam());
        global.setSecondTeam(temp);
        setFirstPlayer(global.getFirstTeam());
    }
}

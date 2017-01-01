package com.projectgroup.taboo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class BeforeStartActivity extends AppCompatActivity {

    private List<String> names_redTeam;
    private List<String> names_blueTeam;
    private Button button$_changePlayer;
    private Context context;
    private Global global;
    private LinearLayout layout$_recycler_views;
    private RecyclerView recyclerViewBlue;
    private RecyclerView recyclerViewRed;
    private RecyclerView.Adapter recyclerViewAdapterBlue;
    private RecyclerView.Adapter recyclerViewAdapterRed;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    private RecyclerView.LayoutManager recyclerViewLayoutManager2;
    private TextView scoresRedTeam;
    private TextView scoresBlueTeam;
    private TextView view$_pointsToWin;
    private TextView next_player;
    private TextView redLabel;
    private TextView blueLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_before_start);
        context = getApplicationContext();

        init();
        setLabels();
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
        layout$_recycler_views = (LinearLayout) findViewById(R.id.layout_with_recycler_views);
    }

    private void setLabels() {
        redLabel.setText(global.getString$_red_team());
        blueLabel.setText(global.getString$_blue_team());
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

        String pointsToWin = String.valueOf(global.getDefault$_points_to_win());
        view$_pointsToWin.setText(pointsToWin);
    }

    private List<String> drawTeam() {
        int drawTeam = (int)(Math.random()*2);
        List<String> firstTeam;
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
        global.changePlayer();
        global.setFirstPlayer_withNames(global.getFirstTeam(), next_player);
    }

    public void changeTeam(View view) {
        global.changeTeam();
        if(global.isPlay_without_names()) {
            global.setFirstPlayer_withoutNames(next_player);
        } else {
            global.setFirstPlayer_withNames(global.getFirstTeam(), next_player);
        }
    }

    public void setFirstPlayer() {
        if(global.isPlay_without_names()) {
            button$_changePlayer.setVisibility(View.INVISIBLE);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 300, 0, 0);
            layout$_recycler_views.setLayoutParams(layoutParams);
            global.setFirstPlayer_withoutNames(next_player);
        } else if(global.isPlay_without_names() == false) {
            global.setFirstPlayer_withNames(drawTeam(), next_player);
        } else {
            throw new IllegalArgumentException("Something went wrong");
        }
    }

    public void startGame(View view) {
    }
}

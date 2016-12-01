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

    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapterBlueTeam;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    TextView scoresRedTeam;
    TextView scoresBlueTeam;
    ArrayList<String> names_redTeam;
    ArrayList<String> names_blueTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);

        setContentView(R.layout.activity_before_start);

        context = getApplicationContext();

        names_redTeam = (ArrayList<String>) getIntent().getSerializableExtra("names_redTeam");
        names_blueTeam = (ArrayList<String>) getIntent().getSerializableExtra("names_blueTeam");

        scoresRedTeam = (TextView) findViewById(R.id.score_red_team);
        scoresBlueTeam = (TextView) findViewById(R.id.score_blue_team);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_blue);

        recylerViewLayoutManager = new LinearLayoutManager(context);

        recyclerView.setLayoutManager(recylerViewLayoutManager);

        recyclerViewAdapterBlueTeam = new RecyclerViewAdapter(context, names_blueTeam, names_redTeam);

        recyclerView.setAdapter(recyclerViewAdapterBlueTeam);
    }
}

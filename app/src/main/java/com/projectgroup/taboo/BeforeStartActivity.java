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
    RecyclerView recyclerViewBlue;
    RecyclerView recyclerViewRed;
    RecyclerView.Adapter recyclerViewAdapterBlue;
    RecyclerView.Adapter recyclerViewAdapterRed;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    RecyclerView.LayoutManager recyclerViewLayoutManager2;
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

        recyclerViewBlue = (RecyclerView) findViewById(R.id.recycler_blue);
        recyclerViewRed = (RecyclerView) findViewById(R.id.recycler_red);

        recyclerViewLayoutManager = new LinearLayoutManager(context);
        recyclerViewLayoutManager2 = new LinearLayoutManager(context);

        recyclerViewBlue.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewRed.setLayoutManager(recyclerViewLayoutManager2);

        recyclerViewAdapterBlue = new RecyclerViewAdapterBlue(context, names_blueTeam);
        recyclerViewAdapterRed = new RecyclerViewAdapterRed(context, names_redTeam);

        recyclerViewBlue.setAdapter(recyclerViewAdapterBlue);
        recyclerViewRed.setAdapter(recyclerViewAdapterRed);
    }
}

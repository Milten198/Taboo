package com.projectgroup.taboo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class StartGameActivity extends AppCompatActivity {

    ArrayList<String> names_redTeam;
    ArrayList<String> names_blueTeam;
    JSONObject json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        TextView textOut = (TextView)findViewById(R.id.textout2);
        names_redTeam = (ArrayList<String>) getIntent().getSerializableExtra("names_redTeam");
        names_blueTeam = (ArrayList<String>) getIntent().getSerializableExtra("names_blueTeam");
        try {
            json = new JSONObject(StartGameActivity.readXMLinString("test.txt",getApplicationContext()));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        textOut.setText("Czerwoni: " + names_redTeam + " ;;;;;; " + ", Niebiescy: " + names_blueTeam);
    }

    public static String readXMLinString(String fileName, Context c) throws IOException {
        try {
            InputStream is = c.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String text = new String(buffer);

            return text;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

package com.projectgroup.taboo;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

public class SettingsActivity extends Activity {

    private CheckBox checkbox$_level_easy;
    private CheckBox checkbox$_level_average;
    private CheckBox checkbox$_level_difficult;
    private CheckBox checkbox$_level_very_difficult;
    private Spinner spinner$_points_to_win;
    private Spinner spinner$_time_per_question;
    private Spinner spinner$_forbidden_words;
    private Spinner spinner$_points_correct_answer;
    private Spinner spinner$_points_incorrect_answer;
    private Global global;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        global = new Global();
        initSpinners();
        initCheckboxes();
        initDefaultValues();
        setDefaultValues();
    }

    private void initDefaultValues() {
        int a = global.getArray$_points_to_win().
        int points_to_win = Integer.parseInt(global.getArray$_points_to_win()[3]);
        global.setDefault$_points_to_win(points_to_win);
        int points_correct_answer = Integer.parseInt(global.getArray$_points_correct_answer()[2]);
        global.setDefault$_points_correct_answer(points_correct_answer);
        int points_incorrect_answer = Integer
                .parseInt(global.getArray$_points_incorrect_answer()[0]);
        global.setDefault$_points_incorrect_answer(points_incorrect_answer);
        int forbidden_words = Integer.parseInt(global.getArray$_forbidden_words()[2]);
        global.setDefault$_forbidden_words(forbidden_words);
        int time_per_player = Integer.parseInt(global.getArray$_time_per_player()[2]);
        global.setDefault$_time_per_player(time_per_player);
        spinner$_points_to_win.setSelection(3);
    }

    private void initSpinners() {
        spinner$_points_to_win = (Spinner) findViewById(R.id.spinner$_points_to_win);
        spinner$_time_per_question = (Spinner) findViewById(R.id.spinner$_time_per_player);
        spinner$_forbidden_words = (Spinner) findViewById(R.id.spinner$_forbidden_words);
        spinner$_points_correct_answer = (Spinner)
                findViewById(R.id.spinner$_points_correct_answer);
        spinner$_points_incorrect_answer = (Spinner)
                findViewById(R.id.spinner$_points_incorrect_answer);
        createSpinner(spinner$_points_to_win, global.getArray$_points_to_win());
        createSpinner(spinner$_time_per_question, global.getArray$_time_per_player());
        createSpinner(spinner$_forbidden_words, global.getArray$_forbidden_words());
        createSpinner(spinner$_points_correct_answer, global.getArray$_points_correct_answer());
        createSpinner(spinner$_points_incorrect_answer, global.getArray$_points_incorrect_answer());
    }

    public void initCheckboxes() {
        checkbox$_level_easy = (CheckBox) findViewById(R.id.level_easy);
        checkbox$_level_average = (CheckBox) findViewById(R.id.level_average);
        checkbox$_level_difficult = (CheckBox) findViewById(R.id.level_difficult);
        checkbox$_level_very_difficult = (CheckBox) findViewById(R.id.level_very_difficult);
    }

    public void setDefaultValues() {
    }

    private void createSpinner(Spinner spinner, String[] array) {
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}

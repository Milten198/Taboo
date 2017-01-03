package com.projectgroup.taboo;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

public class SettingsActivity extends Activity {

    private Spinner spinner$_points_to_win;
    private Spinner spinner$_time_per_question;
    private Spinner spinner$_forbidden_words;
    private Spinner spinner$_points_correct_answer;
    private Spinner spinner$_points_incorrect_answer;
    private CheckBox checkbox$_level_easy;
    private CheckBox checkbox$_level_average;
    private CheckBox checkbox$_level_difficult;
    private CheckBox checkbox$_level_very_difficult;
    private Global global;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        global = new Global();
        initSpinners();
        initCheckboxes();
        setDefaultValues();
    }

    private void initSpinners() {
        spinner$_points_to_win = (Spinner) findViewById(R.id.spinner$_points_to_win);
        spinner$_time_per_question = (Spinner) findViewById(R.id.spinner$_time_per_player);
        spinner$_forbidden_words = (Spinner) findViewById(R.id.spinner$_forbidden_words);
        spinner$_points_correct_answer = (Spinner) findViewById(R.id.spinner$_points_correct_answer);
        spinner$_points_incorrect_answer = (Spinner) findViewById(R.id.spinner$_points_incorrect_answer);
        createSpinner(spinner$_points_to_win, R.array.points_to_win);
        createSpinner(spinner$_time_per_question, R.array.time_per_player);
        createSpinner(spinner$_forbidden_words, R.array.forbidden_words);
        createSpinner(spinner$_points_correct_answer, R.array.points_correct_answer);
        createSpinner(spinner$_points_incorrect_answer, R.array.points_incorrect_answer);
    }

    public void initCheckboxes() {
        checkbox$_level_easy = (CheckBox) findViewById(R.id.level_easy);
        checkbox$_level_average = (CheckBox) findViewById(R.id.level_average);
        checkbox$_level_difficult = (CheckBox) findViewById(R.id.level_difficult);
        checkbox$_level_very_difficult = (CheckBox) findViewById(R.id.level_very_difficult);
    }

    public void setDefaultValues() {
    }

    private void createSpinner(Spinner spinner, int array) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                array, android.R.layout.simple_spinner_item);
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

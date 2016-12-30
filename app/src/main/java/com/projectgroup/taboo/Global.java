package com.projectgroup.taboo;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomaszkubit on 22.12.2016.
 */

public class Global {

    /*
    Default values
    All the default values from here should be set in Settings
    The values here have to change when a user clicks OK in Settings
    For now, default value of points to win is set to 30
    */
    private int default$_points_to_win = 30;
    private int default$_forbidden_words = 5;
    private int default$_points_correct_answer = 1;
    private int default$_points_incorrect_answer = -1;
    private int max_num_of_players = 6;
    private static List<String> firstTeam;
    private static List<String> secondTeam;
    private static List<String> blueTeam = new ArrayList<>();
    private static List<String> redTeam = new ArrayList<>();

    //---------------------------------------------------------------------------
    //------------------------------ METHODS ------------------------------------
    //---------------------------------------------------------------------------

    public void changePlayer(View view) {
        List<String> currentTeam = getFirstTeam();
        String firstPlayer = currentTeam.get(0);
        currentTeam.remove(0);
        currentTeam.add(firstPlayer);
        setFirstTeam(currentTeam);
    }

    public void changeTeam(View view) {
        List<String> temp = getFirstTeam();
        setFirstTeam(getSecondTeam());
        setSecondTeam(temp);
    }

    public void setFirstPlayer(List<String> firstTeam, TextView next_player) {
        next_player.setText(firstTeam.get(0));
    }

    public void copyListsToGlobal(List<String> dest, List<String> src) {
        for(int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
        }
    }

    public void addValueToList(List<String> list, String value) {
        list.add(value);
    }

    //---------------------------------------------------------------------------
    //------------------------ GETTERS AND SETTERS ------------------------------
    //---------------------------------------------------------------------------

    public void setDefault$_points_to_win(int default$_points_to_win) {
        this.default$_points_to_win = default$_points_to_win;
    }

    public int getDefault$_points_to_win() {
        return default$_points_to_win;
    }

    public List<String> getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(List<String> firstTeam) {
        this.firstTeam = firstTeam;
    }

    public List<String> getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(List<String> secondTeam) {
        this.secondTeam = secondTeam;
    }

    public void setBlueTeam(List<String> blueTeam) {
        this.blueTeam = blueTeam;
    }

    public void setRedTeam(List<String> redTeam) {
        this.redTeam = redTeam;
    }

    public List<String> getBlueTeam() {
        return blueTeam;
    }

    public List<String> getRedTeam() {
        return redTeam;
    }

    public int getMaxNumOfPlayers() {
        return max_num_of_players;
    }

    public int getDefault$_forbidden_words() {
        return default$_forbidden_words;
    }

    public void setDefault$_forbidden_words(int default$_forbidden_words) {
        this.default$_forbidden_words = default$_forbidden_words;
    }

    public int getMax_num_of_players() {
        return max_num_of_players;
    }

    public void setMax_num_of_players(int max_num_of_players) {
        this.max_num_of_players = max_num_of_players;
    }

    public int getDefault$_points_correct_answer() {
        return default$_points_correct_answer;
    }

    public void setDefault$_points_correct_answer(int default$_points_correct_answer) {
        this.default$_points_correct_answer = default$_points_correct_answer;
    }

    public int getDefault$_points_incorrect_answer() {
        return default$_points_incorrect_answer;
    }

    public void setDefault$_points_incorrect_answer(int default$_points_incorrect_answer) {
        this.default$_points_incorrect_answer = default$_points_incorrect_answer;
    }
}

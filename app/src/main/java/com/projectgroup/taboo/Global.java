package com.projectgroup.taboo;

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
    private static boolean play_without_names;
    private int default$_points_to_win = 30;
    private int default$_forbidden_words = 5;
    private int default$_points_correct_answer = 1;
    private int default$_points_incorrect_answer = -1;
    private int max_num_of_players = 6;
    private static List<String> firstTeam;
    private static List<String> secondTeam;
    private static List<String> blueTeam = new ArrayList<>();
    private static List<String> redTeam = new ArrayList<>();
    private String string$_red_team = "Czerwoni";
    private String string$_blue_team = "Niebiescy";
    private String string$_first_team;
    private String string$_second_team;



    private int[] points_to_win = new int[] {
            15, 20, 25, 30, 35, 40, 45, 50
    };

   private int[] forbidden_words = new int[] {
           3, 4, 5, 6, 7
   };

    private int[] points_correct_answer = new int[] {
            1, 2, 3
    };

    private int[] points_incorrect_answer = new int[] {
            -3, -2, -1, 0
    };



/*    <string-array name="time_per_player">
    <item>00:30</item>
    <item>00:45</item>
    <item>01:00</item>
    <item>01:15</item>
    <item>01:30</item>
    <item>01:45</item>
    <item>02:00</item>
    </string-array>*/

    //---------------------------------------------------------------------------
    //------------------------------ METHODS ------------------------------------
    //---------------------------------------------------------------------------

    public void changePlayer() {
        List<String> currentTeam = getFirstTeam();
        String firstPlayer = currentTeam.get(0);
        currentTeam.remove(0);
        currentTeam.add(firstPlayer);
        setFirstTeam(currentTeam);
    }

    public void changeTeam() {
        if(play_without_names == false) {
            List<String> temp = getFirstTeam();
            setFirstTeam(getSecondTeam());
            setSecondTeam(temp);
        } else if(play_without_names) {
            String temp = getString$_first_team();
            setString$_first_team(string$_second_team);
            setString$_second_team(temp);
        }
    }

    public void setFirstPlayer_withNames(List<String> firstTeam, TextView next_player) {
        next_player.setText(firstTeam.get(0));
    }

    public void setFirstPlayer_withoutNames(TextView next_player) {
        if(getString$_first_team() == null) {
            int draw = (int) (Math.random() * 2);
            if (draw == 0) {
                string$_first_team = string$_red_team;
                string$_second_team = string$_blue_team;
            } else if (draw == 1) {
                string$_first_team = string$_blue_team;
                string$_second_team = string$_red_team;
            } else {
                throw new IllegalArgumentException("Something went wrong");
            }
        }
        next_player.setText(getString$_first_team());
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

    public static boolean isPlay_without_names() {
        return play_without_names;
    }

    public static void setPlay_without_names(boolean play_without_names) {
        Global.play_without_names = play_without_names;
    }

    public String getString$_red_team() {
        return string$_red_team;
    }

    public String getString$_blue_team() {
        return string$_blue_team;
    }

    public String getString$_first_team() {
        return string$_first_team;
    }

    public void setString$_first_team(String string$_first_team) {
        this.string$_first_team = string$_first_team;
    }

    public String getString$_second_team() {
        return string$_second_team;
    }

    public void setString$_second_team(String string$_second_team) {
        this.string$_second_team = string$_second_team;
    }

    public int[] getPoints_incorrect_answer() {
        return points_incorrect_answer;
    }

    public int[] getPoints_to_win() {
        return points_to_win;
    }

    public int[] getForbidden_words() {
        return forbidden_words;
    }

    public int[] getPoints_correct_answer() {
        return points_correct_answer;
    }
}

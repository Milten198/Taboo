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
    private int pointsToWinGame = 30;
    private static int maxNumOfPlayers = 6;
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

    public void setPointsToWinGame(int pointsToWinGame) {
        this.pointsToWinGame = pointsToWinGame;
    }

    public int getPointsToWinGame() {
        return pointsToWinGame;
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
        return maxNumOfPlayers;
    }
}

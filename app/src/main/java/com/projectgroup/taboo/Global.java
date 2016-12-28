package com.projectgroup.taboo;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

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
    private static ArrayList<String> firstTeam;
    private static ArrayList<String> secondTeam;
    private static ArrayList<String> blueTeam;
    private static ArrayList<String> redTeam;

    //---------------------------------------------------------------------------
    //------------------------------ METHODS ------------------------------------
    //---------------------------------------------------------------------------

    public void changePlayer(View view) {
        ArrayList<String> currentTeam = getFirstTeam();
        String firstPlayer = currentTeam.get(0);
        currentTeam.remove(0);
        currentTeam.add(firstPlayer);
        setFirstTeam(currentTeam);
    }

    public void changeTeam(View view) {
        ArrayList<String> temp = getFirstTeam();
        setFirstTeam(getSecondTeam());
        setSecondTeam(temp);
    }

    public void setFirstPlayer(ArrayList<String> firstTeam, TextView next_player) {
        next_player.setText(firstTeam.get(0));
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

    public ArrayList<String> getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(ArrayList<String> firstTeam) {
        this.firstTeam = firstTeam;
    }

    public ArrayList<String> getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(ArrayList<String> secondTeam) {
        this.secondTeam = secondTeam;
    }

    public void setBlueTeam(ArrayList<String> blueTeam) {
        this.blueTeam = blueTeam;
    }

    public void setRedTeam(ArrayList<String> redTeam) {
        this.redTeam = redTeam;
    }

    public ArrayList<String> getBlueTeam() {
        return blueTeam;
    }

    public ArrayList<String> getRedTeam() {
        return redTeam;
    }
}

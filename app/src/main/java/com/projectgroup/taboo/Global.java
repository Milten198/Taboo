package com.projectgroup.taboo;

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
    private ArrayList<String> firstTeam;
    private ArrayList<String> secondTeam;

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
}

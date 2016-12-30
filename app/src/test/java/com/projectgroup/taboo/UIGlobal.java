package com.projectgroup.taboo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by y50-70 on 30.12.2016.
 */

public class UIGlobal {

    private Global global;

    @Before
    public void setUp() {
        global = new Global();
    }

    @Test
    public void check_array_first_team_null() {
        String text = "First team array at start should be null";
        Assert.assertEquals(text, null, global.getFirstTeam());
    }

    @Test
    public void check_array_second_team_null() {
        String text = "Seconds team array at start should be null";
        Assert.assertEquals(text, null, global.getSecondTeam());
    }

    @Test
    public void check_array_red_team_empty() {
        String text = "Red team array at start should be empty";
        Assert.assertEquals(text, 0, global.getRedTeam().size());
    }

    @Test
    public void check_array_blue_team_empty() {
        String text = "Blue team array at start should be empty";
        Assert.assertEquals(text, 0, global.getBlueTeam().size());
    }

    @Test
    public void check_max_number_of_players() {
        int max_num_players = global.getMax_num_of_players();
        Assert.assertEquals("Max number of players is 6", 6, max_num_players);
    }

    @Test
    public void check_default_points_to_win() {
        int points_to_win = global.getDefault$_points_to_win();
        Assert.assertEquals("Default value of points to win is 30", 30, points_to_win);
    }

    @Test
    public void check_default_forbidden_words() {
        int forbidden_words = global.getDefault$_forbidden_words();
        Assert.assertEquals("Default value of forbidden words is 5", 5, forbidden_words);
    }

    @Test
    public void check_default_points_correct_answer() {
        int points_correct_answer = global.getDefault$_points_correct_answer();
        String text = "Default value of points for correct answer is 1";
        Assert.assertEquals(text, 1, points_correct_answer);
    }

    @Test
    public void check_default_points_incorrect_answer() {
        int points_incorrect_answer = global.getDefault$_points_incorrect_answer();
        String text_incorrect = "Default value of points for incorrect answer is -1";
        Assert.assertEquals(text_incorrect, -1, points_incorrect_answer);
    }

}

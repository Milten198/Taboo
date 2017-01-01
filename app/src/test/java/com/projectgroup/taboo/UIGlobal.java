package com.projectgroup.taboo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by y50-70 on 30.12.2016.
 */

public class UIGlobal {

    private Global global;
    private String name1 = "Kasia";
    private String name2 = "Ania";
    private String name3 = "Basia";
    private String name4 = "Joasia";

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

    @Test
    public void check_if_change_player_works() {
        List<String> list_of_names = new ArrayList<>(Arrays.asList(name1, name2, name3));
        Assert.assertEquals("Array should be null", null, global.getFirstTeam());
        global.setFirstTeam(new ArrayList<>(Arrays.asList(name1, name2, name3)));
        Assert.assertEquals(global.getFirstTeam(), list_of_names);
        global.changePlayer();
        String message = "Array should be " + name2 + ", " + name3 + ", " + name1;
        Assert.assertEquals(message, global.getFirstTeam(), changePlayer(list_of_names));
        global.changePlayer();
        message = "Array should be " + name3 + ", " + name1 + ", " + name2;
        Assert.assertEquals(message, global.getFirstTeam(), changePlayer(list_of_names));
        global.changePlayer();
        message = "Array should be " + name1 + ", " + name2 + ", " + name3;
        Assert.assertEquals(message, global.getFirstTeam(), changePlayer(list_of_names));
    }

    @Test
    public void check_if_team_changes() {
        global.setFirstTeam(new ArrayList<String>(Arrays.asList(name1, name2)));
        global.setSecondTeam(new ArrayList<String>(Arrays.asList(name3, name4)));
        global.changeTeam();
        String messageFirst = "First team now contains " + name3 + " and " + name4;
        String messageSecond = "Second team now contains " + name1 + " and " + name2;
        Assert.assertTrue(messageFirst, global.getFirstTeam().contains(name3));
        Assert.assertTrue(messageFirst, global.getFirstTeam().contains(name4));
        Assert.assertTrue(messageSecond, global.getSecondTeam().contains(name1));
        Assert.assertTrue(messageSecond, global.getSecondTeam().contains(name2));
        global.changeTeam();
        messageFirst = "First team now contains " + name1 + " and " + name2;
        messageSecond = "Second team now contains " + name3 + " and " + name4;
        Assert.assertTrue(messageFirst, global.getFirstTeam().contains(name1));
        Assert.assertTrue(messageFirst, global.getFirstTeam().contains(name2));
        Assert.assertTrue(messageSecond, global.getSecondTeam().contains(name3));
        Assert.assertTrue(messageSecond, global.getSecondTeam().contains(name4));
    }

    @Test
    public void check_add_value_to_list_method() {
        List<String> list = global.getBlueTeam();
        global.addValueToList(list, name1);
        global.addValueToList(list, name2);
        String message = "List should contain names " + name1 + " and " + name2;
        Assert.assertTrue(message, global.getBlueTeam().contains(name1));
        Assert.assertTrue(message, global.getBlueTeam().contains(name2));
    }

    @Test
    public void check_copy_list_to_another_list() {
        List<String> first_list = new ArrayList<>(Arrays.asList(name1, name2, name3));
        List<String> second_list = new ArrayList<>();
        global.copyListsToGlobal(second_list, first_list);
        String message = "Both list should contain " + name1 + ", " + name2 + " and " + name3;
        for(int i = 0; i < second_list.size(); i++) {
            Assert.assertEquals(message, second_list.get(i), first_list.get(i));
        }
    }

    public List<String> changePlayer(List<String> list) {
        String name = list.get(0);
        list.remove(0);
        list.add(name);

        return list;
    }
}

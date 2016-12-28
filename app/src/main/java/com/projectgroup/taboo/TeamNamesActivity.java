package com.projectgroup.taboo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TeamNamesActivity extends Activity {

    private ArrayList<String> names_blueTeam = new ArrayList<>();
    private ArrayList<String> names_redTeam = new ArrayList<>();
    private Button go_further;
    private Button button_more_players;
    private Button addPlayersRedTeam;
    private Button addPlayersBlueTeam;
    private EditText namesBlueTeam;
    private EditText namesRedTeam;
    private Global global;
    private LinearLayout containerBlueTeam;
    private LinearLayout containerRedTeam;
    private int shortestNameLength = 1;
    private int longestNameLength = 8;
    private int maxNumOfPlayers = 6;
    private String nameToShow;
    private String text$_goFurhther_disabled;
    private String text$_goFurhther_enabled = "Idź dalej";
    private String defaultNameForPlayers = "Gracz ";
    private String string$_redTeam = "Czerwoni";
    private String string$_blueTeam = "Niebiescy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_names);
        config();
        handleHittingEnter();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(global.getBlueTeam().contains(string$_blueTeam)) {
            global.getBlueTeam().remove(string$_blueTeam);
        } if(global.getRedTeam().contains(string$_redTeam)) {
            global.getRedTeam().remove(string$_redTeam);
        }
    }

    public void config() {
        text$_goFurhther_disabled = this.getString(R.string.go_further);
        go_further = (Button) findViewById(R.id.go_further);
        namesBlueTeam = (EditText) findViewById(R.id.first_player_blue);
        namesRedTeam = (EditText) findViewById(R.id.first_player_red);
        addPlayersBlueTeam = (Button) findViewById(R.id.more_players_blue_team);
        addPlayersRedTeam = (Button) findViewById(R.id.more_players_red_team);
        containerBlueTeam = (LinearLayout) findViewById(R.id.container_blue);
        containerRedTeam = (LinearLayout) findViewById(R.id.container_red);
        global = new Global();
    }

    public void addMorePlayers_blueTeam(View view) {
        button_more_players = (Button) findViewById(R.id.more_players_blue_team);
        addPlayers(namesBlueTeam, containerBlueTeam, names_blueTeam);
    }

    public void addMorePlayers_redTeam(View view) {
        button_more_players = (Button) findViewById(R.id.more_players_red_team);
        addPlayers(namesRedTeam, containerRedTeam, names_redTeam);
    }

    public void addPlayers(EditText field_nameOfPlayer, LinearLayout container,
                           final List<String> playersNames) {

        boolean correctNumOfPlayers = checkNumPlayers(playersNames);

        if (correctNumOfPlayers) {
            String currentName = field_nameOfPlayer.getText().toString();
            if (currentName.equals("")) {
                currentName = createNameForPlayer(playersNames);
                addPlayersToList(field_nameOfPlayer, container, playersNames, currentName);
            } else if (currentName.length() > longestNameLength) {
                createToast("Za długie imię");
                field_nameOfPlayer.setText("");
            } else if (currentName.length() >= shortestNameLength && currentName.length() <= longestNameLength) {
                if (playersNames.contains(currentName)) {
                    createToast("To imię już istnieje. Wybierz inne");
                } else {
                    addPlayersToList(field_nameOfPlayer, container, playersNames, currentName);
                }
            } else {
                throw new IllegalArgumentException("There's handle wrong with length of players name");
            }
        } else {
            createToast("Za dużo graczy. Maksymalna liczba to " + maxNumOfPlayers);
        }

        checkIfEnoughPlayersToGoFurther();
    }

    public void addPlayersToList(EditText field_nameOfPlayer, LinearLayout container,
                                 final List<String> playersNames, final String currentName) {
        final View addView;
        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        addView = layoutInflater.inflate(R.layout.activity_to_add_more_players,
                null);
        final TextView textOut = (TextView) addView.findViewById(R.id.textout);
        textOut.setText(currentName);
        playersNames.add(currentName);

        field_nameOfPlayer.setText("");
        Button buttonRemove = (Button) addView.findViewById(R.id.remove);
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playersNames.remove(currentName);
                ((LinearLayout) addView.getParent()).removeView(addView);
                renameNamesForDefaultPlayers(playersNames, textOut);
                checkIfEnoughPlayersToGoFurther();
            }
        });
        container.addView(addView);
    }

    public boolean checkNumPlayers(List<String> numberOfPlayersInList) {

        boolean correctNumOfPlayers = false;

        if (numberOfPlayersInList.size() < maxNumOfPlayers) {
            correctNumOfPlayers = true;
        }

        return correctNumOfPlayers;
    }

    public String createNameForPlayer(List<String> playersNames) {
        int numberForPlayer = playersNames.size() + 1;
        String gamer = defaultNameForPlayers + numberForPlayer;
        return gamer;
    }

    public void createToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void goFurther(View view) {
        Intent beforeStartIntent = new Intent(this, BeforeStartActivity.class);
        global.setBlueTeam(names_blueTeam);
        global.setRedTeam(names_redTeam);
        startActivity(beforeStartIntent);
    }

    public void goFurtherWithoutNames(View view) {
        Intent beforeStartIntent = new Intent(this, BeforeStartActivity.class);
        if(global.getBlueTeam() != null && global.getBlueTeam().size() > 0) {
            global.getBlueTeam().clear();
        }
        if(global.getRedTeam() != null && global.getRedTeam().size() > 0) {
            global.getRedTeam().clear();
        }
        names_redTeam.add(string$_redTeam);
        names_blueTeam.add(string$_blueTeam);
        global.setRedTeam(names_redTeam);
        global.setBlueTeam(names_blueTeam);
        startActivity(beforeStartIntent);
    }

    public void handleHittingEnter() {
        namesBlueTeam.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    createToast("Enter");
                    return true;
                } else {
                    return false;
                }
            }
        });
        namesRedTeam.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    createToast("Enter");
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    public void checkIfEnoughPlayersToGoFurther() {
        if(names_blueTeam.size() > 1 && names_redTeam.size() > 1) {
            go_further.setAlpha(1);
            go_further.setEnabled(true);
            go_further.setText(text$_goFurhther_enabled);
        } else {
            go_further.setEnabled(false);
            go_further.setAlpha(.5f);
            this.getString(R.string.go_further);
            go_further.setText(text$_goFurhther_disabled);
        }
    }



    public void renameNamesForDefaultPlayers(List<String> listToModify, TextView viewForNames) {
        for(int i = 0; i < listToModify.size(); i++) {
            String name = listToModify.get(i);
            if(name.contains(defaultNameForPlayers)) {
                name = name.replace(name, defaultNameForPlayers + (i+1));
                viewForNames.setText(name);
                Log.d("Current name: ", name);
            }
            Log.d("Current name: ", name);
        }
        Log.d("Current list: ", listToModify.toString());
        Log.d("Sth", "A");
    }
}
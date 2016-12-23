package com.projectgroup.taboo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

    Button go_further;
    Button button_more_players;
    EditText namesBlueTeam;
    Button addPlayersBlueTeam;
    LinearLayout containerBlueTeam;
    EditText namesRedTeam;
    Button addPlayersRedTeam;
    LinearLayout containerRedTeam;
    int shortestNameLength = 1;
    int longestNameLength = 8;
    int maxNumOfPlayers = 6;
    String nameToShow;
    ArrayList<String> names_blueTeam = new ArrayList<>();
    ArrayList<String> names_redTeam = new ArrayList<>();
    String text$_goFurhther_disabled;
    String text$_goFurhther_enabled = "Idź dalej";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_names);
        config();
        handleHittingEnter();
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
        TextView textOut = (TextView) addView.findViewById(R.id.textout);
        textOut.setText(currentName);
        playersNames.add(currentName);

        field_nameOfPlayer.setText("");
        Button buttonRemove = (Button) addView.findViewById(R.id.remove);
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playersNames.remove(currentName);
                ((LinearLayout) addView.getParent()).removeView(addView);
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
        String gamer = "";

        if(numberForPlayer == 1) {
            gamer = "Gracz " + numberForPlayer;
        } else

        return gamer;
    }

    public void createToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void goFurther(View view) {

        Intent beforeStartIntent = new Intent(this, BeforeStartActivity.class);
        beforeStartIntent.putExtra("names_redTeam", names_redTeam);
        beforeStartIntent.putExtra("names_blueTeam", names_blueTeam);
        startActivity(beforeStartIntent);

    }

    public void goFurtherWithoutNames(View view) {

        Intent beforeStartIntent = new Intent(this, BeforeStartActivity.class);
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
}
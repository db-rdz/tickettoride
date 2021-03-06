package com.example.ryanblaser.tickettoride.GUI.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ryanblaser.tickettoride.Client.ClientFacade;
import com.example.ryanblaser.tickettoride.R;

import java.util.ArrayList;
import java.util.List;

public class WaitingActivity extends AppCompatActivity {

    private ListView listView_players;
    private Button button_start_game;
    private TextView textView_waiting_text;
    private ArrayAdapter<String> list_of_users;

    private void debugPlayWithOnePlayer() {
        int gameId = ClientFacade.SINGLETON.getClientModel().getInt_curr_gameId();
        int playerSize = ClientFacade.SINGLETON.getClientModel().getGameId_to_usernames().get(gameId).size();
        List<String> usernamesInGame = ClientFacade.SINGLETON.getClientModel().getGameId_to_usernames().get(gameId);

        ClientFacade.SINGLETON.startGame(gameId, usernamesInGame);
        Toast.makeText(getBaseContext(), "Starting Game with " + playerSize + " players!", Toast.LENGTH_SHORT).show();
    }

    private void playWithTwoToFivePlayers() {
        if (isTwoToFivePlayers()) {
            int gameId = ClientFacade.SINGLETON.getClientModel().getInt_curr_gameId();
            int playerSize = ClientFacade.SINGLETON.getClientModel().getGameId_to_usernames().get(gameId).size();
            List<String> usernamesInGame = ClientFacade.SINGLETON.getClientModel().getGameId_to_usernames().get(gameId);

            ClientFacade.SINGLETON.startGame(gameId, usernamesInGame);
            Toast.makeText(getBaseContext(), "Starting Game with " + playerSize + " players!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getBaseContext(), "Need 2-5 players to start the game", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

        ClientFacade.SINGLETON.getClientModel().setWaitingActivity(this);

        int gameId = ClientFacade.SINGLETON.getClientModel().getInt_curr_gameId();
        getSupportActionBar().setTitle("Ticket To Ride - Game " + gameId + " Lobby");

        listView_players = (ListView) findViewById(R.id.list_players_in_game);
        listView_players.setClickable(false);

        textView_waiting_text = (TextView) findViewById(R.id.textView_waiting_text);
        textView_waiting_text.setClickable(false);

        button_start_game = (Button) findViewById(R.id.button_start_game);
        button_start_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                playWithTwoToFivePlayers();
                debugPlayWithOnePlayer();

            }
        });
    }

    private Boolean isTwoToFivePlayers() {
        int gameId = ClientFacade.SINGLETON.getClientModel().getInt_curr_gameId();
        int gameSize = ClientFacade.SINGLETON.getClientModel().getGameId_to_usernames().get(gameId).size();
        if (gameSize < 2 || gameSize > 5) { //If the amount of players is less than 2 or greater than 5,
            return false;
        }
        else { //If there's 2-5 players then the game will start.
            return true;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!ClientFacade.SINGLETON.getClientModel().getBoolean_is_creator_of_game()) {
            button_start_game.setClickable(false);
            button_start_game.setVisibility(View.GONE); //Prevents players in the lobby to start the game
            textView_waiting_text.setVisibility(View.VISIBLE);
        }

        List<String> listUsers = new ArrayList<>();

        try {
            int gameId = ClientFacade.SINGLETON.getClientModel().getInt_curr_gameId();
            listUsers.addAll(ClientFacade.SINGLETON.getClientModel().getGameId_to_usernames().get(gameId));
            if (listUsers.size() > 0) {
                ArrayList<String> userList = new ArrayList<>();
                for (int i = 0; i < listUsers.size(); i++) {
                    String username = listUsers.get(i);
                    if (listUsers.get(i).equals(ClientFacade.SINGLETON.getClientModel().getUser().getUsername())) {
                        username += " (YOU)";
                    }
                    userList.add(username); //Lists the player
                }
                list_of_users = new ArrayAdapter<String>(getBaseContext(), R.layout.row_info, userList);
                listView_players.setAdapter(list_of_users);
                list_of_users.notifyDataSetChanged();
            }
        } catch (Exception e) {}

    }

    /**
     * Nathan:
     * Instead of calling onResume() and causing another view to appear on the android stack,
     * We just simply update the list view the same way we did in onResume()
     */
    public void refreshList() {
        runOnUiThread(new Runnable() { //Allows UI to be updated from a command
            @Override
            public void run() {
                if (!ClientFacade.SINGLETON.getClientModel().getBoolean_is_creator_of_game()) {
                    button_start_game.setClickable(false);
                    button_start_game.setVisibility(View.GONE); //Prevents players in the lobby to start the game
                    textView_waiting_text.setVisibility(View.VISIBLE);
                }

                List<String> listUsers = new ArrayList<>();

                try {
                    int gameId = ClientFacade.SINGLETON.getClientModel().getInt_curr_gameId();
                    listUsers.addAll(ClientFacade.SINGLETON.getClientModel().getGameId_to_usernames().get(gameId));
                    if (listUsers.size() > 0) {
                        ArrayList<String> userList = new ArrayList<>();
                        for (int i = 0; i < listUsers.size(); i++) {
                            String username = listUsers.get(i);
                            if (listUsers.get(i).equals(ClientFacade.SINGLETON.getClientModel().getUser().getUsername())) {
                                username += " (YOU)";
                            }
                            userList.add(username); //Lists the player
                        }
                        list_of_users = new ArrayAdapter<String>(getBaseContext(), R.layout.row_info, userList);
                        listView_players.setAdapter(list_of_users);
                        list_of_users.notifyDataSetChanged();
                    }
                } catch (Exception e) {}
            }
        });
    }

    /**
     * Nathan: Method is called from the InitializeGameCommand and all users will receive this.
     */
    public void switchToGameBoard() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
        Intent intent = new Intent(getBaseContext(), BoardActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode == 1)
        {
            setResult(1);
            finish();
        }
    }

}

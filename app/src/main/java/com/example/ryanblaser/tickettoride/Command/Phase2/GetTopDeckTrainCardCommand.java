package com.example.ryanblaser.tickettoride.Command.Phase2;

import com.example.ryanblaser.tickettoride.Client.User;
import com.example.ryanblaser.tickettoride.Command.ICommand;
import com.example.ryanblaser.tickettoride.Server.IServer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * FROM CLIENT -> SERVER
 * This class will allow one player to grab one train card from the deck.
 * There's another command to grab a second card either from the deck or face up train cards.
 *
 * Created by natha on 2/27/2017.
 */

public class GetTopDeckTrainCardCommand implements ICommand {
    private int gameId;
    private String authenticationCode;
    // added turn number to check what turn you're doing
    private int turnNumber;

    public GetTopDeckTrainCardCommand(int g, String code, int num)
    {
        gameId = g;
        authenticationCode = code;
        turnNumber = num;
    }

    @Override
    public List<ICommand> execute() throws IServer.GameIsFullException {
        return null;
    }

    @Override
    public String getAuthenticationCode() {
        return authenticationCode;
    }

    public int getGameId()
    {
        return gameId;
    }

    public int getTurnNumber() {
        return turnNumber;
    }
}
package com.example.ryanblaser.tickettoride.Command.Phase2;

import com.example.ryanblaser.tickettoride.Client.User;
import com.example.ryanblaser.tickettoride.Command.ICommand;
import com.example.ryanblaser.tickettoride.Command.Phase1.CommandContainer;
import com.example.ryanblaser.tickettoride.Server.IServer;
import com.example.ryanblaser.tickettoride.ServerModel.GameModels.Game;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * FROM SERVER -> CLIENT
 * Notifies when it's a specific player's turn in the game.
 *
 * Created by natha on 2/28/2017.
 */

public class NotifyTurnCommand implements ICommand {

    //Data members
    private String str_notify_message;

    //Constructor
    public NotifyTurnCommand(String str_notify_message) {
        this.str_notify_message = str_notify_message;
    }

    //Functions
    @Override
    public CommandContainer execute() throws IServer.GameIsFullException {
        return null; //TODO: Use showMessage() method or make a new one?
    }

    @JsonIgnore
    @Override
    public String getAuthenticationCode() {
        return null;
    }

    @JsonIgnore
    @Override
    public User getUser() {
        return null;
    }

    @JsonIgnore
    @Override
    public Game getGame() {
        return null;
    }

    public String getStr_notify_message() {
        return str_notify_message;
    }
}

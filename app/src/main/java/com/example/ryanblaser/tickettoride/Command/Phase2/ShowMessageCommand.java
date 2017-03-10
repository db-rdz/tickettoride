package com.example.ryanblaser.tickettoride.Command.Phase2;

import com.example.ryanblaser.tickettoride.Client.ClientFacade;
import com.example.ryanblaser.tickettoride.Client.User;
import com.example.ryanblaser.tickettoride.Command.ICommand;
import com.example.ryanblaser.tickettoride.Server.IServer;
import com.example.ryanblaser.tickettoride.ServerModel.GameModels.Game;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * FROM SERVER -> CLIENT
 * This command occurs when a player taps "Messages" on the screen.
 * This will cause a display to occur and show what has been broadcasted in the game chat.
 *
 * Created by natha on 2/28/2017.
 */

public class ShowMessageCommand implements ICommand {

    //Data members
    private String str_message;

    //Constructor
    public ShowMessageCommand(String str_message) {
        this.str_message = str_message;
    }

    //Functions
    @Override
    public List<ICommand> execute() throws IServer.GameIsFullException {
        ClientFacade.SINGLETON.showMessage(str_message);
        return null;
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



    public String getStr_message() {
        return str_message;
    }
}

package com.example.ryanblaser.tickettoride.Command.Phase2;

import com.example.ryanblaser.tickettoride.Client.ClientFacade;
import com.example.ryanblaser.tickettoride.Client.ClientModel;
import com.example.ryanblaser.tickettoride.Client.IClient;
import com.example.ryanblaser.tickettoride.Client.State;
import com.example.ryanblaser.tickettoride.Client.User;
import com.example.ryanblaser.tickettoride.Command.ICommand;
import com.example.ryanblaser.tickettoride.GUI.Presenters.PlayerActionPresenter;
import com.example.ryanblaser.tickettoride.Server.IServer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class EndTurnCommand implements ICommand {

	public EndTurnCommand(){}

	@Override
	public List<ICommand> execute() throws IServer.GameIsFullException, IClient.UserAlreadyLoggedIn {
		ClientFacade.SINGLETON.getClientModel().setState(ClientFacade.SINGLETON.getClientModel().getState().endTurn());

		ClientFacade.SINGLETON.getClientModel().getBoardActivity().refreshChat();
		ClientFacade.SINGLETON.getClientModel().getBoardActivity().refreshPlayerInfo();
		ClientFacade.SINGLETON.getClientModel().getBoardActivity().refreshGameBoard();
		ClientFacade.SINGLETON.getClientModel().getBoardActivity().refreshPlayerAction();

		return null;
	}

	@JsonIgnore
	@Override
	public String getAuthenticationCode() {
		return null;
	}

}

package tickettoride.ICommand;
import tickettoride.Server.Game;
import tickettoride.Server.ServerFacade;
public class StartGameCommand implements ICommand{
  private final Game game;
  private final int int_authentication_code;
  private AddGameToServerCommand(){}
  public AddGameToServerCommand(Game g, int k){
    game = g;
    int_authentication_code = k;}

  @Override
  public void execute(){
    ServerFacade.SINGLETON.startGame(game);}
  public int getAuthenticationCode(){
    return int_authentication_code;}}
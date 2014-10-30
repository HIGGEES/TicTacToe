package is.ru.sparkit;

import TicTacToe.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;


public class GameWeb implements SparkApplication {
	
	public static void main(String[] args){
		staticFileLocation("/public");
		SparkApplication gameWeb = new GameWeb();
		String port = System.getenv("PORT");
		
		if (port != null) {
			setPort(Integer.valueOf(port));
		}
		
		gameWeb.init();
	}

	public void init(){
		
		final Game ticTacToe = new Game();
		
		
		post(new Route("/playTurn"){
			@Override
			public Object handle(Request request, Response response){
				Integer number = Integer.valueOf(request.queryParams("playTurn")) - 1;
					ticTacToe.playTurn(number);
					String board = ticTacToe.drawBoard();


					if(!ticTacToe.gameOver()){
						String winner = "Leik Lokið ";
						if(g.isWinner())
						{
							if(g.getMovesLeft() % 2 == 0)
							{
								winner.concat("leikmaður 1 bar sigur úr bítum");
							}
							else
							{
								winner.concat("leikmaður 2 bar sigur úr bítum");
							}
						}
						else
						{
							winner.concat("enginn bar sigur úr bítum");
						}
						return winner;
					}
					else{
						return board;
					}
			}
		});
	
		post(new Route("/newGame"){
			@Ovrride
			public Object handle(Request request, Response response){
				ticTacToe = new Game();
				String board = ticTacToe.drawBoard();
				return board;
			}
		});

	}
}
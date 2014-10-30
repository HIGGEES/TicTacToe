package is.ru.TicTacToe;

//import TicTacToe.*;
import spark.*;
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
					String board = "";
					char[] tmp = ticTacToe.getBoard();
					for(int x = 0; x < tmp.length; x++){
						board = board + tmp[x] + ' ';
					}
					if(!ticTacToe.gameOver()){
						String winner = "Leik Lokid ";
						if(ticTacToe.isWinner())
						{
							if(ticTacToe.getMovesLeft() % 2 == 0)
							{
								winner.concat("leikmadur 1 bar sigur ur bitum");
							}
							else
							{
								winner.concat("leikmadur 2 bar sigur ur bitum");
							}
						}
						else
						{
							winner.concat("enginn bar sigur ur bitum");
						}
						return winner;
					}
					else{
						return board;
					}
			}
		});
	/*
		post(new Route("/newGame"){
			@Override
			public Object handle(Request request, Response response){
				ticTacToe = new Game();
				String board = ticTacToe.drawBoard();
				return board;
			}
		});*/

	}
}

package is.ru.TicTacToe;

//import TicTacToe.*;
import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;


public class GameWeb implements SparkApplication {
	
	private int telja = 0;

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
				Integer number = Integer.valueOf(request.queryParams("playTurn"));
				ticTacToe.playTurn(number);
				String result;
				if (telja == 0) {
					telja++;
					result = "mario";
					return result;
				} else {
					telja--;
					result = "luigo";
					return result;
				}
			}
		});
	
		post(new Route("/newGame"){
			@Override
			public Object handle(Request request, Response response){
				ticTacToe.resetGame();
				String board = "";
					char[] tmp = ticTacToe.getBoard();
					for(int x = 0; x < tmp.length - 1; x++){
						board = board + tmp[x] + ' ';
					}
					board = board + tmp[tmp.length - 1];
				return board;
			}
		});
	}
}

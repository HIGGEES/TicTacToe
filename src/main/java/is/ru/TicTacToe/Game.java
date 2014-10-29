package is.ru.TicTacToe;


public class Game {
	
	private Board b;
	private int movesLeft;
	private Player player1;
	private Player player2; 
	
	public Game() {
		this.b = new Board();
		this.movesLeft = 9;
		this.player1 = new Player('X');
		this.player2 = new Player('O');
	}

	public boolean playTurn(int spot){
		return true;
	}
	
	public Game(Board b) {
		this.b = b;
	}
	
	public int getMovesLeft() {
		return this.movesLeft;
	}

	public static void main(String[] args) {
		System.out.println("Testa gradle build scriptu ekkert test case fyrir þetta");

	}
}
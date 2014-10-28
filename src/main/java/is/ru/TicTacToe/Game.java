package is.ru.TicTacToe;

public class Game {
	
	private Board b;
	private int movesLeft = 9; 
	
	public Game() {
		this.b = new Board();
	}
	
	public Game(Board b) {
		this.b = b;
	}
	
	public int getMovesLeft() {
		return this.movesLeft;
	}

	public static void main(String[] args) {
		StdOut.println("Testa gradle build scriptu ekkert test case fyrir þetta");

	}
}

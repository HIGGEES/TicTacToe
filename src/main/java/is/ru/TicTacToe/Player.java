package is.ru.TicTacToe;

public class Player {
	private boolean myTurn;
	private char mySymbol;

	public Player(char symbol){
		this.mySymbol = symbol;
	}
	public char getSymbol() {
		return this.mySymbol;
	}


}

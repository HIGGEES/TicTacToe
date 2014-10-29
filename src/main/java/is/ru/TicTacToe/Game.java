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

	public boolean playTurn(int spot)
	{
		if(spot >= 0 && spot < 9)
		{
			if(movesLeft % 2 == 0)
			{
				this.b.setField(spot, player2.getSymbol());
			}
			else
			{
				this.b.setField(spot, player1.getSymbol());	
			}
			this.movesLeft--;
			return true;
		}
		return false;
	} 

	public boolean isWinner(){
		return b.isWinner();
	}

	public boolean gameOver() {

		 if(getMovesLeft() == 0 || b.isWinner())
		 {
		 	return true;
		 }
		 return false;
	}

	public Game(Board b, int turns) {
		this.b = b;
		this.movesLeft = turns;
		this.player1 = new Player('X');
		this.player2 = new Player('O');
	}
	
	public int getMovesLeft() {
		return this.movesLeft;
	}

	public static void main(String[] args) {
		System.out.println("Testa gradle build scriptu ekkert test case fyrir þetta");

	}
}
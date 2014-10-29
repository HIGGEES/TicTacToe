package is.ru.TicTacToe;

import java.util.Scanner;

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
				if(this.b.setField(spot, player2.getSymbol()))
				{
					this.movesLeft--;
					return true;
				}
				return false;
				
			}
			else
			{
				if(this.b.setField(spot, player1.getSymbol()))
				{
					this.movesLeft--;
					return true;
				}	
				return false;
			}
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

	public String drawBoard(){
		return b.toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int input;
		Game g = new Game();
		System.out.println(g.drawBoard());
		System.out.println("veldu tölu á milli 0-8 ");
		while(!g.gameOver())
		{
			input = in.nextInt();
			while(!g.playTurn(input))
			{
				System.out.println("veldu tölu á milli 0-8 ");
				input = in.nextInt();
			}
			System.out.println(g.drawBoard());
		}
		System.out.println("leik lokið");
		if(g.gameOver() && g.isWinner())
		{
			if(g.getMovesLeft() % 2 == 0)
			{
				System.out.println("Leikmaður 1 bar sigur úr bítum");
			}
			else
			{
				System.out.println("Leikmaður 2 bar sigur úr bítum");
			}
		}
		else
		{
			System.out.println("Enginn bar sigur úr bítum");
		}
	}
}
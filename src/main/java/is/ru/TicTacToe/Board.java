package is.ru.TicTacToe;

import java.lang.StringBuilder;

public class Board {
	private char[] board;

	public Board() {
		this.board = new char[9];
		setBoard();
	} 
	
	public char[] getBoard() {
		return this.board;
	}

	private void setBoard() {
		for (int i = 0; i < 9; i++) 
			this.board[i] = '-';
	}
	
}

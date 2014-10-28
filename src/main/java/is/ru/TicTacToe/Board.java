package is.ru.TicTacToe;

import java.lang.StringBuilder;

public class Board {
	private char[] board;

	public Board() {
		this.board = new char[9];
		setBoard();
	} 
	
	public char getField(int i) {
		return this.board[i];
	}

	public char[] getBoard() {
		return this.board;
	}

	private void setBoard() {
		for (int i = 0; i < 9; i++) 
			this.board[i] = '-';
	}
	
	public boolean isFieldEmpty(int i) {
		if (this.board[i] == '-')
			return true;
		return false;
	}

	public void setField(int i, char s) {
		if (i < 0 || i > 8)
			;
		else if (!isFieldEmpty(i))
			;
		else
			this.board[i] = s;
			
	}
}

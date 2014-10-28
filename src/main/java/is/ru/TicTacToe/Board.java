package is.ru.TicTacToe;

import java.lang.StringBuilder;

public class Board {
	private char[] board;
	private final int sizeOfBoard = 9;

	public Board() {
		this.board = new char[this.sizeOfBoard];
		setBoard();
	} 
	
	public char getField(int i) {
		return this.board[i];
	}

	public char[] getBoard() {
		return this.board;
	}

	private void setBoard() {
		for (int i = 0; i < this.sizeOfBoard; i++) 
			this.board[i] = (char)('0' + i);
	}
	
	public boolean isFieldEmpty(int i) {
		if (this.board[i] == (char)('0' + i))
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

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		for (int i = 0; i < this.sizeOfBoard; i++) {
			if (i % 3 == 0)
				result.append(NEW_LINE);
			result.append(" | " + board[i] + " | ");
		}
		return result.toString();
	}
}

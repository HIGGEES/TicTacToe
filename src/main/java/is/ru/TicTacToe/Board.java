package is.ru.TicTacToe;

import java.lang.StringBuilder;

public class Board {
	private char[] board;
	private final int sizeOfBoard = 9;

	public Board() {
		this.board = new char[this.sizeOfBoard];
		setBoard();
	} 
	
	public Board(char[] b) {
		this.board = b;
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

	public boolean setField(int i, char s) {
		if (i >= 0 && i < 9)
		{
			if (!isFieldEmpty(i))
			{
				return false;
			}
			else
			{
				this.board[i] = s;
				return true;
			}
		}
		else 
		{
			return false;
		}
	}
	
	public boolean isWinner() {
		if (this.board[0] == this.board[1] && this.board[1] == this.board[2])
			return true;
		if (this.board[3] == this.board[4] && this.board[4] == this.board[5])
			return true;
		if (this.board[6] == this.board[7] && this.board[7] == this.board[8])
			return true;
		if (this.board[0] == this.board[4] && this.board[4] == this.board[8])
			return true;
		if (this.board[2] == this.board[4] && this.board[4] == this.board[6])
			return true;
		if (this.board[0] == this.board[3] && this.board[3] == this.board[6])
			return true;
		if (this.board[1] == this.board[4] && this.board[4] == this.board[7])
			return true;
		if (this.board[2] == this.board[5] && this.board[5] == this.board[8])
			return true;
		return false;
	}
	
	public boolean isGameOver() {
		for (int i = 0; i < this.sizeOfBoard; i++)
			if ( ((char)('0' + i)) == this.board[i])
				return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		for (int i = 0; i < this.sizeOfBoard; i++) {
			if (i % 3 == 0)
				result.append(NEW_LINE);
			result.append(" | " + this.board[i] + " | ");
		}
		return result.toString();
	}
}

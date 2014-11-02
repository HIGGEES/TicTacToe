package is.ru.TicTacToe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest {
	/*
	private char[] getEmptyBoard() {
		final char[] b = {'0','1','2','3','4','5','6','7','8'};
		return b;
	}*/
	
	private char[] getWinnerBoard() {
		final char[] b = {	'X','1','2',
				'3','X','5',
				'O','O','X'
		};
		return b;
	}
	
	private char[] getFullBoard() {
		final char[] b = {	'X','O','X',
				'X','O','X',
				'O','X','O'
		};
		return b;
	}

	@Test
	public void boardTest(){
		final Board b = new Board();
		final char[] emptyBoard = {'0','1','2','3','4','5','6','7','8'};
		assertArrayEquals("Wrong board", emptyBoard, b.getBoard());
	}
	
	@Test
	public void isFieldEmptyTest() {
		final Board b = new Board();
		assertTrue("Field is not empty", b.isFieldEmpty(1));
	}
	
	@Test
	public void getFieldTest() {
		final char testIt = (char)('0' + 1);
		final Board b = new Board();
		assertEquals("Fiels not available", b.getField(1), testIt);
	}

	@Test
	public void setFieldTest() {
		final Board b = new Board();
		assertTrue("Field not set", b.setField(1, 'X'));
		//assertEquals(b.getField(1), 'X');
	}



	@Test
	public void isWinnerOnEmptyBoardTest() {
		final Board b = new Board();
		assertFalse("There is a winner", b.isWinner());
	}
	
	@Test
	public void isWinnerOnWinningBoardTest() {
		final Board b = new Board(getWinnerBoard());
		assertTrue("No winner", b.isWinner());
	}

	@Test
	public void isWinnerOnFullBoardTest() {
		final Board b = new Board(getFullBoard());
		assertFalse("No winner", b.isWinner());
	}

	@Test
	public void isGameOverTest() {
		final Board b = new Board();
		assertFalse("Game is not over", b.isGameOver());
	}

	@Test
	public void isGameOverOnFullBoardTest() {
		final Board b = new Board(getFullBoard());
		assertTrue("Game is over", b.isGameOver());
	}
}

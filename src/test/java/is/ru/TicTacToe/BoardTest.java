package is.ru.TicTacToe;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest {
	
	private char[] getEmptyBoard() {
		char[] b = {'0','1','2','3','4','5','6','7','8'};
		return b;
	}
	
	private char[] getWinnerBoard() {
		char[] b = {	'X','1','2',
				'3','X','5',
				'O','O','X'
		};
		return b;
	}
	
	private char[] getFullBoard() {
		char[] b = {	'X','O','X',
				'X','O','X',
				'O','X','O'
		};
		return b;
	}

	@Test
	public void boardTest(){
		Board b = new Board();
		char[] emptyBoard = getEmptyBoard();
		assertArrayEquals(emptyBoard, b.getBoard());
	}
	
	@Test
	public void isFieldEmptyTest() {
		Board b = new Board();
		assertTrue(b.isFieldEmpty(1));
	}
	
	@Test
	public void getFieldTest() {
		char testIt = (char)('0' + 1);
		Board b = new Board();
		assertEquals(b.getField(1), testIt);
	}

	@Test
	public void setFieldTest() {
		Board b = new Board();
		b.setField(1, 'X');
		assertEquals(b.getField(1), 'X');
	}

	@Test
	public void isWinnerOnEmptyBoardTest() {
		Board b = new Board();
		assertFalse(b.isWinner());
	}
	
	@Test
	public void isWinnerOnWinningBoardTest() {
		Board b = new Board(getWinnerBoard());
		assertTrue(b.isWinner());
	}

	@Test
	public void isWinnerOnFullBoardTest() {
		Board b = new Board(getFullBoard());
		assertFalse(b.isWinner());
	}

	@Test
	public void isGameOverTest() {
		Board b = new Board();
		assertFalse(b.isGameOver());
	}

	@Test
	public void isGameOverOnFullBoardTest() {
		Board b = new Board(getFullBoard());
		assertTrue(b.isGameOver());
	}
}

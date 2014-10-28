package is.ru.TicTacToe;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest {
	
	private Board b = new Board();

	private char[] getEmptyBoard() {
		char[] b = {'0','1','2','3','4','5','6','7','8'};
		return b;
	}

	@Test
	public void boardTest(){
		char[] emptyBoard = getEmptyBoard();
		assertArrayEquals(emptyBoard, b.getBoard());
	}
	
	@Test
	public void isFieldEmptyTest() {
		assertTrue(b.isFieldEmpty(1));
	}
	
	@Test
	public void getFieldTest() {
		char testIt = (char)('0'+1);
		assertEquals(this.b.getField(1), testIt);
	}

	@Test
	public void setFieldTest() {
		this.b.setField(1, 'X');
		assertEquals(this.b.getField(1), 'X');
	}

}

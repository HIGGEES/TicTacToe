package is.ru.TicTacToe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class BoardTest {

	@Test
	public void boardTest(){
		Board b = new Board();
		char[] rass = {'-','-','-','-','-','-','-','-','-'};
		assertArrayEquals(rass, b.getBoard());
	}


}

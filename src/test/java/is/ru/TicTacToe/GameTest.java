package is.ru.TicTacToe;

import static org.junit.Assert.*;
import org.junit.Test;

public class GameTest {
	
	@Test
	public void getMovesLeftTest() {
		Game g = new Game();
		assertEquals(g.getMovesLeft(), 9);
	}
}

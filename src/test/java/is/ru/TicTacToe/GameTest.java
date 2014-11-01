package is.ru.TicTacToe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;
//import java.lang.StringBuilder;

public class GameTest {
	
	@Test
	public void getMovesLeftTest() {
		final Game g = new Game();
		assertEquals("Wrong amount of moves left", g.getMovesLeft(), 9);
	}

	@Test
	public void getMovesLeftForResetTest() {
		final Game g = new Game();
		final Board b = new Board();
		final String x = b.toString();
		final String y = g.drawBoard();
		// Potential violation of Law of Demeter (object not created locally) We don't care about that :)
		assertTrue("Board did not reset", g.getMovesLeft() == 9 && y.equals(x));
	}

	@Test
	public void testPlayTurn() {
		final Game g = new Game();
		assertTrue("turn failed", g.playTurn(1));
	}

	@Test
	public void testGameOver() {
		final char[] a = {'0','1','2',
					'3','4','5',
					'6','7','8'
					}; //empty board

		final char[] b = {'X','1','2',
					'3','X','5',
					'O','O','X'
					}; //winner

		final char[] c = {'X','O','X',
					'X','O','X',
					'O','X','O'
					}; //no more moves, no winner

		Board d = new Board(a);
		Game g = new Game(d,9);
		
		final boolean x = g.gameOver();
		d = new Board(b);
		g = new Game(d,4);
		//assertEquals(g.gameOver(),true);
		
		final boolean y = g.gameOver();
		d = new Board(c);
		g = new Game(d,0);
		assertTrue("Game not over", !x && y && g.gameOver());
	}

	@Test
	public void testIsWinner() {

		final char[] a = {'0','1','2',
					'3','4','5',
					'6','7','8'
					}; //empty board

		final char[] b = {'X','1','2',
					'3','X','5',
					'O','O','X'
					}; //winner

		Board d = new Board(a);
		Game g = new Game(d,9);
		
		final boolean x = g.isWinner();
		d = new Board(b);
		g = new Game(d,4);
		assertTrue("There is no winner", !x && g.isWinner());
	}

	@Test
	public void testDrawBoard(){
		final Game g = new Game();
		final StringBuilder result = new StringBuilder();
		final String NEW_LINE = System.getProperty("line.separator");
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0)
			{
				result.append(NEW_LINE);
			}
			result.append(" | " + ((char)('0'+ i)) + " | ");
		}
		assertEquals("Wrong board drawn", g.drawBoard(), result.toString());
	}

	@Test
	public void testGetBoard(){
		final char[] b = {'X','1','2',
			'3','X','5',
			'O','O','X'
			};
		final Board a = new Board(b);
		final Game g = new Game(a,4);
		assertEquals("Board not returned", g.getBoard(),b);
	}
}
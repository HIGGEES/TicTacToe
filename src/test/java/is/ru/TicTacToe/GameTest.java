package is.ru.TicTacToe;

import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.StringBuilder;

public class GameTest {
	
	@Test
	public void getMovesLeftTest() {
		Game g = new Game();
		assertEquals(g.getMovesLeft(), 9);
	}

	@Test
	public void getMovesLeftForResetTest() {
		Game g = new Game();
		assertEquals(g.getMovesLeft(), 9);

		char[] a = {'0','1','2',
					'3','4','5',
					'6','7','8'
					}; //empty board
		Board b = new Board(a);
		assertEquals(g.drawBoard(), b.toString());
	}

	@Test
	public void testPlayTurn() {
		Game g = new Game();
		assertEquals(g.playTurn(1),true);
	}

	@Test
	public void testGameOver() {
		char[] a = {'0','1','2',
					'3','4','5',
					'6','7','8'
					}; //empty board

		char[] b = {'X','1','2',
					'3','X','5',
					'O','O','X'
					}; //winner

		char[] c = {'X','O','X',
					'X','O','X',
					'O','X','O'
					}; //no more moves, no winner

		Board d = new Board(a);
		Game g = new Game(d,9);
		assertEquals(g.gameOver(),false);

		d = new Board(b);
		g = new Game(d,4);
		assertEquals(g.gameOver(),true);

		d = new Board(c);
		g = new Game(d,0);
		assertEquals(g.gameOver(),true);
	}

	@Test
	public void testIsWinner() {

		char[] a = {'0','1','2',
					'3','4','5',
					'6','7','8'
					}; //empty board

		char[] b = {'X','1','2',
					'3','X','5',
					'O','O','X'
					}; //winner

		Board d = new Board(a);
		Game g = new Game(d,9);
		assertEquals(g.isWinner(),false);

		d = new Board(b);
		g = new Game(d,4);
		assertEquals(g.isWinner(),true);
	}

	@Test
	public void testDrawBoard(){
		Game g = new Game();
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0)
			{
				result.append(NEW_LINE);
			}
			result.append(" | " + ((char)('0'+ i)) + " | ");
		}
		assertEquals(g.drawBoard(), result.toString());
	}

	@Test
	public void testGetBoard(){
		char[] b = {'X','1','2',
			'3','X','5',
			'O','O','X'
			};
		Board a = new Board(b);
		Game g = new Game(a,4);
		assertEquals(g.getBoard(),b);
	}
}
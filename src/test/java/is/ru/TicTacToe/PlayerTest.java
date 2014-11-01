package is.ru.TicTacToe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlayerTest{
	
	@Test
	public void getSymbolTest(){
		final Player p = new Player('x');
		assertEquals("Wrong symbol", 'x', p.getSymbol());
	}


}


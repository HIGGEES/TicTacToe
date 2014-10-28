package is.ru.TicTacToe;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest{
	
	@Test
	public void getSymbolTest(){
		Player p = new Player('x');
		assertEquals('x', p.getSymbol());
	}


}


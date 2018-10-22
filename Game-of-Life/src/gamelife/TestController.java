package gamelife;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestController {
	private static Controller cont = new Controller();
	private static Main main = new Main();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetNum() {
		cont.getNum();
		int num = 0,i,j;
		for(i=0;i<17;i++) {
			for(j=0;j<27;j++) {
				if(main.Co.C.cells[i][j]==1)
					num++;
			}
		}
		//assertEquals(60,num);
		assertTrue(num<=60);
	}

	@Test
	public void testSetZero() {
		cont.setZero();
		int num = 0,i,j;
		for(i=0;i<17;i++) {
			for(j=0;j<27;j++) {
				if(main.Co.C.cells[i][j]==1)
					num++;
			}
		}
		assertEquals(0,num);
	}

}

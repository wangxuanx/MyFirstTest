package gamelife;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MainTest {
	private static Main main = new Main();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGrowCell() { 
		int[][] jueNum={{1,0,1},{0,0,0},{1,0,1}};
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				main.Co.C.cells[i][j] = jueNum[i][j];
			}
		}
		
		main.GrowCell();
		
		int num=0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(main.Co.C.cells[i][j]==1)
					num++;
			}
		}
		
		assertEquals(0,num);
	}

}

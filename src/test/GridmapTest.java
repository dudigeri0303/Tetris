package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import main.Gridmap;
//A pálya tesztje
public class GridmapTest {
	//Attribútum
	Gridmap gridmap;
	
	//Setup
	@Before
	public void setup() {
		this.gridmap = new Gridmap();
	}
	
	@Test
	public void gameoverTest() {
		Gridmap testGridmap = this.gridmap;
		assertEquals(false, testGridmap.gameOver());
		testGridmap.getGrids().get(0).get(0).setFree(false);
		assertEquals(true, testGridmap.gameOver());
	}
}

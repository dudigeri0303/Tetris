package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.Grid;
import main.Gridmap;
import main.Ishape;
import main.Lshape;
import main.Shapes;

//Alakzat tesztje
public class ShapesTest {
	//Attribútumok
	Shapes Lshape;
	Shapes Ishape;
	Gridmap gridmap;
	
	@Before
	public void setup() {
		this.Lshape = new Lshape();
		this.Ishape = new Ishape();
		this.gridmap = new Gridmap();
	}
	
	@Test
	public void moveRightTest() {
		Shapes testShape = this.Lshape;
		testShape.moveRight();
		assertEquals(5, testShape.getCenter().getVektor().getX());
		for (int i = 0; i < 2; i++ ) {
			testShape.moveRight();
		}
		assertEquals(7, testShape.getCenter().getVektor().getX());
	}
	
	@Test
	public void moveLeftTest() {
		Shapes testShape = this.Lshape;
		testShape.moveLeft();
		assertEquals(3, testShape.getCenter().getVektor().getX());
		for (int i = 0; i < 2; i++ ) {
			testShape.moveLeft();
		}
		assertEquals(1, testShape.getCenter().getVektor().getX());
	}
	
	@Test
	public void fallTest() {
		Shapes testShape = this.Lshape;
		testShape.fall();
		assertEquals(2, testShape.getCenter().getVektor().getY());
	}
	
	@Test
	public void checkBottomTest() {
		Shapes testShape = this.Ishape;
		for (int i = 0; i < 19; i++) {
			testShape.fall();
		}
		testShape.updateList();
		assertEquals(true, testShape.checkBottom());
	}
	
	@Test
	public void checkRightEdgeTest() {
		Shapes testShape = this.Lshape;
		testShape.setMap(this.gridmap.getGrids());
		for (int i = 0; i < 5; i++ ) {
			testShape.moveRight();
		}
		testShape.updateList();
		assertEquals(true, testShape.checkRightEdged());
	}
	
	@Test
	public void checkLeftEdgeTest() {
		Shapes testShape = this.Ishape;
		testShape.setMap(this.gridmap.getGrids());
		for (int i = 0; i < 4; i++ ) {
			testShape.moveLeft();
		}
		testShape.updateList();
		assertEquals(true, testShape.checkLeftEdged());
	}
	
	@Test
	public void isStackedTest() {
		Gridmap gridmap = this.gridmap;
		Shapes testShape = this.Lshape;
		ArrayList<ArrayList<Grid>> testList = gridmap.getGrids();
		for (int i = 0; i < 2; i++) {
			testShape.fall();
		}
		testShape.moveLeft();
		testShape.updateList();
		assertEquals(false, testShape.isStacked(testList));
	}
}

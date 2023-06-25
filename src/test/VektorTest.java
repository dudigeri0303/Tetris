package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Vektor;

//Vektor tesztje
public class VektorTest {
	//Attribútum
	Vektor vektor;
	
	//Setup
	@Before
	public void setup() {
		this.vektor = new Vektor(1, 1);;
	}

	@Test
	public void vektorAddTest() {
		Vektor testVektor = this.vektor;
		Vektor vektor2 = new Vektor(2, 4);
		assertEquals(3, testVektor.addVektor(vektor2).getX());
		assertEquals(5, testVektor.addVektor(vektor2).getY());
	}
	
	@Test
	public void vektorRotateTest() {
		Vektor testVektor = new Vektor(2, 4);
		testVektor.rotateVektor();
		assertEquals(-4, testVektor.getX());
		assertEquals(2, testVektor.getY());
	}
}

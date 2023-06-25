package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import main.Counter;

//A számláló JUnit tesztje
public class CounterTest {
	//Attribútum
	Counter counter;
	
	//Setup
	@Before
	public void setup() {
		this.counter = new Counter();
	} 
	
	//Az pont novelés tesztelése
	@Test
	public void addTest() {
		Counter tesCounter = this.counter;
		tesCounter.addScore();
		assertEquals(100, tesCounter.getValue());
	}
}

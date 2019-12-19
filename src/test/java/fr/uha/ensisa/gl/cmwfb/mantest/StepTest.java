package fr.uha.ensisa.gl.cmwfb.mantest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StepTest {
	fr.uha.ensisa.gl.cmwfb.mantest.Step sut; 

	@Before
	public void createStep() {
		sut = new fr.uha.ensisa.gl.cmwfb.mantest.Step();
	}
	
	@Test
	public void setText() {
		String msg = "toto";
		sut.setText(msg);
		assertEquals(msg,sut.getText());
	}
	
	@Test
	public void setName() {
		String msg = "toto";
		sut.setName(msg);
		assertEquals(msg,sut.getName());
	}
}

package fr.uha.ensisa.gl.cmwfb.mantest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StepReportTest {
	fr.uha.ensisa.gl.cmwfb.mantest.StepReport sut; 

	@Before
	public void createStepReport() {
		Step s = new Step();
		sut = new fr.uha.ensisa.gl.cmwfb.mantest.StepReport(s,true,"");
	}
	
	@Test
	public void Test1() {
		Step s = new Step();
		sut = new StepReport(s,true,"");
		assertEquals(s,sut.getStep());
	}
	
	@Test
	public void Test2() {
		boolean suc = true;
		assertEquals(suc,sut.isSuccess());
		
	}

	@Test
	public void Test3() {
		String c ="";
		assertEquals(c,sut.getComment());
	}
}

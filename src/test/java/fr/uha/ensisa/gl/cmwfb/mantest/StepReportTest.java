package fr.uha.ensisa.gl.cmwfb.mantest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StepReportTest {
	fr.uha.ensisa.gl.cmwfb.mantest.StepReport sut; 

	@Before
	public void createStepReport() {
		Step s = new Step();
		sut = new fr.uha.ensisa.gl.cmwfb.mantest.StepReport(s,false,"");
	}
	
	@Test
	public void getsetStep() {
		Step s = new Step();
		sut.setStep(s);
		assertEquals(s,sut.getStep());
	}
	
	@Test
	public void setSuccess() {
		boolean suc = true;
		sut.setSuccess(true);
		assertEquals(suc,sut.getSuccess());
		
	}

	@Test
	public void getsetComment() {
		String c = "s";
		sut.setComment("s");
		assertEquals(c,sut.getComment());
	}
	
	

}

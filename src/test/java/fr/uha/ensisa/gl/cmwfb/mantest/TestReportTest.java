package fr.uha.ensisa.gl.cmwfb.mantest;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class TestReportTest {
	
	private fr.uha.ensisa.gl.cmwfb.mantest.TestReport sut;
	private fr.uha.ensisa.gl.cmwfb.mantest.Test test;
	
	@Before	
	public void createTestReport() {
		long i=0;
		test = new fr.uha.ensisa.gl.cmwfb.mantest.Test();
		sut = new fr.uha.ensisa.gl.cmwfb.mantest.TestReport(i,test);
	}
	
	@Test
	public void Test1() {
		assertEquals(test, sut.getTest());
	}
	
	@Test
	public void Test2() {
		Calendar c = null;
		assertEquals(c,sut.getCalendar());
	}
	
	@Test
	public void Test4() {
		long i = 0;
		assertEquals(i, sut.getId());
	}
	
	@Test
	public void Test5() {
		Step step = new Step();
		test.addStep(step);
		boolean result = true;
		String commentaire = "";
		StepReport stepReport = new StepReport(step,result,commentaire);
		sut.addNextStepStepReport(0,result,commentaire);
		StepReport stepReport2 = sut.getStepReports()[0];
		assertEquals(stepReport.getStep(),stepReport2.getStep());
		assertEquals(result,stepReport.isSuccess());
		assertEquals(commentaire,stepReport.getComment());	
	}
		
	}
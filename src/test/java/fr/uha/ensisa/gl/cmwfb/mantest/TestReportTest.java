package fr.uha.ensisa.gl.cmwfb.mantest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

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
		String result = "true";
		String commentaire = "";
		StepReport stepReport = new StepReport(step,result,commentaire);
		sut.addNextStepStepReport(0,result,commentaire);
		StepReport stepReport2 = sut.getStepReports().get(0);
		assertEquals(stepReport.getStep(),stepReport2.getStep());
		assertEquals(result,stepReport.getResult());
		assertEquals(commentaire,stepReport.getComment());	
	}
	
	@Test
	public void Test6() {
		Step step = new Step();
		test.addStep(step);
		String result = "true";
		String commentaire = "";
		StepReport stepReport = new StepReport(step,result,commentaire);
		sut.addNextStepStepReport(0,result,commentaire);
		Step step2 = new Step();
		test.addStep(step2);
		String result2 = "true";
		String commentaire2 = "";
		StepReport stepReport2 = new StepReport(step2,result2,commentaire2);
		sut.addNextStepStepReport(1,result2,commentaire2);
		assertNotNull(sut.compare(stepReport, stepReport2));
		assertNotNull(sut.getStepReport(0));
	}
		
	@Test
	public void Test7() {
		int stepId = 2;
		test.addStep(new Step());
		sut.addNextStepStepReport(0,"","");
		assertEquals(null,sut.getStepReport(stepId));
	}
		
	}
package fr.uha.ensisa.gl.cmwfb.mantest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
	public void getCalendar() {
		Calendar c = null;
		assertEquals(c,sut.getCalendar());
	}
	
	@Test
	public void getId() {
		long i = 0;
		assertEquals(i, sut.getId());
	}
	
	@Test
	public void addNextStepStepReport() {
		Step step = new Step();
		test.addStep(step);
		boolean result = true;
		String commentaire = "";
		StepReport stepReport = new StepReport(step,result,commentaire);
		sut.addNextStepStepReport(0,result,commentaire);
		StepReport stepReport2 = sut.getStepReports().get(0);
		assertEquals(stepReport.getStep(),stepReport2.getStep());
		assertEquals(result,stepReport.getSuccess());
		assertEquals(commentaire,stepReport.getComment());	
	}
	
	@Test
	public void Test6() {
		Step step = new Step();
		test.addStep(step);
		boolean result = true;
		String commentaire = "";
		StepReport stepReport = new StepReport(step,result,commentaire);
		sut.addNextStepStepReport(0,result,commentaire);
		Step step2 = new Step();
		test.addStep(step2);
		boolean result2 = true;
		String commentaire2 = "";
		StepReport stepReport2 = new StepReport(step2,result2,commentaire2);
		sut.addNextStepStepReport(1,result2,commentaire2);
		assertNotNull(sut.getStepReport(0));
	}
		
	@Test
	public void getStepReport() {
		int stepId = 2;
		test.addStep(new Step());
		sut.addNextStepStepReport(0,false,"");
		assertEquals(null,sut.getStepReport(stepId));
	}
	
	@Test
	public void isFinished() { 
		Calendar calendar = new GregorianCalendar(2013,0,31); 
		sut.setCalendar(calendar);
		assertEquals(true,sut.isFinished());
		assertNull(sut.getNextStep());
		sut.setCalendar(null);
		assertEquals(false,sut.isFinished());
	}	
	
	@Test
	public void getNextStep() { 
		Step s = new Step();
		Step s2 = new Step();
		assertNull(sut.getNextStep());
		test.addStep(s);
		assertEquals(s,sut.getNextStep());
		sut.addNextStepStepReport(test.getStepId(s), false, "");
		test.addStep(s2);
		assertEquals(s2,sut.getNextStep());
		sut.addNextStepStepReport(test.getStepId(s2), false, "");
		assertNull(sut.getNextStep());	
	}
	
	
	@Test
	public void next() {
		Step s = new Step();
		test.addStep(s);
		sut.next(false,"");
		assertNotNull(sut.getCalendar());
		assertEquals(false,sut.isSuccess());
	}
	
	@Test
	public void isSuccess() {
		Step s = new Step();
		Step s2 = new Step();
		test.addStep(s);
		test.addStep(s2);
		sut.next(true,"");
		assertNull(sut.isSuccess());
		sut.next(true,"");
		assertEquals(true,sut.isSuccess());
	}
	
}
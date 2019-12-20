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
	public void getTest() {
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
	public void getStepReport() {
		Step step = new Step();
		test.addStep(step);
		boolean result = true;
		String commentaire = "";
		assertNull(sut.getStepReport(1));
		assertNull(sut.getStepReport(0));
		sut.next(result,commentaire);
		assertNotNull(sut.getStepReport(0));
		assertEquals(sut.getStepReports().size(),test.getNumberOfSteps());
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
		Step s3 = new Step();
		assertNull(sut.getNextStep());
		test.addStep(s);
		test.addStep(s2);
		
		assertEquals(s,sut.getNextStep());
		sut.next(true, "");
		assertEquals(s2,sut.getNextStep());
		sut.next(true, "");
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
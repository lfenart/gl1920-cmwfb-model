package fr.uha.ensisa.gl.cmwfb.mantest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestTest {
	fr.uha.ensisa.gl.cmwfb.mantest.Test sut; // System Under Test

	@Before
	public void createTest() {
		sut = new fr.uha.ensisa.gl.cmwfb.mantest.Test();
	}

	@Test
	public void setName() {
		assertNull(sut.getName());
		String name = "A test should have a name";
		sut.setName(name);
		assertEquals(name, sut.getName());
	}
	
	@Test
	public void setId() {
		long id = 1;
		sut.setId(id);
		assertEquals(id, sut.getId());
	}
	
	@Test
	public void addStep() {
		Step step1 = new Step();
		step1.setText("step1");
		sut.addStep(step1);
		assertEquals(1, sut.getSteps().size());
		Step step2 = new Step();
		step2.setText("step2");
		sut.addStep(step2);
		assertEquals(2, sut.getSteps().size());
		assertEquals(step1, sut.getSteps().get(0));
		assertEquals(step2, sut.getSteps().get(1));
	}
	
	@Test
	public void addStepIndex() {
		Step step1 = new Step();
		sut.addStep(step1);
		Step step2 = new Step();
		sut.addStep(0, step2);
		assertEquals(2, sut.getSteps().size());
		assertEquals(step2, sut.getSteps().get(0));
		assertEquals(step1, sut.getSteps().get(1));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void addStepOutOfBounds() {
		Step step = new Step();
		sut.addStep(1, step);
	}
	
	@Test
	public void removeStep() {
		Step step1 = new Step();
		sut.addStep(step1);
		Step step2 = new Step();
		sut.addStep(step2);
		assertEquals(2, sut.getSteps().size());
		sut.removeStep(0);
		assertEquals(1, sut.getSteps().size());
		assertEquals(step2, sut.getSteps().get(0));
	}
	
	@Test
	public void setResult() {
		String result = "result";
		sut.setResult(result);
		assertEquals(result, sut.getResult());
	}
	
}
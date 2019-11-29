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
	public void addAction() {
		String action1 = "action1";
		sut.addAction(action1);
		assertEquals(1, sut.getActions().size());
		String action2 = "action2";
		sut.addAction(action2);
		assertEquals(2, sut.getActions().size());
		assertEquals(action1, sut.getActions().get(0));
		assertEquals(action2, sut.getActions().get(1));
	}
	
	@Test
	public void addActionIndex() {
		String action1 = "action1";
		sut.addAction(action1);
		String action2 = "action2";
		sut.addAction(0, action2);
		assertEquals(2, sut.getActions().size());
		assertEquals(action2, sut.getActions().get(0));
		assertEquals(action1, sut.getActions().get(1));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void addActionOutOfBounds() {
		String action = "action";
		sut.addAction(1, action);
	}
	
	@Test
	public void removeAction() {
		String action1 = "action1";
		sut.addAction(action1);
		String action2 = "action2";
		sut.addAction(action2);
		assertEquals(2, sut.getActions().size());
		sut.removeAction(0);
		assertEquals(1, sut.getActions().size());
		assertEquals(action2, sut.getActions().get(0));
	}
	
	@Test
	public void setResult() {
		String result = "result";
		sut.setResult(result);
		assertEquals(result, sut.getResult());
	}
	
}
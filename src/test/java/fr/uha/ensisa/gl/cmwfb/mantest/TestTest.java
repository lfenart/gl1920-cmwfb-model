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
}
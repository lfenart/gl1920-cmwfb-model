package fr.uha.ensisa.gl.cmwfb.mantest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestBookTest {
	fr.uha.ensisa.gl.cmwfb.mantest.TestBook sut; 
	
	@Before
	public void createTestBook(){
		sut = new fr.uha.ensisa.gl.cmwfb.mantest.TestBook(0,"cahier de test N°1");
	}
	
	@Test
	public void TestBook() {
		TestBook testbook = new TestBook();
		testbook.setId(0);
		testbook.setName("cahier de test N°1");
		assertEquals(testbook.getName(),sut.getName());
		assertEquals(testbook.getId(),sut.getId());
		assertEquals(testbook.getTestList(),sut.getTestList());
		assertEquals(testbook.getTestSerieList(),sut.getTestList());
	}
	
	@Test
	public void TestBookId() {
		sut.setId(1);
		assertEquals(1,sut.getId());
	}
	
	@Test
	public void TestBookName() {
		sut.setName("toto");
		assertEquals("toto",sut.getName());
	}
	
	@Test
	public void Test() {
		fr.uha.ensisa.gl.cmwfb.mantest.Test t = new fr.uha.ensisa.gl.cmwfb.mantest.Test();
		sut.addTest(t);
		assertEquals(0,sut.getTestId(t));
		assertEquals(t,sut.getTest(0));
		assertEquals(t,sut.getTestList().get(0));
		assertEquals(1,sut.getNumberOfTests());
		sut.remove(t);
		assertEquals(0,sut.getNumberOfTests());
	}
	
	@Test
	public void Serie() {
		fr.uha.ensisa.gl.cmwfb.mantest.TestSerie t = new fr.uha.ensisa.gl.cmwfb.mantest.TestSerie(0,"Serie de test 1");
		sut.addTestSerie(t);
		assertEquals(0,sut.getTestSerieId(t));
		assertEquals(t,sut.getTestSerie(0));
		assertEquals(t,sut.getTestSerieList().get(0));
		assertEquals(1,sut.getNumberOfTestSeries());
		sut.remove(t);
		assertEquals(0,sut.getNumberOfTestSeries());
	}
}

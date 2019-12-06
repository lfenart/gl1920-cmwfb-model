package fr.uha.ensisa.gl.cmwfb.mantest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import fr.uha.ensisa.gl.cmwfb.mantest.TestSerie;

public class TestSerieTest {

	private TestSerie sut;
	
	@Before
	public void prepare() {
		this.sut = new TestSerie(1234L, "name");
	}

	@Test
	public void testConstructor() {
		assertEquals(this.sut.getId(), 1234L);
		assertEquals(this.sut.getName(), "name");
	}
	
	@Test
	public void testTest() {
		fr.uha.ensisa.gl.cmwfb.mantest.Test test = mock(fr.uha.ensisa.gl.cmwfb.mantest.Test.class);
		
		assertEquals(this.sut.getTests().length, 0);
		assertEquals(this.sut.getTestSeries().length, 0);
		
		this.sut.add(test);
		
		assertEquals(this.sut.getTests().length, 1);
		assertEquals(this.sut.getTests()[0], test);
		assertEquals(this.sut.getTestSeries().length, 0);
	}
	
	@Test
	public void testDoubleTest() {
		fr.uha.ensisa.gl.cmwfb.mantest.Test test = mock(fr.uha.ensisa.gl.cmwfb.mantest.Test.class);
		this.sut.add(test);
		this.sut.add(test);
		
		assertEquals(this.sut.getTests().length, 1);
		assertEquals(this.sut.getTests()[0], test);
	}
	
	@Test
	public void testSeriesTest() {
		TestSerie testSerie = mock(TestSerie.class);
		
		assertEquals(this.sut.getTests().length, 0);
		assertEquals(this.sut.getTestSeries().length, 0);
		
		this.sut.add(testSerie);

		assertEquals(this.sut.getTests().length, 0);
		assertEquals(this.sut.getTestSeries().length, 1);
		assertEquals(this.sut.getTestSeries()[0], testSerie);
	}
	
	@Test
	public void testSeriesDoubleTest() {
		TestSerie testSerie = mock(TestSerie.class);

		this.sut.add(testSerie);
		this.sut.add(testSerie);

		assertEquals(this.sut.getTestSeries().length, 1);
		assertEquals(this.sut.getTestSeries()[0], testSerie);
	}
}
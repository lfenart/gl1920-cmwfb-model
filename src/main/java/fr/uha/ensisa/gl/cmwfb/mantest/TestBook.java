package fr.uha.ensisa.gl.cmwfb.mantest;

import java.util.ArrayList;
import java.util.List;

public class TestBook {
	
	private long id;
	private String name;
	private  List<Test> tests; 
	private  List<TestSerie> testSeries; 
	
	public TestBook() {
		this.name="";
		this.tests = new ArrayList<Test>();
		this.testSeries = new ArrayList<TestSerie>();
	}
	
	public TestBook(long id, String name) {
		this.id = id;
		this.name = name;
		this.tests = new ArrayList<Test>();
		this.testSeries = new ArrayList<TestSerie>();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Test> getTestList(){
		return this.tests;
	}
	
	public Test getTest(int testId) {
		return this.tests.get(testId);
	}
	
	public int getTestId(Test test) {
		return this.tests.indexOf(test);
	}
	
	public void addTest(Test test) {
		this.tests.add(test);
	}
	
	public void remove(Test test) {
		this.tests.remove((int)test.getId());
	}
	
	public int getNumberOfTests() {
		return this.tests.size();
	}

	public List<TestSerie> getTestSerieList(){
		return this.testSeries;
	}
	
	public TestSerie getTestSerie(int testSerieId) {
		return this.testSeries.get(testSerieId);
	}
	
	public int getTestSerieId(TestSerie testSerie) {
		return this.testSeries.indexOf(testSerie);
		}
	
	public void addTestSerie(TestSerie testSerie) {
		this.testSeries.add(testSerie);
	}
	
	public void remove(TestSerie testSerie) {
		this.testSeries.remove(testSerie);
	}
	
	public int getNumberOfTestSeries() {
		return this.testSeries.size();
	}	
	
	public Test getTest2(int testId) {
		return this.tests.get(testId);
	}

}
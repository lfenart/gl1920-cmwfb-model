package fr.uha.ensisa.gl.cmwfb.mantest;

import java.util.ArrayList;
import java.util.List;


public class TestSerie {
	
	private final long id;
	private final String name;
	private final List<TestSerie> testSeries;
	private final List<Test> tests;
	
	public TestSerie(long id, String name) {
		this.id = id;
		this.name = name;
		this.testSeries = new ArrayList<TestSerie>();
		this.tests = new ArrayList<Test>();
	}
	
	public String getName() {
		return this.name;
	}
	
	/**
	 * Retourne la liste des suites de tests dans cette suite de tests
	 * @return
	 */
	public TestSerie[] getTestSeries() {
		return this.testSeries.toArray(new TestSerie[0]);
	}
	
	/**
	 * Retourne la liste des tests dans cette suite de tests
	 */
	public Test[] getTests() {
		return this.tests.toArray(new Test[0]);
	}
	
	public long getId() {
		return this.id;
	}
	
	/**
	 * Ajoute un nouveau test à la suite de tests
	 * @param test
	 */
	public void add(Test test) {
		if(!this.tests.contains(test))
			this.tests.add(test);
	}
	
	/**
	 * Ajout une nouvelle suite de tests à la suite de tests
	 * @param testSerie
	 */
	public void add(TestSerie testSerie) {
		if(!this.testSeries.contains(testSerie))
			this.testSeries.add(testSerie);
	}
	
	public void removeSerie(TestSerie testSerie) {
		this.testSeries.remove(testSerie);
	}
	
	public void remove(Test test) {
		this.tests.remove(test);
	}
}

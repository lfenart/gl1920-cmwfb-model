package fr.uha.ensisa.gl.cmwfb.mantest;

import java.util.ArrayList;
import java.util.List;

public class Test {

	private long id;
	private String name;
	private List<Step> steps;
	private String result;
	
	public Test() {
		this.steps = new ArrayList<Step>();
		this.result = "";
	}

	public long getId() {
		return this.id;
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
	
	public List<Step> getSteps() {
		return this.steps;
	}
	
	public Step getStep(int index) {
		return this.steps.get(index);
	}
	
	public void addStep(Step step) {
		this.steps.add(step);
	}
	
	public void addStep(int index, Step step) {
		this.steps.add(index, step);
	}
	
	public void removeStep(int index) {
		this.steps.remove(index);
	}
	
	public String getResult() {
		return this.result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}

}

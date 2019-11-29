package fr.uha.ensisa.gl.cmwfb.mantest;

import java.util.ArrayList;
import java.util.List;

public class Test {

	private long id;
	private String name;
	private List<String> actions;
	private String result;
	
	public Test() {
		this.actions = new ArrayList<String>();
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
	
	public List<String> getActions() {
		return this.actions;
	}
	
	public void addAction(String action) {
		this.actions.add(action);
	}
	
	public void addAction(int index, String action) {
		this.actions.add(index, action);
	}
	
	public void removeAction(int index) {
		this.actions.remove(index);
	}
	
	public String getResult() {
		return this.result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}

}

package fr.uha.ensisa.gl.cmwfb.mantest;

public class Step {
	private String name;
	private String text;
	
	public Step() {
		this.name = "";
		this.text = "";
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
	
}

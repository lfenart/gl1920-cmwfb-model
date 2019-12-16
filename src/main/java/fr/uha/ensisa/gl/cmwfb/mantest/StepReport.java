package fr.uha.ensisa.gl.cmwfb.mantest;

public class StepReport {
	private Step step;
	private String result;
	private String comment;
	
	public StepReport(Step step, String success, String comment) {
		this.step = step;
		this.result = success;
		this.comment = comment;
	}

	public Step getStep() {
		return this.step;
	}
	
	public void setStep(Step step) {
		this.step = step;
	}
	
	public String getResult() {
		return this.result;
	}
	
	public void setResult(String success){
		this.result=success;
	}
	
	public String getComment() {
		return this.comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}

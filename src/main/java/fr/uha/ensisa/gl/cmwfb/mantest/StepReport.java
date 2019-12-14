package fr.uha.ensisa.gl.cmwfb.mantest;

public class StepReport {
	private Step step;
	private boolean success;
	private String comment;
	
	public StepReport(Step step, boolean success, String comment) {
		this.step = step;
		this.success = success;
		this.comment = comment;
	}

	public Step getStep() {
		return this.step;
	}
	
	public void setStep(Step step) {
		this.step = step;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	
	public void setSuccess(boolean success){
		this.success=success;
	}
	
	public String getComment() {
		return this.comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}

package fr.uha.ensisa.gl.cmwfb.mantest;

public class StepReport {
	private final Step step;
	private final boolean success;
	private final String comment;
	
	public StepReport(Step step, boolean success, String comment) {
		this.step = step;
		this.success = success;
		this.comment = comment;
	}

	public Step getStep() {
		return this.step;
	}
	
	public final boolean isSuccess() {
		return this.success;
	}
	
	public final String getComment() {
		return this.comment;
	}
	
	
}

package fr.uha.ensisa.gl.cmwfb.mantest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fr.uha.ensisa.gl.cmwfb.mantest.Step;
import fr.uha.ensisa.gl.cmwfb.mantest.StepReport;

public class TestReport {

	private final long id;
	private final Test test;
	private final	List<StepReport> stepReports;
	private Calendar calendar = null;
	
	public TestReport(long id, Test test) {
		this.id = id;
		this.test = test;
		this.stepReports = new ArrayList<StepReport>();
	}
	
	public long getId() {
		return this.id;
	}
	
	public Calendar getCalendar() {
		return this.calendar;
	}
	
	public void setCalendar(Calendar c) {
		this.calendar=c;
	}
	
	public Test getTest() {
		return this.test;
	}
	
	public StepReport getStepReport(int stepId) {
		if (stepId >= this.stepReports.size() ) return null; 
		return this.stepReports.get(stepId);
	}

	//retourner la liste des StepsReports, classés par ordre des Steps
	public List<StepReport> getStepReports() {
		return this.stepReports;
	}
	
	public boolean isFinished() {
		return this.calendar != null;
	}
	
	public Step getNextStep() {
		if(this.isFinished() )
			return null;
		
		Step st = null;
		for(Step s : this.test.getSteps()) {			
			if(! this.containsStep(s)) {
				st=s;
				break;	
			}
		}
		return st;
	}
	
	public boolean containsStep(Step step) {
		boolean result = false;
		
		for(int i=0;i<this.stepReports.size();i++) {
			if( step == this.stepReports.get(i).getStep()) {
				result=true;
			}
		}
		
		return result;
	}
	
	
	public void next(boolean success, String comment) {
		Step s = this.getNextStep();
		this.stepReports.add(new StepReport(s,success,comment));
		if(!success || this.stepReports.size() == this.getTest().getNumberOfSteps()) {
			this.calendar = Calendar.getInstance();
		}
	}
	
	public Boolean isSuccess() {
		if(!this.isFinished()) return null;
		
		for(int i=0; i<this.stepReports.size();i++) {
			for(Step s : this.test.getSteps()) {
				if(s==this.stepReports.get(i).getStep()) {
					if(! this.stepReports.get(i).getSuccess()) {
						return false;
					}
				}	
			}
		}		
		return true;
	}

}
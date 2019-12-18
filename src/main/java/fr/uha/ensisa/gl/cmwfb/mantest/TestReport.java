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
	
	public void addNextStepStepReport(int stepId, boolean success, String comment) {
		Step s = this.test.getStep(stepId);
		this.stepReports.add(new StepReport(s,success,comment));
	}
	

	//retourner la liste des StepsReports, classés par ordre des Steps
	public List<StepReport> getStepReports() {
		return this.stepReports;
	}
	
	public boolean isFinished() {
		return this.calendar != null;
	}
	
	public Step getNextStep() {
		if(this.isFinished())
			return null;
		int i=0;
		Step st = null;
		for(Step s : this.test.getSteps()) {
			st =s;
			
			while( i<this.stepReports.size()) {
				if( s != this.stepReports.get(i).getStep()) {
					st = s;
					break;
				}
				i++;
			}
		}
		if (this.test.getNumberOfSteps()==i) st = null;
		return st;
	}
	
	
	public void next(boolean result, String commentaire) {
		Step s = this.getNextStep();
		this.addNextStepStepReport(this.test.getStepId(s),result,commentaire);
		if(!result || this.stepReports.size() == this.getTest().getNumberOfSteps()) {
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
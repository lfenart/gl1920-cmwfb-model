package fr.uha.ensisa.gl.cmwfb.mantest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class TestReport implements Comparator<StepReport> {

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

	@Override
	public int compare(StepReport o1, StepReport o2) {
		return test.getStepId(o2.getStep()) - test.getStepId(o1.getStep());
	}
}
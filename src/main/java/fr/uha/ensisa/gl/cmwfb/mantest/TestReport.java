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
		if(test.getStep(stepId)==null)
			return null;
		StepReport stepResult=null;
		for(StepReport stepReport : this.stepReports) {
			if(stepReport.getStep()==this.test.getStep(stepId)) {
				stepResult = stepReport;
			}
		}
		return stepResult;
	}
	
	public void addNextStepStepReport(int stepId, boolean result, String comment) {
		Step s = this.test.getStep(stepId);
		this.stepReports.add(new StepReport(s,result,comment));
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
	//retourner la prochaine étape à effectuer
/*	public Step getNextStep() {
		if(this.isFinished())
			return null;
		
		Step st = null;
		for(Step s : this.test.getSteps()) {
			if(! this.steps.containsKey(s)) {
				st = s;
				break;
			}
		}
		return st;
	}
	
	/**
	 * Effectue l'étape à effectuer
	 * @param result
	 * @param commentaire
	 */
	/*/public void next(boolean result, String comment) {
		Step s = this.getNextStep();
		this.steps.put(s, new StepReport(s, result, comment));
		if(!result || this.steps.size() == this.getTest().getNumberOfSteps()) {
			this.calendar = Calendar.getInstance();
		}
	}
	
	/**
	 * Retourne si le Rapport est complet
	 * @return
	 */
/*	public boolean isFinished() {
		return this.calendar != null;
	}
	
	/**
	 * Retourne si le Rapport a été effectué avec succès, null s'il n'est pas encore terminé
	 * @return
	 */
/*	public Boolean isSuccess() {
		if(!this.isFinished()) return null;
		
		for(Step s : this.steps.keySet()) {
			if(! this.steps.get(s).isSuccess())
				return false;
		}
		
		return true;
	}
	
	
	
}*/

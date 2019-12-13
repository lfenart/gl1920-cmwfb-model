package fr.uha.ensisa.gl.cmwfb.mantest;

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
	private final Map<Step, StepReport> steps;
	private Calendar calendar = null;
	
	public TestReport(long id, Test test) {
		this.id = id;
		this.test = test;
		this.steps = new HashMap<Step, StepReport>();
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
	

	public void addNextStepStepReport(int stepId, boolean result, String comment) {
		Step s = this.test.getStep(stepId);
		this.steps.put(s,new StepReport(s,result,comment));
	}
	

	//retourner la liste des StepsReports, classés par ordre des Steps
	public StepReport[] getStepReports() {
		StepReport[] ret = this.steps.values().toArray(new StepReport[0]);
		Arrays.sort(ret, this);
		return ret;
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

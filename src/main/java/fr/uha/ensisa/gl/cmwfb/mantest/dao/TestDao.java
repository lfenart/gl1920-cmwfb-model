package fr.uha.ensisa.gl.cmwfb.mantest.dao;

import java.util.Collection;
import fr.uha.ensisa.gl.cmwfb.mantest.Test;

public interface TestDao {
	public void persist(Test test);

	public void remove(Test test);

	public Test find(long id);

	public Collection<Test> findAll();

	public long count();
	
	public Test modifyName(long testId, String newTestName);
	
	public Test modifyStep(long testId, int stepId, String newStep);
}

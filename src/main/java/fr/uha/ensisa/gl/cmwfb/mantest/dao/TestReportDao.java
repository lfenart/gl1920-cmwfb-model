package fr.uha.ensisa.gl.cmwfb.mantest.dao;

import java.util.Collection;
import java.util.Map;

import fr.uha.ensisa.gl.cmwfb.mantest.Test;
import fr.uha.ensisa.gl.cmwfb.mantest.TestReport;

public interface TestReportDao {
	
	//retourner le test identifié
	public TestReport find(long id);
	
	//Créer dans la DAO un rapport de test pour le test demandé et le retourne
	public TestReport create(Test t);
	
	public void remove(TestReport testReport);
	//public long getNextId();

	public long count() ;

	public Map<Long, TestReport> findAll();
}

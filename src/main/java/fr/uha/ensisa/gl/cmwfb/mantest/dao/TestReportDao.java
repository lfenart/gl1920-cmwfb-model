package fr.uha.ensisa.gl.cmwfb.mantest.dao;

import fr.uha.ensisa.gl.cmwfb.mantest.Test;
import fr.uha.ensisa.gl.cmwfb.mantest.TestReport;

public interface TestReportDao {
	
	//retourner le test identifi�
	public TestReport find(long id);
	
	//Cr�er dans la DAO un rapport de test pour le test demand� et le retourne
	public TestReport create(Test t);
	
	public void remove(TestReport testReport);
	//public long getNextId();

	public long count() ;
}

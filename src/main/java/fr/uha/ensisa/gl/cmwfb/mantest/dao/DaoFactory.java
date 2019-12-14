package fr.uha.ensisa.gl.cmwfb.mantest.dao;

import fr.uha.ensisa.gl.cmwfb.mantest.dao.TestSerieDao;

public interface DaoFactory {
	public TestDao getTestDao();
	
	public TestSerieDao getTestSerieDao();
}

package fr.uha.ensisa.gl.cmwfb.mantest.dao;

public interface DaoFactory {
	public TestDao getTestDao();
	public TestReportDao getTestReportDao();
	public TestSerieDao getTestSerieDao();
	public TestBookDao getTestBookDao();
}

package fr.uha.ensisa.gl.cmwfb.mantest.dao;

import fr.uha.ensisa.gl.cmwfb.mantest.TestSerie;

public interface TestSerieDao {
	public TestSerie find(long id);
	public void persist(TestSerie test);
	public TestSerie create(String nom);
	public TestSerie[] findAll();
}

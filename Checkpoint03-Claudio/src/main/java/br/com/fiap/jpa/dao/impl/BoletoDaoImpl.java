package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Boleto;

public class BoletoDaoImpl extends HibernateGenericDao<Boleto, Long>{

	private static BoletoDaoImpl instance = null;
	
	public static BoletoDaoImpl getInstance() {
		if (instance == null) {
			instance = new BoletoDaoImpl();
		}
		
		return instance;
	}
	
	private BoletoDaoImpl() {
		super(Boleto.class);
	}
}

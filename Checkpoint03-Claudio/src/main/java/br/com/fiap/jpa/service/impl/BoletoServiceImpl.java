package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.BoletoDaoImpl;
import br.com.fiap.jpa.entity.Boleto;
import br.com.fiap.jpa.service.GenericService;

public class BoletoServiceImpl extends GenericService<Boleto, Long>{

	private static BoletoServiceImpl instance = null;
	
	private BoletoDaoImpl boletoDao;
	
	private BoletoServiceImpl() {
		boletoDao = BoletoDaoImpl.getInstance();
	}
	
	public static BoletoServiceImpl getInstance() {
		if (instance == null) {
			instance = new BoletoServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void cadastrar(Boleto instance) {
		try {
			boletoDao.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}				
	}

	@Override
	public void atualizar(Boleto instance) {
		try {
			boletoDao.atualizar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}				
	}

	@Override
	public void remover(Long id) {
		try {
			boletoDao.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}				
	}

	@Override
	public Boleto obter(Long id) {
		Boleto Boleto = null;
		
		try {
			Boleto = boletoDao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return Boleto;
	}

	@Override
	public List<Boleto> listar() {
		List<Boleto> Boletos = null;
		
		try {
			Boletos = boletoDao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return Boletos;
	}
}

package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.PedidoDaoImpl;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.service.GenericService;

public class PedidoServiceImpl extends GenericService<Pedido, Long>{

	private static PedidoServiceImpl instance = null;
	
	private PedidoDaoImpl pedidoDao;
	
	private PedidoServiceImpl() {
		pedidoDao = PedidoDaoImpl.getInstance();
	}
	
	public static PedidoServiceImpl getInstance() {
		if (instance == null) {
			instance = new PedidoServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void cadastrar(Pedido instance) {
		try {
			pedidoDao.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}				
	}

	@Override
	public void atualizar(Pedido instance) {
		try {
			pedidoDao.atualizar(instance, getEntityManager());
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
			pedidoDao.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}				
	}

	@Override
	public Pedido obter(Long id) {
		Pedido pedido = null;
		
		try {
			pedido = pedidoDao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return pedido;
	}

	@Override
	public List<Pedido> listar() {
		List<Pedido> pedidos = null;
		
		try {
			pedidos = pedidoDao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return pedidos;
	}
	
	public List<Pedido> listarPorCpf(String cpf) {
		List<Pedido> pedidos = null;
		
		try {
			pedidos = pedidoDao.listaPorCpf(cpf, getEntityManager());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeEntityManager();
		}
		
		return pedidos;
	}
	
	public List<Pedido> listarPedidosComBoleto() {
		List<Pedido> pedidos = null;
		
		try {
			pedidos = pedidoDao.listarPedidosComBoleto(getEntityManager());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeEntityManager();
		}
		
		return pedidos;
	}

}

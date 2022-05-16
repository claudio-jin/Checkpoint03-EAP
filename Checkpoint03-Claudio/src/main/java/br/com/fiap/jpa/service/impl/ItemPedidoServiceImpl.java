package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.ItemPedidoDaoImpl;
import br.com.fiap.jpa.entity.ItemPedido;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.service.GenericService;

public class ItemPedidoServiceImpl extends GenericService<ItemPedido, Long>{

private static ItemPedidoServiceImpl instance = null;
	
	private ItemPedidoDaoImpl itemPedidoDao;
	
	private ItemPedidoServiceImpl() {
		itemPedidoDao = ItemPedidoDaoImpl.getInstance();
	}
	
	public static ItemPedidoServiceImpl getInstance() {
		if (instance == null) {
			instance = new ItemPedidoServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void cadastrar(ItemPedido instance) {
		try {
			itemPedidoDao.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}				
	}

	@Override
	public void atualizar(ItemPedido instance) {
		try {
			itemPedidoDao.atualizar(instance, getEntityManager());
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
			itemPedidoDao.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}				
	}

	@Override
	public ItemPedido obter(Long id) {
		ItemPedido ItemPedido = null;
		
		try {
			ItemPedido = itemPedidoDao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return ItemPedido;
	}

	@Override
	public List<ItemPedido> listar() {
		List<ItemPedido> ItemPedidos = null;
		
		try {
			ItemPedidos = itemPedidoDao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return ItemPedidos;
	}
	
	
}

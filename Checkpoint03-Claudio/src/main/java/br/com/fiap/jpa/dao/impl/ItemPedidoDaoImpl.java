package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.ItemPedido;

public class ItemPedidoDaoImpl extends HibernateGenericDao<ItemPedido, Long>{

	private static ItemPedidoDaoImpl instance = null;
	
	public static ItemPedidoDaoImpl getInstance() {
		if (instance == null) {
			instance = new ItemPedidoDaoImpl();
		}
		
		return instance;
	}
	
	private ItemPedidoDaoImpl() {
		super(ItemPedido.class);
	}
	
	
	
}

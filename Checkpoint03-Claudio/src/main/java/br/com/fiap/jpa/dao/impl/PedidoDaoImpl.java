package br.com.fiap.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import br.com.fiap.jpa.entity.Boleto;
import br.com.fiap.jpa.entity.Pedido;

public class PedidoDaoImpl extends HibernateGenericDao<Pedido, Long>{

	private static PedidoDaoImpl instance = null;
	
	public static PedidoDaoImpl getInstance() {
		if (instance == null) {
			instance = new PedidoDaoImpl();
		}
		
		return instance;
	}
	
	private PedidoDaoImpl() {
		super(Pedido.class);
	}
	
	public List<Pedido> listaPorCpf(String cpf, EntityManager entityManager) {
		String jpql = "SELECT p FROM Pedido p WHERE p.cpf = :cpf";
		
		TypedQuery<Pedido> consulta = entityManager.createQuery(jpql, Pedido.class);
		consulta.setParameter("cpf", cpf);
		
		return consulta.getResultList();
				
	}
	
	public List<Pedido> listarPedidosComBoleto(EntityManager entityManager) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Pedido> criteriaQuery = builder.createQuery(Pedido.class);
		Root<Pedido> pedido = criteriaQuery.from(Pedido.class);
		
		Join<Pedido, Boleto> boleto = (Join) pedido.fetch("boleto");
		
		criteriaQuery.select(pedido);
		TypedQuery<Pedido> consulta = entityManager.createQuery(criteriaQuery);
		return consulta.getResultList();
		
		
	}
}

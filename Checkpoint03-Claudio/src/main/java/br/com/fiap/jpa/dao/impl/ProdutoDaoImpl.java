package br.com.fiap.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.fiap.jpa.entity.Produto;

public class ProdutoDaoImpl extends HibernateGenericDao<Produto, Long>{
	
	private static ProdutoDaoImpl instance = null;
	
	public static ProdutoDaoImpl getInstance() {
		if (instance == null) {
			instance = new ProdutoDaoImpl();
		}
		
		return instance;
	}
	
	private ProdutoDaoImpl() {
		super(Produto.class);
	}
	
	public List<Produto> listarValorMaior(Double valor, EntityManager entityManager) {
		TypedQuery<Produto> consulta = entityManager.createNamedQuery("Produto.listarValorMaior", Produto.class);
		
		consulta.setParameter("valor", valor);
		return consulta.getResultList();
	}
	
	public List<Produto> listarPorNome(String nome, EntityManager entityManager) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Produto> criteriaQuery = builder.createQuery(Produto.class);
		
		Root<Produto> produto = criteriaQuery.from(Produto.class);
		
		Predicate predicate = builder.like(
				builder.lower(produto.get("nome")), "%" + nome.toLowerCase() + "%");
		
		criteriaQuery.select(produto);
		criteriaQuery.where(predicate);
		
		TypedQuery<Produto> consulta = entityManager.createQuery(criteriaQuery);
		
		return consulta.getResultList();
	}
	
	public List<Produto> listarPorValor(Double valor, EntityManager entityManager) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Produto> criteriaQuery = builder.createQuery(Produto.class);
		
		Root<Produto> produto = criteriaQuery.from(Produto.class);
		
		Predicate predicate = builder.equal(produto.get("valor"), valor);
		
		criteriaQuery.select(produto);
		criteriaQuery.where(predicate);
		
		TypedQuery<Produto> consulta = entityManager.createQuery(criteriaQuery);
		
		return consulta.getResultList();
	}
}

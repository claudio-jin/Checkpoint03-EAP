package br.com.fiap.jpa.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.jpa.dao.GenericDAO;

public abstract class HibernateGenericDao<T extends Serializable, PK extends Serializable> implements GenericDAO<T, PK> {

	private Class<T> type;
	
	public Class<T> getType() {
		return type;
	}

	public HibernateGenericDao(Class<T> type) {
		this.type = type;
	}
	

	public void salvar(T instancia, EntityManager entityManager) {
		entityManager.persist(instancia);
		
	}

	public void atualizar(T instancia, EntityManager entityManager) {
		entityManager.merge(instancia);
		
	}

	public void remover(PK id, EntityManager entityManager) {
		T instancia = this.obterPorId(id, entityManager);
		entityManager.remove(instancia);
	}

	public T obterPorId(PK id, EntityManager entityManager) {
		
		return entityManager.find(type, id);
	}

	public List<T> listar(EntityManager entityManager) {
		String className = type.getName();
		TypedQuery<T> consulta = entityManager.createQuery("SELECT o FROM " + className + " o", this.getType());
		
		return consulta.getResultList();
	}
}

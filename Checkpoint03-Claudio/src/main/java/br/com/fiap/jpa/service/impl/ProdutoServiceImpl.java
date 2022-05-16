package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.ProdutoDaoImpl;
import br.com.fiap.jpa.entity.Produto;
import br.com.fiap.jpa.service.GenericService;

public class ProdutoServiceImpl extends GenericService<Produto, Long>{

	private static ProdutoServiceImpl instance = null;
	
	private ProdutoDaoImpl produtoDao;
	
	private ProdutoServiceImpl() {
		produtoDao = ProdutoDaoImpl.getInstance();
	}
	
	public static ProdutoServiceImpl getInstance() {
		if (instance == null) {
			instance = new ProdutoServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void cadastrar(Produto instance) {
		try {
			produtoDao.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}		
	}

	@Override
	public void atualizar(Produto instance) {
		try {
			produtoDao.atualizar(instance, getEntityManager());
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
			produtoDao.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}		
	}

	@Override
	public Produto obter(Long id) {
		Produto produto = null;
		
		try {
			produto = produtoDao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return produto;
	}

	@Override
	public List<Produto> listar() {
		List<Produto> produtos = null;
		
		try {
			produtos = produtoDao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return produtos;
	}
	
	public List<Produto> listarValorMaior(Double valor) {
		List<Produto> produtos = null;
		
		try {
			produtos = produtoDao.listarValorMaior(valor, getEntityManager());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeEntityManager();
		}
		
		return produtos;
	}
	
	public List<Produto> listarPorNome(String nome) {
		List<Produto> produtos = null;
		
		try {
			produtos = produtoDao.listarPorNome(nome, getEntityManager());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeEntityManager();
		}
		
		return produtos;
 	}
	
	public List<Produto> listarPorValor(Double valor) {
		List<Produto> produtos = null;
		
		try {
			produtos = produtoDao.listarPorValor(valor, getEntityManager());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeEntityManager();
		}
		
		return produtos;
 	}

}

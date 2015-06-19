package br.com.financas.conta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class ContaDao {

	private EntityManager manager;

	public ContaDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public void salva(Conta conta) {
		manager.persist(conta);
	}

	public Conta buscaPorId(Long id) {
		return manager.find(Conta.class, id);
	}
	
	public void exclui(Conta conta) {
		manager.remove(conta);
	}

	public List<Conta> lista() {
		String sql = "select c from Conta";
		TypedQuery<Conta> query = manager.createQuery(sql, Conta.class);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Conta> listaComWarning() {
		String sql = "select c from Conta";
		Query query = manager.createQuery(sql);
		return query.getResultList();			
	}
}

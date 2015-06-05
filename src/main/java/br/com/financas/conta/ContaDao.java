package br.com.financas.conta;

import javax.persistence.EntityManager;

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
	
}

package br.com.financas.movimentacao;

import javax.persistence.EntityManager;

public class MovimentacaoDao {

	private EntityManager manager;

	public MovimentacaoDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public void salva(Movimentacao movimentacao) {
		manager.persist(movimentacao);
	}

	public Movimentacao buscaPorId(Long id) {
		return manager.find(Movimentacao.class, id);
	}
	
}

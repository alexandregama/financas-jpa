package br.com.financas.movimentacao;

import javax.persistence.PrePersist;

public class MovimentacaoListener {

	@PrePersist
	public void prePersist(Object instancia) {
		System.out.println("Avisa ao financeiro sobre uma nova Movimentacao");
	}
	
}

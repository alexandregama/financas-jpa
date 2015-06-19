package br.com.financas.movimentacao;

import javax.persistence.PrePersist;

public class ContaListener {

	@PrePersist
	public void prePersist(Object instancia) {
		System.out.println("Avisao ao contratual sobre a nova conta criada");
	}
	
}

package br.com.financas.movimentacao;

import javax.persistence.PrePersist;

public class MovimentacaoListener {

	@PrePersist
	public void prePersist(Object instancia) {
		System.out.println("Avisa ao financeiro sobre uma nova Movimentacao");
	}
	
//	@PrePersist Nao funciona pois só podemos anotar com um tipo de Callback pra a Entity
	public void prePersist2(Object instancia) {
		System.out.println("Avisa ao contratual sobre uma nova Movimentacao");
	}
	
}

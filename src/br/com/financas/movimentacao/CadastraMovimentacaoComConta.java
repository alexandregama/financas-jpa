package br.com.financas.movimentacao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.financas.conta.Conta;
import br.com.financas.infra.JPAUtil;

public class CadastraMovimentacaoComConta {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta bradesco = new Conta("Antonio", "Santander", "19874", "14748-9");
		
		Movimentacao movimentacao = new Movimentacao("Academia", bradesco, new BigDecimal("150"), TipoMovimentacao.SAIDA);
		
//		Precisamos persistir a conta também. Podemos também usar cascade = CascadeType.PERSIST no relacionamento
		manager.persist(bradesco);
		manager.persist(movimentacao);
		
		manager.getTransaction().commit();
		manager.close();
	}
	
}

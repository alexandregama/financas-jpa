package br.com.financas.estados;

import javax.persistence.EntityManager;

import br.com.financas.conta.Conta;
import br.com.financas.infra.JPAUtil;

public class TestaEstadoComMergeETransient {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		Conta conta = new Conta("Lima", "Bradesco", "11111", "55555-5");
		conta.setId(2l);
		Conta contaManaged = manager.merge(conta);
		contaManaged.setNumero("99999-0");
//		conta.setNumero("44444-3");
		manager.getTransaction().commit();
		manager.close();
	}
	
}

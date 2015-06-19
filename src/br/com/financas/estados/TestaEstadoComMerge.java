package br.com.financas.estados;

import javax.persistence.EntityManager;

import br.com.financas.conta.Conta;
import br.com.financas.infra.JPAUtil;

public class TestaEstadoComMerge {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		Conta conta = manager.find(Conta.class, 2l); //gera um Select
		conta.setNumero("11111-1");
		manager.merge(conta);
		conta.setNumero("33333-3");
		manager.getTransaction().commit();
		manager.close();
	}
	
}

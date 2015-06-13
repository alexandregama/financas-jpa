package br.com.financas.estados;

import javax.persistence.EntityManager;

import br.com.financas.conta.Conta;
import br.com.financas.infra.JPAUtil;

public class TestaEstadoComMergeEDetached {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		Conta conta = manager.find(Conta.class, 2l); //gera um Select
		manager.detach(conta);
		conta.setNumero("333333-1");
		manager.merge(conta);
		conta.setNumero("55555-3");
		manager.getTransaction().commit();
		manager.close();
	}
	
}

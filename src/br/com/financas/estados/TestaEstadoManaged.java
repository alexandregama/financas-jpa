package br.com.financas.estados;

import javax.persistence.EntityManager;

import br.com.financas.conta.Conta;
import br.com.financas.infra.JPAUtil;

public class TestaEstadoManaged {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		Conta conta = new Conta("Lima Gama", "Bradesco", "2334", "2222-2");
		conta.setId(2l);
		manager.merge(conta);
		manager.getTransaction().commit();
		manager.close();
	}
	
}

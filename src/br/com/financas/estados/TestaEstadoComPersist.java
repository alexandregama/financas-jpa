package br.com.financas.estados;

import javax.persistence.EntityManager;

import br.com.financas.conta.Conta;
import br.com.financas.infra.JPAUtil;

public class TestaEstadoComPersist {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		Conta conta = new Conta("Gama Lima", "Santander", "1111", "2222-6");
		manager.persist(conta);
		conta.setNumero("5678");
		manager.getTransaction().commit();
		manager.close();
	}
	
}

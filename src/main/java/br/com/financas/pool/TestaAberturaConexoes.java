package br.com.financas.pool;

import javax.persistence.EntityManager;

import br.com.financas.infra.JPAUtil;

public class TestaAberturaConexoes {

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 30; i++) {
			EntityManager manager = new JPAUtil().getEntityManager();
			manager.getTransaction().begin();
			System.out.println("Criado EntityManager número " + i);
		}
		
		Thread.sleep(30 * 1000); //Dormir por 30 segundos
	}

}

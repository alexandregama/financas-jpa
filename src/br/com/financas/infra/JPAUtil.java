package br.com.financas.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("financas-jpa");
	
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.close();
	}
}

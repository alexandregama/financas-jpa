package br.com.financas.usuario;

import javax.persistence.EntityManager;

import br.com.financas.infra.JPAUtil;

public class CadastraUsuario {

	public static void main(String[] args) {
		Usuario alexandre = new Usuario("Alexandre Gama");
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		manager.persist(alexandre);
		manager.getTransaction().commit();
		manager.close();
	}
	
}

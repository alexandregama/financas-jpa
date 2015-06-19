package br.com.financas.usuario;

import javax.persistence.EntityManager;

import br.com.financas.infra.JPAUtil;

public class CadastraEndereco {

	public static void main(String[] args) {
		Endereco endereco = new Endereco("Rua Tomas Aquino", "123");
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		manager.persist(endereco);
		manager.getTransaction().commit();
		manager.close();
	}
	
}

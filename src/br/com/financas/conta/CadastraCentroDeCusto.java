package br.com.financas.conta;

import javax.persistence.EntityManager;

import br.com.financas.infra.JPAUtil;

public class CadastraCentroDeCusto {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		CentroCusto centroDeCusto = new CentroCusto("Internet");
		manager.getTransaction().begin();
		manager.persist(centroDeCusto);
		manager.getTransaction().commit();
		manager.close();
	}
}

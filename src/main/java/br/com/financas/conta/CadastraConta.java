package br.com.financas.conta;

import javax.persistence.EntityManager;

import br.com.financas.infra.JPAUtil;

public class CadastraConta {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta contaDoAlexandre = new Conta("Alexandre Gama", "Itau", "4077", "067584-5");
		ContaDao dao = new ContaDao(manager);
		dao.salva(contaDoAlexandre);
		manager.close();
	}
	
}

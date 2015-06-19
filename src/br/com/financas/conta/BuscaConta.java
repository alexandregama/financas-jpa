package br.com.financas.conta;

import javax.persistence.EntityManager;

import br.com.financas.infra.JPAUtil;

public class BuscaConta {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = new Conta("Fernando Gama", "Itau", "2076", "467584-3");
		ContaDao dao = new ContaDao(manager);
		dao.salva(conta);

		Conta contaEncontrada = dao.buscaPorId(conta.getId());
		System.out.println(contaEncontrada);
		
		dao.exclui(contaEncontrada);
		manager.close();
	}
	
}

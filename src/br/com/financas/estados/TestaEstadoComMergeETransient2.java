package br.com.financas.estados;

import javax.persistence.EntityManager;

import br.com.financas.conta.Conta;
import br.com.financas.infra.JPAUtil;

public class TestaEstadoComMergeETransient2 {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		Conta conta = new Conta("Lima", "Bradesco", "11111", "55555-5");
		conta.setId(2l);
		manager.merge(conta);
		conta.setNumero("44444-3"); //Nao rola pois merge nao muda estado do objeto
		manager.getTransaction().commit();
		manager.close();
	}
	
}

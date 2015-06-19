package br.com.financas.movimentacao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.financas.conta.Conta;
import br.com.financas.conta.ContaDao;
import br.com.financas.infra.JPAUtil;

public class CadastraMovimentacao {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		MovimentacaoDao dao = new MovimentacaoDao(manager);
		ContaDao contaDao = new ContaDao(manager);
		Conta conta = contaDao.buscaPorId(1l);
		Movimentacao movimentacao = new Movimentacao("Mercado", conta, new BigDecimal("100"), TipoMovimentacao.ENTRADA);
		dao.salva(movimentacao);
		
		manager.getTransaction().commit();
		manager.close();
	}
	
}

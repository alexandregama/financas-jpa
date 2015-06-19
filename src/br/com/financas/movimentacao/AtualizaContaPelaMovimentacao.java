package br.com.financas.movimentacao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.financas.conta.Conta;
import br.com.financas.conta.ContaDao;
import br.com.financas.infra.JPAUtil;

public class AtualizaContaPelaMovimentacao {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta santander = new Conta("José", "Santander", "5673", "67865-0");
		Movimentacao movimentacao = new Movimentacao("Celular", santander, new BigDecimal("180"), TipoMovimentacao.SAIDA);
		
		ContaDao contaDao = new ContaDao(manager);
		contaDao.salva(santander);
		
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(manager);
		movimentacaoDao.salva(movimentacao);
		
		Movimentacao movimentacaoEncontrada = movimentacaoDao.buscaPorId(movimentacao.getId());
		movimentacaoEncontrada.getConta().setNumero("11239-1");
		
		manager.getTransaction().commit();
		manager.close();
	}
	
}

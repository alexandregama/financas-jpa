package br.com.financas.movimentacao;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.financas.conta.Conta;

@Table(name = "movimentacao")
@Entity
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;

	@ManyToOne
	private Conta conta;
	
	private BigDecimal valor;
	
//	@Temporal O JPA não permite colocarmos somente o @Temporal, precisamos definir o TemporalType
	@Temporal(value = TemporalType.DATE)
	private Calendar data;
	
//	Se nao colocarmos o @Enumerated funciona e ele identificara no banco pela posicao
//	@Enumerated(value = EnumType.ORDINAL) - Este é o padrao 
	@Enumerated(value = EnumType.STRING)
	private TipoMovimentacao tipo;
//	alter table movimentacao add column tipo enum('ENTRADA', 'SAIDA');
	
	public Movimentacao(String descricao, Conta conta, BigDecimal valor, TipoMovimentacao tipo) {
		this.descricao = descricao;
		this.conta = conta;
		this.valor = valor;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public TipoMovimentacao getTipo() {
		return tipo;
	}
	
}

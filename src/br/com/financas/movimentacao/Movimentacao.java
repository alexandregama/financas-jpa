package br.com.financas.movimentacao;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.financas.conta.Conta;

//@EntityListeners({MovimentacaoListener.class, ContaListener.class}) Podemos passar um array de EntityListener
@EntityListeners(MovimentacaoListener.class)
@Table(name = "movimentacao")
@Entity
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;

//	Temos um erro ao manipular uma Movimentacao quando não mapeamos a Conta
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_mov_conta"), name = "conta_id")
//	@org.hibernate.annotations.ForeignKey(name = "fk_movimentacao_conta") Aqui usamos do Hibernate
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
	
	@Override
	public String toString() {
		return "Movimentacao [id=" + id + ", descricao=" + descricao
				+ ", conta=" + conta + ", valor=" + valor + ", data=" + data
				+ ", tipo=" + tipo + "]";
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

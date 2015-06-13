package br.com.financas.conta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "conta")
@Entity
public class Conta {

	@Id
	@GeneratedValue //Por padrão temos GenerationType.AUTO
	// Mysql - auto increment identity
	// SQL Server - identity
	// Postgres e Oracle - sequence
	private Long id; //BigInt para o MySQL
	
	private String titular;
	
	private String banco;
	
	private String agencia;
	
	private String numero;

	@Deprecated //Hibernate eyes only
	Conta() {
	}
	
	public Conta(String titular, String banco, String agencia,
			String numero) {
		this.titular = titular;
		this.banco = banco;
		this.agencia = agencia;
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return "Conta [id=" + id + ", titular=" + titular + ", banco=" + banco
				+ ", agencia=" + agencia + ", numero=" + numero + "]";
	}

	public Long getId() {
		return id;
	}
	
	public String getTitular() {
		return titular;
	}

	public String getBanco() {
		return banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}

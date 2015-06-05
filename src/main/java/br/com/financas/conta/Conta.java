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
	// Mysql - auto increment
	// SQL Server - identity
	// Postgres e Oracle - sequence
	private Long id; //BigInt para o MySQL
	
	private String titular;
	
	private String banco;
	
	private String agencia;
	
	private String numero;

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
	
}

package br.com.financas.conta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "centro_custo")
@Entity
public class CentroCusto {

	@Id
	// TABLE funciona no MySQL e é criada a tabela HIBERNATE_SEQUENCES, com uma sequence_name igual ao nome da table
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	private String nome;

	public CentroCusto(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}

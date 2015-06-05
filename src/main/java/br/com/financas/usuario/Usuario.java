package br.com.financas.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "usuario")
@Entity
public class Usuario {

	//Funciona sem o @GeneratedValue mas teremos que controlar o id na unha
	@Id 
	// IDENTITY funciona no MySQL pois internamente ele entende que é auto-incremento
	// SEQUENCE NÃO vai funcionar no MYSQL pois ele não suporta. Postgres e Oracle suportam sequence
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;
	
	public Usuario(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
}

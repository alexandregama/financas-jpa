package br.com.financas.usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "endereco")
@Entity
public class Endereco {

	@Id
//	@SequenceGenerator(name = "enderecoGenerator", sequenceName = "ENDERECO_SEQ", allocationSize = 10)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enderecoGenerator")
//	SEQUENCE não é suportado pelo MySQL
	@GeneratedValue
	private Long id;
	
	private String rua;
	
	private String numero;
	
	public Endereco(String rua, String numero) {
		this.rua = rua;
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}
	
}

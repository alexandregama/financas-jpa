package br.com.financas.conta.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.financas.conta.Conta;

public class InsereContaJdbc {

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/financas-jpa", "root", "");
		
		Conta conta = new Conta("Gama", "Itau", "4057", "48723-6");
		PreparedStatement stmt = con.prepareStatement("insert into Conta (titular, banco, agencia, numero) values (?, ?, ?, ?)");
		stmt.setString(1, conta.getTitular());
		stmt.setString(2, conta.getBanco());
		stmt.setString(3, conta.getAgencia());
		stmt.setString(4, conta.getNumero());
		
		stmt.execute();
		stmt.close();
		con.close();
	}	
	
}

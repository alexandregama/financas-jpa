package br.com.financas.conta.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.financas.conta.Conta;

public class ListaContaJdbc {

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/financas-jpa", "root", "");
		
		PreparedStatement stmt = con.prepareStatement("select c.* from Conta c"); //Lembrar que temos 2 tipos de PreparedStatement
		ResultSet rs = stmt.executeQuery();

		List<Conta> contas = new ArrayList<>();
		while (rs.next()) {
			String titular = rs.getString("titular");
			String banco = rs.getString("banco");
			String agencia = rs.getString("agencia");
			String numero = rs.getString("numero");
			Conta conta = new Conta(titular, banco, agencia, numero);
			contas.add(conta);
		}
		System.out.println(contas);
	}
}

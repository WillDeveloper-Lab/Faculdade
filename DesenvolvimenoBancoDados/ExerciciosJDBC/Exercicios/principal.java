package Exercicios;

import java.sql.*;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class principal {

	static final String Driver_JDBC = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/lojajdbcjava";
	static final String User = "root";
	static final String Pass = "root";
	static final String QuerySelect = "select * from produto;";
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		

		try {
			Class.forName(Driver_JDBC);
			Connection con = DriverManager.getConnection(URL, User, Pass);
			Statement stmt = con.createStatement();
			int opcao = -1;
			while(opcao != 0){
				System.out.println("Digite 1 = Listar Produtos --- 2 = Inserir Produtos -- 0 = SAIR");
				opcao = teclado.nextInt();
				if(opcao == 1){
					ResultSet rs = stmt.executeQuery(QuerySelect);
					while (rs.next()) {
						System.out.println(rs.getInt("id"));
						System.out.println(rs.getString("nome"));
						System.out.println(rs.getDouble("valor"));
						System.out.println(rs.getInt("quantidade"));
						System.out.println(rs.getDouble("valor") * rs.getInt("quantidade"));
					}
					rs.close();
					opcao = 0;
				}if(opcao == 2){					
					System.out.println("Digite o Nome do Produto: ");
					String nome = teclado.next();
					System.out.println("Digite o Valor do Produto: ");
					double valor = teclado.nextDouble();
					System.out.println("Digite a Quantidade do Produto: ");
					int quantidade = teclado.nextInt();
					int resp = stmt.executeUpdate("insert into produto(nome, valor, quatidade) values ("+nome+","+valor+","+quantidade+");");
					if (resp > 0 ){
					  System.out.println("Médico cadastrado com sucesso!");
					}  
					opcao = 0;
				}
				//o programa fecha logo após digitar as informações
			}
			con.close();
			stmt.close();
		}
			catch (Exception e) {
			System.out.println("FALHA na Conexão!!!");
		}
	}
}


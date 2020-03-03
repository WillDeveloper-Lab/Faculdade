import java.sql.*;
import java.util.Scanner;

public class principal {

	static final String Driver_JDBC = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/clinica";
	static final String User = "root";
	static final String Pass = "root";
	static final String QuerySelect = "SELECT * FROM produto";
	public static String insert(String nome,double valor, int quantidade){
		System.out.println("insert into produto(nome, valor, quatidade) values (" + nome +'","+ valor+","+quantidade+"")");
				return QueryInstert;

	}
	final String QueryInsert = "Insert into produto(descricao,valor,quantidade) values (";

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
					opcao = 0;
				}if(opcao == 2){
					System.out.println("Digite o Nome do Produto: ");
					String nome = teclado.next();
					System.out.println("Digite o Valor do Produto: ");
					double valor = teclado.nextDouble();
					System.out.println("Digite a Quantidade do Produto: ");
					int quantidade = teclado.nextInt();
					opcao = 0;
				}
			}
		}
			//ResultSet rs = stmt.executeQuery();

			rs.close();
			con.close();

		} catch (Exception e) {
			System.out.println("FALHA na Conexão!!!");

		}
	}
}


package mini_crud.conexaoPostgresql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author gustavo
 */
public class Conexao {
    
    private static String url = "jdbc:postgresql://localhost:5432/mini_crud";
	private static String password = "postgres";
	private static String user = "postgres";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public Conexao() {
		conectar();
	}
	
	private static void conectar() {
		try {
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				System.out.println("Conectado com sucesso");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}

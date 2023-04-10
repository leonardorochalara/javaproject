package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	public static Connection getConexao() {
		Connection cnx = null;
		String driverName = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driverName);
			
			String serverName = "localhost:3306";
			String dataBase = "finalDB";
			String url = "jdbc:mysql://" + serverName + "/" + dataBase;
			String user = "root";
			String password = "";
			
			cnx = DriverManager.getConnection(url, user, password);
			
			return cnx;

		} catch (ClassNotFoundException e) {
			System.out.println("O driver especificado não foi encontrado.");
			return null;
		} catch (SQLException e) {
			System.out.println("Não foi possível conectar ao banco de dados.");
			return null;
		}
	}
	
	public static boolean fecharConexao() {
		try {
			Dao.getConexao().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}

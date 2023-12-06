package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.eni.encheres.dal.Settings;


public class JdbcTools {

	private static String url;
	private static String user ;
	private static String password;
	
	static {
		try {
			Class.forName(Settings.getProperties("driverdb"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		url = Settings.getProperties("urldb");
		user = Settings.getProperties("userdb");
		password = Settings.getProperties("passworddb");
	}
	/**
	 * Permet la connexion à la BD
	 * @return con
	 * @throws DALException
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
				Connection cnx = DriverManager.getConnection(url, user, password);
		return cnx;
	}
	
	/**
	 * Permet la fermeture de la connection
	 * 
	 */public static void closeConnection(Connection connection) {
			try {
				if(connection!=null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO brancher les messages d'erreur
	            System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
			}
		}
}
	
	

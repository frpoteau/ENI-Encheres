package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.dal.Settings;

public class JdbcTools {

	private static String url;
	private static String user;
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
	 * Permet la connexion à la DB.
	 * 
	 * @return con
	 * @throws DALException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection cnx = DriverManager.getConnection(url, user, password);
		return cnx;
	}

	/**
	 * Permet la fermeture de la connection.
	 * 
	 * @throws SQLException
	 * 
	 */
	public static void closeConnection(Connection connection) throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}

	/**
	 * Permet la fermeture de la Connection, du PreparedStatement et du ResulSet.
	 * 
	 * @param connection
	 * @param preparedStatement
	 * @param resultSet
	 */
	public static void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://localhost;databasename=ENCHERES_DB;encrypt=false;trustservercertificate=true";
        String user = "sa";
        String password = "Pa$$w0rd";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, user, password);
    }
}
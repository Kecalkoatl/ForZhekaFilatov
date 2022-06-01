package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util extends Configs{
    // реализуйте настройку соеденения с БД
    Connection dbConnection;

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";



    public Connection getDbConnection() throws ClassNotFoundException, SQLException {

        String connectionString = "jdbc:mysql://localhost:3306/javamentos";

        Class.forName("com.mysql.cj.jdbc.Driver");


        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }



}

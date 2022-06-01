package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util extends Configs {
    // реализуйте настройку соеденения с БД
    
    private Util(){};

    private static Connection dbConnection;

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {

        if (dbConnection == null) {
            String connectionString = "jdbc:mysql://localhost:3306/javamentos";

            Class.forName(JDBC_DRIVER);


            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        }

        return dbConnection;
    }


}

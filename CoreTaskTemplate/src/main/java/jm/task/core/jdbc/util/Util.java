package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util extends Configs {
    // реализуйте настройку соеденения с БД

    private Util() {
    }

    private static Connection dbConnection;

    private static SessionFactory sessionFactory;

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {

        if (dbConnection == null) {

            String connectionString = "jdbc:mysql://localhost:3306/javamentos";

            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        }

        return dbConnection;
    }

    public static Session getSession() {
        if (sessionFactory == null) {
            try {

                Configuration configuration = new Configuration();
                Properties properties = new Properties();
                properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/javamentos");
                properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
                properties.setProperty("hibernate.connection.username", Configs.dbUser);
                properties.setProperty("hibernate.connection.password", Configs.dbPass);
                properties.setProperty("hibernate.connection.driver_class", Configs.JDBC_DRIVER);



                sessionFactory = configuration.addProperties(properties).addAnnotatedClass(User.class).buildSessionFactory();

            } catch (Throwable e) {
                throw new ExceptionInInitializerError(e);
            }
        }
        return sessionFactory.openSession();
    }

}

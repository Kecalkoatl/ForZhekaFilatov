package jm.task.core.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jm.task.core.jdbc.dao.Const;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {

        // реализуйте алгоритм здесь

        UserServiceImpl US = new UserServiceImpl();

        US.createUsersTable();

        US.saveUser("Vovpen", "Knyaza", (byte) 24);
        US.saveUser("Vanpen", "Levcha", (byte) 24);
        US.saveUser("Irpen", "Snezhiha", (byte) 0);
        US.saveUser("Elpen", "Pashkek", (byte) 24);

        System.out.println(US.getAllUsers());

        US.cleanUsersTable();

        US.dropUsersTable();

    }
}

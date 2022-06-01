package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        // реализуйте алгоритм здесь

        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Vovpen", "Knyaza", (byte) 24);
        userService.saveUser("Vanpen", "Levcha", (byte) 24);
        userService.saveUser("Irpen", "Snezhiha", (byte) 0);
        userService.saveUser("Elpen", "Pashkek", (byte) 24);

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();

        userService.dropUsersTable();

    }
}

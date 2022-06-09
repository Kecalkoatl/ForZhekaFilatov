package zf.task.hiperspring.dao;

import zf.task.hiperspring.model.Car;
import zf.task.hiperspring.model.User;
import java.util.List;


public interface UserDao {

    void saveUser(String name, String surName, Car car);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();

    User getUserByCar(String model, int series);
}

package zf.task.hiperspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zf.task.hiperspring.dao.UserDao;
import zf.task.hiperspring.model.Car;
import zf.task.hiperspring.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser(String name, String surName, Car car) {
        userDao.saveUser(name, surName, car);
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }

    @Override
    public User getUserByCar(String model, int series) {
        return userDao.getUserByCar(model, series);
    }
}

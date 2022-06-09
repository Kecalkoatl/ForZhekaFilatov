package zf.task.hiperspring.dao;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zf.task.hiperspring.model.Car;
import zf.task.hiperspring.model.User;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void saveUser(String name, String surName, Car car) {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            User user = new User();
            user.setCar_model(car);
            user.setName(name);
            user.setSurname(surName);
            session.save(user);

            session.getTransaction().commit();
        }

    }

    @Override
    @Transactional
    public User getUserByCar(String model, int series) {
        User user = new User();

        try(Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            user = (User) session.createQuery("FROM User u INNER JOIN Car c ON u.car_model=c.model WHERE c.model = '"
                    + model
                    + "' AND c.series = "
                    + series).uniqueResult();

            session.getTransaction().commit();
        }
        return user;
    }

    @Override
    @Transactional
    public void removeUserById(long id) {

        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            User user = new User();
            user = session.get(User.class, id);
            session.delete(user);

            session.getTransaction().commit();
        }

    }

    @Override
    @Transactional
    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            userList = session.createQuery("FROM User").list();

            session.getTransaction().commit();
        }

        return userList;
    }

    @Override
    @Transactional
    public void cleanUsersTable() {

        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            session.createQuery("DELETE FROM User").executeUpdate();
            session.createQuery("DELETE FROM Car").executeUpdate();

            session.getTransaction().commit();
        }
    }
}

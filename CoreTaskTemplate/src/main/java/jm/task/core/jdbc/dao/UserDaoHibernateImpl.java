package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Const;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

        String SQL = "CREATE TABLE UserTable (" + Const.USER_ID + " INTEGER NOT NULL AUTO_INCREMENT, " + Const.USER_FIRSTNAME + " VARCHAR(30) not null, " + Const.USER_LASTNAME
                + " VARCHAR(30) NOT NULL, " + Const.USER_AGE + " INTEGER NOT NULL, PRIMARY KEY (" + Const.USER_ID + ") );";

        try (Statement statement = Util.getDbConnection().createStatement()) {

            statement.executeUpdate(SQL);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Tablica uzhe sushestvuet!");
        }

    }

    @Override
    public void dropUsersTable() {
        String SQL = "DROP TABLE " + Const.USER_TABLE;

        try (Statement statement = Util.getDbConnection().createStatement();) {

            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            System.out.println("Tablici ne sushestvuet!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getSession()) {

            session.beginTransaction();

            User user = new User();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);

            session.save(user);

            session.getTransaction().commit();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSession()) {

            session.beginTransaction();

            User user = new User();
            user = session.get(User.class, id);
            session.delete(user);

            session.getTransaction().commit();
        }

    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Session session = Util.getSession()) {

            session.beginTransaction();

            userList = session.createQuery("FROM User").list();

            session.getTransaction().commit();
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getSession()) {

            session.beginTransaction();

            session.createQuery("DELETE FROM User").executeUpdate();

            session.getTransaction().commit();
        }


    }
}

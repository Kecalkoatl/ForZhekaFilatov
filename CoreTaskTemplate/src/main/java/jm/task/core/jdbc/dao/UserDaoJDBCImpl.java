package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.util.*;
import jm.task.core.jdbc.model.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {


    public UserDaoJDBCImpl() {
    }

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

    public void saveUser(String name, String lastName, byte age) {


        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_FIRSTNAME + "," + Const.USER_LASTNAME + "," +
                Const.USER_AGE + ")"
                + "VALUES (?,?,?)";

        try (PreparedStatement prSt = Util.getDbConnection().prepareStatement(insert);
        ) {

            prSt.setString(1, name);
            prSt.setString(2, lastName);
            prSt.setByte(3, age);
            prSt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void removeUserById(long id) {

        String delete = "DELETE FROM " + Const.USER_TABLE + " WHERE " + Const.USER_ID + "=" + id;

        try (Statement statement = Util.getDbConnection().createStatement()) {

            statement.executeUpdate(delete);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM " + Const.USER_TABLE;

        try (Statement statement = Util.getDbConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("ID"));
                user.setName(resultSet.getString("Name"));
                user.setLastName(resultSet.getString("LastName"));
                user.setAge(resultSet.getByte("Age"));
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return userList;
    }

    public void cleanUsersTable() {

        String cleanTable = "DELETE FROM " + Const.USER_TABLE;

        try (Statement statement = Util.getDbConnection().createStatement()) {

            statement.executeUpdate(cleanTable);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

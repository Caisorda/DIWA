/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherstuff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import otherstuff.User;;

/**
 *
 * @author Christian Gabriel
 */
public class UserDAO implements IDBCUD {

    public Iterator get() {
        ArrayList<User> users = new ArrayList();

        try {
            String query = "SELECT * FROM user";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User(resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("username"), resultSet.getString("password"));
                users.add(user);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return users.iterator();
    }

    public Object get(String key) {
        try {
            String query = "SELECT * FROM user WHERE username = ?";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = new User(resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("username"), resultSet.getString("password"));
                return user;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public Iterator search(String searchStr) {

        ArrayList<User> users = new ArrayList<User>();
        try {

            String query = "SELECT * FROM user WHERE username LIKE ? " + "ORDER BY 1";
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + searchStr + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("username"), resultSet.getString("password"));
                users.add(user);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return users.iterator();
    }
    //under construction
    
    /*public Iterator getDistinct(String string){
        ArrayList<String> results = new ArrayList<String>();
        try {
            String query = "SELECT DISTINCT "+string+" FROM user";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                results.add(resultSet.getString(1));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return results.iterator();
    }*/
    
    public void add(Object object) {

        User user = (User) object;
        try {

            String query = "INSERT INTO user VALUES(?,?,?,?);";
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getFname());
            preparedStatement.setString(2, user.getLname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.execute();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        System.out.println("it happened");

    }

    public void update(Object object, String origKey) {
        User user = (User) object;

        try {
            String query = "UPDATE user SET firstname = ?,lastname = ?, username = ?, password = ?,  WHERE username = ?;";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getFname());
            preparedStatement.setString(2, user.getLname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(3, origKey);
            preparedStatement.execute();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void delete(Object object) {

        User user = (User) object;
        try {
            String query = "DELETE FROM user WHERE username = ?;";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.execute();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
}

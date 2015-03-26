/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherstuff;

/**
 *
 * @author Lucky
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {
    private DBConnection db;
    private ArrayList<User> users;
    private ArrayList<Location> locations;
    
    private int userID = 0;
    private int locationID = 0;

    public Model() {
        db = new DBConnection();
        db.getConnection();
        users = new ArrayList<>();
        locations = new ArrayList<>();
    }
    
    public int getUserIndex(int id) {
        int i = -1;
        for (i = 0; i < users.size(); i++)
            if (users.get(i).getID() == id)
                break;
        return i;
    }
    public boolean addUser(User u) {
        try {
            PreparedStatement statement;
            String query = "INSERT INTO users values(?,?,?,?,?)";
            statement = db.getConnection().prepareStatement(query);
            userID++;
            u.setID(userID);
            statement.setInt(1, userID);
            statement.setString(2, u.getFname());
            statement.setString(3, u.getLname());
            statement.setString(4, u.getUsername());
            statement.setString(5, u.getPassword());
            statement.execute();
            users.add(u);
        } catch (SQLException e) {
            System.out.println("Unable to INSERT new User");
            e.printStackTrace();
            userID--;
            return false;
        }
        return true;
    }
 
}

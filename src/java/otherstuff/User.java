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
public class User {
    private int userID;
    private String fname;
    private String lname;
    private String username;
    private String password;
    
    public User(String fname,String lname,String username,String password){
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
    }

    int getID() {
        return userID;
    }

    void setID(int userID) {
        this.userID = userID;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

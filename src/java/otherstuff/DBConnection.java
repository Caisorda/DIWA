/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucky
 */
package otherstuff;
import java.sql.*;

import java.util.*;
import java.io.*;
import java.awt.*;

public class DBConnection {
        private static DBConnection instance = null;
        
	private String	driverName	= "com.mysql.jdbc.Driver";
	private String	url		= "jdbc:mysql://localhost:3306/";
	private String	database	= "diwa";
	private String	username	= "root";
	private String	password	= "Pr0crastinate";
        
        public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }

        return instance;
    }

	public static Connection getConnection(){
            
                if (instance == null) {
                    instance = new DBConnection();
                }
                
		try{
			return DriverManager.getConnection(instance.getUrl()
                                                        + instance.getDatabase(),
                                                         instance.getUsername(),
                                                            instance.getPassword());
		}catch( Exception e){
			System.out.println("Couldnt connect");
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public String getUrl() {
        return url;
    }

    /**
     * returns database name
     *
     * @return database name
     */
    public String getDatabase() {
        return database;
    }

    /**
     * returns username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    private String getPassword() {
        return password;
    }

    /**
     * returns whether password is correct or not
     *
     * @param password password to checkPassword
     * @return whether password is correct or not
     */
    public boolean isCorrectPassword(String password) {
        return password.equals(this.password);
    }

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

}
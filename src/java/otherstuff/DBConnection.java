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
	private String	driverName	= "com.mysql.jdbc.Driver";
	private String	url		= "jdbc:mysql://localhost:3306/";
	private String	database	= "diwa";
	private String	username	= "root";
	private String	password	= "lucky";

	public Connection getConnection(){
		try{
			Connection con = DriverManager.getConnection(url + database, username, password);
			System.out.println("DB connection SUCCESSFUL");
			return con;
		}catch( Exception e){
			System.out.println("Couldnt connect");
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

}
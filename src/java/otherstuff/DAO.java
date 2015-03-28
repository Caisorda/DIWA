/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherstuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Christian Gabriel
 */
public class DAO {

	private static DAO instance = null;
	private ArrayList<IDBGet> data;
	private static String password = "";

	private DAO() {
		password = "PASSWORD";// tempo
		BufferedReader br = null;

		// try {
		// br = new BufferedReader(
		// new FileReader(new File("config.txt")));
		// password = br.readLine();
		// } catch (IOException ioe) {
		// ioe.printStackTrace();
		// } finally {
		// if (br != null) {
		// try {
		// br.close();
		// } catch (IOException ioe) {
		// ioe.printStackTrace();
		// }
		// }
		// }
		data = new ArrayList<IDBGet>();
		data.add(new UserDAO());
	}

	public static DAO getInstance() {
		if (instance == null) {
			instance = new DAO();
		}
		return instance;
	}

	/*public Iterator getDistinct(String table, String string) {
		if (table.equalsIgnoreCase("user"))
			return ((UserDAO) data.get(0)).getDistinct(string);
		return null;
	}*/

	public Iterator get(String table) {
		if (table.equalsIgnoreCase("user"))
			return data.get(0).get();
		return null;
	}

	/**
	 * returns all items in a special table
	 * 
	 * @param table
	 *            table to search
	 * @param key
	 *            key of result set (theater name)
	 * @param arg0
	 *            index 0 of result set (floor no)
	 * @param arg1
	 *            index 1 of result set (column no)
	 * @return all items in this table


	/**
	 * returns the specific object in the given table with key as a primary key
	 * 
	 * @param table
	 *            table to search
	 * @param key
	 *            primary key
	 * @return the specific object with key as a primary key
	 */
	public Object get(String table, String key) {
		if (table.equalsIgnoreCase("user"))
			return data.get(0).get(key);
		return null;
	}

	/**
	 * returns all objects in the given table with searchStr in its primary key
	 * 
	 * @param table
	 *            table to search
	 * @param searchStr
	 *            search key
	 * @return all objects in this table with searchStr in its primary key
	 */
	public Iterator search(String table, String searchStr) {
		if (table.equalsIgnoreCase("user"))
			return data.get(0).search(searchStr);
		return null;
	}

	/**
	 * returns reports based on mode
	 * 
	 * @param mode
	 *            whether DAILY, WEEKLY, or MONTHLY
	 * @param month
	 *            month of reports
	 * @param year
	 *            year of reports
	 * @return reports based on mode
	 */
	public ResultSet getReports(int mode, int month, int year) {
		return null;
	}

	/**
	 * adds obj to the given table in the database
	 * 
	 * @param table
	 *            table to add to
	 * @param obj
	 *            object to add
	 */
	public void add(String table, Object obj) {
		if (table.equalsIgnoreCase("user"))
			((IDBCUD) data.get(0)).add(obj);
	}

	/**
	 * updates the object with key origKey with the values in obj in given table
	 * 
	 * @param table
	 *            table to update into
	 * @param obj
	 *            new values of object
	 * @param origKey
	 *            original key of object
	 */
	public void update(String table, Object obj, String origKey) {
		if (table.equalsIgnoreCase("user"))
			((IDBCUD) data.get(0)).update(obj, origKey);
	}

	/**
	 * deletes object in given table
	 * 
	 * @param table
	 *            table to delete from
	 * @param obj
	 *            object to delete
	 */
	public void delete(String table, Object obj) {
		if (table.equalsIgnoreCase("user"))
			((IDBCUD) data.get(0)).delete(obj);
	}

}

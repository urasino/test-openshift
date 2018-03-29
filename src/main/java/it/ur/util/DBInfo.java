package it.ur.util;

public class DBInfo {

	/*****
	 * For LOCALHOST
	 */
//	public static String host = "localhost";
//	public static String user = "root";
//	public static String password = "root55";
	
	/****
	 * For OpenShift
	 */
	public static String host = "mysql";
	public static String user = "user01";
	public static String password = "OpenShift2020";
	
	public static String DBName = "dispensadb";
	public static int port = 3306;
	public static String mySQLdbURL = "jdbc:mysql://" + host + ":" + port + "/" + DBName;
	
	public static String driver = "com.mysql.jdbc.Driver";
	
	public DBInfo() {
		
	}
	
	public static String getDBURL() {
		return mySQLdbURL;
	}
	
	public static String getUser() {
		return user;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public static String getDriver() {
		return driver;
	}
}

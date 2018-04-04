package it.oggi012.skustore.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import it.oggi012.skustore.bean.SkuStoreConstant;

public class DBConnection {

	private boolean flagDriver;
	private Connection connection;
	
	public DBConnection() {
		super();
		
		flagDriver = false;
		initDriverConnection();
	}
	
	private void initDriverConnection() {
		try {
			Class.forName(SkuStoreConstant.DATABASE_MYSQL_DRIVER);
			flagDriver = true;
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean isDriverInit() {
		return flagDriver;
	}
	
	private String factoryMySqlUrl() {
		StringBuilder sb = new StringBuilder();
		sb.append("jdbc:mysql://");
		sb.append(this.getDatabaseMySqlDatabaseHost());
		sb.append(":");
		sb.append(SkuStoreConstant.DATABASE_MYSQL_DATABASE_PORT);
		sb.append("/");
		sb.append(this.getDatabaseMySqlDatabaseName());
		return sb.toString();
	}
	
	private Connection factoryConnection() throws SQLException {
		if (!isDriverInit()) {
			return null;
		}
		String hostName = factoryMySqlUrl();
		String userName = this.getDatabaseMySqlUser();
		String pwd = this.factoryDatabaseMySqlPassword();
		return DriverManager.getConnection(hostName, userName, pwd);
	}
	
	public String buildDescriptionConnection() throws SQLException {
		if (connection == null) {
			connection = factoryConnection();
		}
		
		return buildStatusConnection();
	}
	
	private String buildStatusConnection() throws SQLException {
		String result = "Failed to make connection";
		if (connection == null) {
			return result;
		}
		
		result = "Open";
		if (connection.isClosed()) {
			result = "Closed";
		}
		
		return "Connection is " + result;
	}
	
	public String getDatabaseMySqlDatabaseHost() {
		String result = SkuStoreConstant.DATABASE_MYSQL_DATABASE_HOST_LOCAL;
		if (SkuStoreConstant.FLAG_DATABASE_ONLINE) {
			result = SkuStoreConstant.DATABASE_MYSQL_DATABASE_HOST_ONLINE;
		}
		return result;
	}
	
	public String getDatabaseMySqlDatabaseName() {
		return SkuStoreConstant.DATABASE_MYSQL_DATABASE_NAME;
	}
	
	public String getDatabaseMySqlUser() {
		String result = SkuStoreConstant.DATABASE_MYSQL_USER_LOCAL;
		if (SkuStoreConstant.FLAG_DATABASE_ONLINE) {
			result = SkuStoreConstant.DATABASE_MYSQL_USER_ONLINE;
		}
		return result;
	}
	
	private String factoryDatabaseMySqlPassword() {
		String result = SkuStoreConstant.DATABASE_MYSQL_PASSWORD_LOCAL;
		if (SkuStoreConstant.FLAG_DATABASE_ONLINE) {
			result = SkuStoreConstant.DATABASE_MYSQL_PASSWORD_ONLINE;
		}
		
		return result;
	}
	
	public String getDatabaseMySqlDatabasePassword() {
		String result = SkuStoreConstant.DATABASE_MYSQL_PASSWORD_LOCAL;
		if (SkuStoreConstant.FLAG_DATABASE_ONLINE) {
			result = SkuStoreConstant.DATABASE_MYSQL_PASSWORD_ONLINE;
		}
		if (!SkuStoreConstant.FLAG_SHOW_DATABASE_PASSWORD) {
			result = "******";
		}
		return result;
	}
	
}

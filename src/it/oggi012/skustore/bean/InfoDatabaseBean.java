package it.oggi012.skustore.bean;

import java.sql.SQLException;

import it.oggi012.skustore.connection.DBConnection;
import it.oggi012.skustore.custom.CustomSkuStore;

public class InfoDatabaseBean extends CustomSkuStore {

//	private Connection connection = null;
	private DBConnection dbConnection;
	
	public InfoDatabaseBean() {
		super();
		
		dbConnection = new DBConnection();
	}
	
	public String outcomeBackHome() {
		return SkuStoreConstant.PAGE_HOME;
	}
	
	public void actionBackHome() {
		return;
	}
	
//	private Connection factoryConnection() throws SQLException {
//		if (!dbConnection.isDriverInit()) {
//			return null;
//		}
//		String hostName = getDatabaseMySqlDatabaseHost();
//		StringBuilder sb = new StringBuilder();
//		sb.append("jdbc:mysql:");
//		sb.append("//");
//		sb.append(hostName + ":3306");
//		sb.append("/" + getDatabaseMySqlDatabaseName());
//		/*
//		sb.append("?user=");
//		sb.append(getDatabaseMySqlUser());
//		sb.append("&");
//		sb.append("password=");
//		sb.append(getDatabaseMySqlDatabasePassword());
//		*/
//		String userName = this.getDatabaseMySqlUser();
//		String pwd = this.getDatabaseMySqlDatabasePassword();
//		return DriverManager.getConnection(sb.toString(), userName, pwd);
//	}
	
	public String getDataUltimaModifica() {
		return "20180323.0020";
	}
	
	public String getDatabaseMySqlUser() {
		return dbConnection.getDatabaseMySqlUser();
	}
	
	public String getDatabaseMySqlDatabaseName() {
		return dbConnection.getDatabaseMySqlDatabaseName();
	}
	
	public String getDatabaseMySqlDatabaseHost() {
		return dbConnection.getDatabaseMySqlDatabaseHost();
	}
	
	public String getDatabaseMySqlDatabasePassword() {
		return dbConnection.getDatabaseMySqlDatabasePassword();
	}
	
//	public String buildDescriptionConnection() throws SQLException {
//		if (connection == null) {
//			connection = factoryConnection();
//		}
//		
//		return buildStatusConnection();
//	}
	
	public String getDescriptionConnection() {
		String result = null;
		
		try {
			result = dbConnection.buildDescriptionConnection();
		} catch (SQLException ex) {
			result = "Error: " + ex.getMessage();
		}
		
//		result = buildStatusConnection();
//		if (connection == null) {
//			try {
//				connection = factoryConnection();
//				if (connection == null) {
//					result = "Failed to make connection";
//				}else {
//					if (connection.isClosed()) {
//						result = "Connection is Closed";
//					}else {
//						result = "Connection is Open";
//					}
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return result == null ? "Failed to make connection" : result;
	}
	
//	private String buildStatusConnection() throws SQLException {
//		String result = "Failed to make connection";
//		if (connection == null) {
//			return result;
//		}
//		
//		if (connection.isClosed()) {
//			result = "Connection is Closed";
//		}else {
//			result = "Connectio is Open";
//		}
//		
//		return result;
//	}
}

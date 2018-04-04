package it.oggi012.skustore.bean;

public interface SkuStoreConstant {

	public static final boolean FLAG_BRANCHES = true;
	public static final boolean FLAG_SHOW_DATABASE_PASSWORD = true;
	public static final boolean FLAG_DATABASE_ONLINE = true;
	
	public static final int LEVEL_APP = 5;
	
	/**
	 * For OpenShift
	 */
	public static final String DATABASE_MYSQL_DATABASE_HOST_ONLINE = "mysql";
	public static final String DATABASE_MYSQL_USER_ONLINE = "user01";
	public static final String DATABASE_MYSQL_PASSWORD_ONLINE = "OpenShift2020";
	
	/**
	 * For LocalHost
	 */
	public static final String DATABASE_MYSQL_DATABASE_HOST_LOCAL = "localhost";
	public static final String DATABASE_MYSQL_USER_LOCAL = "root";
	public static final String DATABASE_MYSQL_PASSWORD_LOCAL = "root55";
	
	public static final String DATABASE_MYSQL_DATABASE_NAME = "dispensadb";
	public static final int DATABASE_MYSQL_DATABASE_PORT = 3306;
	
	public static final String DATABASE_MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	
	public static final String PAGE_HOME = "/index";
	public static final String PAGE_ELENCOINFODB = "/infodb/elencoInfoDB";
}

package it.ur.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ur.util.DBInfo;

/**
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SimpleDateFormat sdf;
	private boolean flagDriver;
	private String msgDriver;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    
        sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        
        initMySqlDriver();
    }
    
    
    
    private void initMySqlDriver() {
    	flagDriver = false;
    	msgDriver = null;
    	try {
    		Class.forName(DBInfo.getDriver());
    		flagDriver = true;
    	}catch(ClassNotFoundException ex) {
    		msgDriver = ex.getMessage();
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		
		String timeMessage = "Time: " + sdf.format(cal.getTime());
		response.getWriter().append("Seconda Pagina per OpenShift 3 Online. " + timeMessage);
		response.getWriter().append("<br>");
		response.getWriter().append("---");
		response.getWriter().append("<br>");
		response.getWriter().append("<br>");
		response.getWriter().flush();
		
		String driverStatus = "MySql Driver init";
		if (!flagDriver) {
			driverStatus = "MySql Driver Errore: " + msgDriver == null ? "" : msgDriver;
		}
		response.getWriter().append(driverStatus);
		response.getWriter().append("<br>");
		
		if (flagDriver) {
			response.getWriter().append("<br>");
			response.getWriter().append("<b>-->Test connection<--</b>");
			response.getWriter().append("<br>");
			response.getWriter().append("<b>DB Host</b>: " + DBInfo.host);
			response.getWriter().append("<br>");
			response.getWriter().append("<b>DB Name</b>: " + DBInfo.DBName);
			response.getWriter().append("<br>");
			String msgConnection = parseConnection();
			response.getWriter().append("<br>");
			response.getWriter().append("<b>Parse Connection:</b>");
			response.getWriter().append("<br>");
			response.getWriter().append("msgConnection: " + msgConnection);
			response.getWriter().append("<br>");
			response.getWriter().append("<---------------------------->");
		}
	}
	
	private String parseConnection() {
		String result = null;
		
		Connection connection = null;
		try {
			connection = factoryConnection();
			result = "Connection is Open";
			if (connection.isClosed()) {
				result = "Connection is Close";
			}
		}catch(SQLException ex) {
			result = ex.getMessage();
		}
		return result;
	}
	
	private Connection factoryConnection() throws SQLException {
		if (!flagDriver) {
			return null;
		}
		String mySqlUrl = DBInfo.getDBURL();
		String userName = DBInfo.getUser();
		String password = DBInfo.getPassword();
		
		return DriverManager.getConnection(mySqlUrl, userName, password);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

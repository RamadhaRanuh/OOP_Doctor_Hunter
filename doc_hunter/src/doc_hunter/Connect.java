package doc_hunter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class Connect {
	
	
	private Connection con;
	private Statement st;
	 public ResultSet rs;
	 public ResultSetMetaData rsm;
	
	private static Connect conobj;
	

	
	
	public static Connect getinstance() {
		 if(conobj==null) { return new Connect();
		 }else {
			 return conobj;
		 }
	 }
	
	public ResultSet executequery(String query) {
		 
		 try {
			 if (st != null) {
	                rs = st.executeQuery(query);
	                rsm = rs.getMetaData();
	            }
		}
		 
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		 return rs;
	 }
	
	
	public void executeupdate(String query) {
	    try {
	        st.executeUpdate(query);
	    } catch (SQLException e) {
	        // Print SQL exception information
	        System.out.println("SQL exception occured" + e);
	        e.printStackTrace();
	    }
	}

	
			private  Connect() {
					// TODO Auto-generated constructor stub
					 try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						con= DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor_hunter", "root", "Magelang123##");
						st = con.createStatement();
						
					} 
					 
					 catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
}


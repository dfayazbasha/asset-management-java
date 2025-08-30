//package db;
//import java.sql.*;
//
//
//public class DBConnection {
//	  private static final String URL="jdbc:mysql://localhost:3306/asset_management";
//	  private static final String user="root";
//	  private static final String password="Fayaz@1115";
//	  private static Connection connection=null;
//	  
//	  public static Connection getConnection() {
//		  if(connection==null) {
//			  try {
//				  Class.forName("com.mysql.cj.jdbc.Driver");
//				  connection=DriverManager.getConnection(URL,user,password);
//				  System.out.println(" ✅ database connected successfully:");
//				  
//			  }
////			  catch(ClassNotFoundException| SQlException e) {
////				  System.out.println("Connection Failed!");
////				  e.printStackTrace();
////			  }
//			  catch (ClassNotFoundException | SQLException e) {
//	                System.out.println("❌ Connection failed!");
//	                e.printStackTrace();
//		  }
//	  }
//		  return connection;
//	 }
//	  public static void closeConnection() {
//		  try {
//			  if(connection !=null) {
//				  connection.close();
//				  System.out.println("connection closed");
//			  }
//		  }
//		  catch(SQLException e) {
//			  e.printStackTrace();
//		  }
//	  }
//
//}






//2nd code
package db;
import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/asset_management";
    private static final String user = "root";
    private static final String password = "Fayaz@1115";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("✅ Connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

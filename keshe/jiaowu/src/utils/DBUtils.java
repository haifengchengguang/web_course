package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DBUtils {
	public static Connection getConnection(){
		String url="jdbc:mysql://localhost:3306/jiaowu?useSSL=false&serverTimezone=UTC";
		String user="root";
        String password="mysql123";
   	    Connection connection=null;
        Statement statement=null;
        try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection  =DriverManager.getConnection (url,user,password); 
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return connection;
	}
	public static void closeConnection(Connection connection) {
		if(connection!=null) {
			try {
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}

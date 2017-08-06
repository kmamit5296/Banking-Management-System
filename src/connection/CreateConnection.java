package connection;
import java.sql.*;

import javax.swing.JOptionPane;
public class CreateConnection {
	ResultSet r1;
	static Connection con;
	static PreparedStatement p2;
	public static void loadDriverClass()throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	} 
	public static Connection createconnection()throws SQLException{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking management system?user=root");
		return con;
	}
	public static ResultSet execute(String url)throws SQLException,ClassNotFoundException{
		
		 CreateConnection.loadDriverClass();
		 con=CreateConnection.createconnection();
		 p2=con.prepareStatement(url);
		 return p2.executeQuery();
	}
	public static int Update(String url)throws SQLException,ClassNotFoundException{
		 
		 CreateConnection.loadDriverClass();
		 con=CreateConnection.createconnection();
		 p2=con.prepareStatement(url);
		 return p2.executeUpdate();
	}
	public static void close1(){
		try {
			con.close();
			p2.close();
		} catch (SQLException e) {
			
			 JOptionPane.showMessageDialog(null, "something went wring with jdbc connection");
		}
		
	}
}

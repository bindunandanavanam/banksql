package mysqlbasics;
import java.sql.*;
public class BasicMySql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//1
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bindu","root","root");
		//3
			Statement stmt= con.createStatement();
		//4
			ResultSet rs=stmt.executeQuery("select* from employee");
		while(rs.next()){
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
		//5
		con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

package mysqlbasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		try {
			//1
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bindu","root","root");
		//3
			PreparedStatement ps= con.prepareStatement("delete from employee where name=?");
		//4
			System.out.println("enter name to delete");
			String name=sc.next();
			ps.setString(1, name);
			int i=ps.executeUpdate();
			if(i==1){
				System.out.println("done");
			}
			else {
				
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
		sc.close();

	}

}

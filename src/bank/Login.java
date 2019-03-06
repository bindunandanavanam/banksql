package bank;

import java.sql.*;
import com.bank.dao.*;
import java.util.*;

public class Login  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bindu","root","root");
			System.out.println("enter  acc no");
			Long accno=sc.nextLong();
			System.out.println("enter password");
			String pswd=sc.next();

			PreparedStatement ps=con.prepareStatement("select * from user where accno=? and pswd=?");
            ps.setLong(1,accno);
            ps.setString(2,pswd);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
         	System.out.println("Hello "+rs.getString(2));
         	   }
            else{
            	System.out.println("invalid credentials");
            }
			
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

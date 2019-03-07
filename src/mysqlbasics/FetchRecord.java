package mysqlbasics;
import java.sql.*;
import java.util.Scanner;  
class FetchRecord{  
public static void main(String args[])throws Exception{  
  Scanner sc=new Scanner(System.in);
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bindu","root","root");  
Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
ResultSet rs=stmt.executeQuery("select * from employee");  
PreparedStatement ps= con.prepareStatement("update employee set age=? where name=?");
//4
	System.out.println("enter name to update");
	String name=sc.next();
	System.out.println("enter new age");
	int age=sc.nextInt();
	
	ps.setInt(1, age);
	ps.setString(2, name);
	int i=ps.executeUpdate();
	if(i==1){
		System.out.println("done");
	}
	else {
		
	}
  
//getting the record of 3rd row  
rs.absolute(4);  
System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getLong(4));  
  
con.close();  
sc.close();
}

}
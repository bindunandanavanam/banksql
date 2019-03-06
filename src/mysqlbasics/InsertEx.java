package mysqlbasics;

import java.sql.*;
import java.util.Scanner;
public class InsertEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		try {
			//1
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bindu","root","root");
		//3
			PreparedStatement ps= con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
			System.out.println("enter name");
			String name=sc.next();
			System.out.println("enter dad name");
			String dad=sc.next();
			System.out.println("enter rno");
			int rno=sc.nextInt();
			System.out.println("enter age");
			int age=sc.nextInt();
			System.out.println("enter contact");
			int contact=sc.nextInt();
			System.out.println("enter address");
			String add=sc.next();
			System.out.println("enter salary");
			int sal=sc.nextInt();
			ps.setString(1,name);
			ps.setString(2, dad);
			ps.setInt(3, rno);
			ps.setInt(4, age);
			ps.setInt(5,contact);
			ps.setString(6, add);
			ps.setInt(7,sal);
			
			//4
			int i=ps.executeUpdate();
			if(i==1){
				System.out.println("done");
			}
			else{
				System.out.println("could not insert data");
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

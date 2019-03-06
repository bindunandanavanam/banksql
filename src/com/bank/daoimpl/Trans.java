package com.bank.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bank.dao.Tran;
import com.bank.modal.User;

public class Trans implements Tran {
Scanner sc=new Scanner(System.in);
User u=new User();
	@Override
	public void deposit(long aadhar, long balance) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bindu","root","root");
			System.out.println("enter amt to deposit");
			long amt=sc.nextLong();
			 balance=balance+amt;
			u.setBal(balance);
			PreparedStatement ps= con.prepareStatement("update user set bal=? where aadhar=?");
			ps.setLong(1,u.getBal());
			ps.setLong(2,aadhar);
			System.out.println(u.getBal());
			int x=ps.executeUpdate();
			if(x==1){
				System.out.println("done");
			}
			else {
				System.out.println("error");
			}
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	@Override
	public void withdrawl(long aadhar, long balance) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bindu","root","root");
			System.out.println("enter amt for withdrawl");
			long amt=sc.nextLong();
			if(balance>amt){
			 balance=balance-amt;
			}
			else{
				System.out.println("insufficient bal");
			}
			u.setBal(balance);
			PreparedStatement ps= con.prepareStatement("update user set bal=? where aadhar=?");
			ps.setLong(1,u.getBal());
			ps.setLong(2,aadhar);
			System.out.println(u.getBal());
			int x=ps.executeUpdate();
			if(x==1){
				System.out.println("done");
			}
			else {
				System.out.println("error");
			}
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}



}

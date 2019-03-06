package com.bank.daoimpl;

import java.sql.*;
import java.util.*;

import com.bank.dao.Register;
import com.bank.modal.User;

public class Registerimpl implements Register {
	static User u = new User();

	public User setInfo() {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter  name");
		u.setName(sc.next());
		System.out.println("enter aadhar");
		u.setAadhar(sc.nextLong());
		boolean b=validate();
		if(b){
		System.out.println("enter contact");
		u.setContact(sc.nextLong());
		System.out.println("enter  password");
		u.setPswd(sc.next());
		Random r = new Random();
		u.setAccNo(Math.abs(r.nextLong()));
		u.setBal(0);
		sc.close();
		return u;
		}
		sc.close();
		return null;
		
	}

	public boolean validate() {
		boolean b = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bindu", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from user where aadhar=?");
			ps.setLong(1, u.getAadhar());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("Acc already exists");
				b = false;
			} else {
				b = true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
		// TODO Auto-generated method stub

	}

	public void Register() {

		Registerimpl rg = new Registerimpl();
		rg.setInfo();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bindu", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?,?)");

			ps.setLong(1, u.getAccNo());
			ps.setString(2, u.getName());
			ps.setLong(3, u.getAadhar());
			ps.setLong(4, u.getContact());
			ps.setString(5, u.getPswd());
			ps.setLong(6, u.getBal());

			int i = ps.executeUpdate();
			if (i == 1) {
				System.out.println("done");
			} else {
				System.out.println("could not insert data");
			}
			System.out.println("acc no is " + u.getAccNo());

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

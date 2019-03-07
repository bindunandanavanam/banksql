package com.bank.driver;

import java.util.Scanner;


import com.bank.dao.Login;
import com.bank.dao.Register;
import com.bank.dao.Tran;
import com.bank.daoimpl.Loginimpl;
import com.bank.daoimpl.Registerimpl;
import com.bank.daoimpl.Trans;


public class App {
	public static Scanner sc = new Scanner(System.in);
public void disp(Long aadhar, Long balance){
	Tran t=new Trans();
	long adar=aadhar;
	long bal=balance;
	System.out.println("enter 1. deposit 2. withdrwal 3. exit");
	int i=sc.nextInt();
	switch(i){
	case 1:
		t.deposit(adar,bal);
		break;
	case 2:
		t.withdrawl(adar,bal);
		break;
	case 3:
	
		t.baldisp(adar,bal);
		break;
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("enter 1 for registration 2 for login ");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			Register rg = new Registerimpl();
			rg.Register();
			break;
		case 2:
			Login l = new Loginimpl();
			l.login();
			break;
		default:
			System.out.println("invalid choice");
		}
		sc.close();
	}

}

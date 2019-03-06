package com.bank.dao;

public interface Tran {
void withdrawl(long aadhar, long balance);
void deposit(long aadhar, long balance);
}

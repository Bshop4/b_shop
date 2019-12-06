package bshow.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;

import bshow.pojo.Bank;


public interface BankService extends Remote{
	  
	public static final String ADDRESS = "rmi://192.168.43.155:20000/bankService";
	
	public double queryAccount(String account,String pass) throws RemoteException;
	
	public boolean update(Bank bank) throws RemoteException;
}

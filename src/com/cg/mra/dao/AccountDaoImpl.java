package com.cg.mra.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.mra.beans.Account;

public class AccountDaoImpl implements AccountDao {

	Map<String, Account> accountEntry;

	public AccountDaoImpl() {
		accountEntry = new HashMap<String, Account>();
		accountEntry.put("9010210131", new Account("prepaid", "Vaishali", 200.00));
		accountEntry.put("8985420188", new Account("prepaid", "Ravi", 300.00));
		accountEntry.put("9999999999", new Account("prepaid", "Kiran", 0.0));
		accountEntry.put("8888888888", new Account("prepaid", "Sai", 700.00));
		accountEntry.put("7777777777", new Account("prepaid", "Kumar", 200.00));
		accountEntry.put("7207130326", new Account("prepaid", "Bhushetty", 200.00));
	}

	Account a = new Account();

	public Account getAccountDetails(String mobileNo) {
		if (accountEntry.containsKey(mobileNo)) {
			a = accountEntry.get(mobileNo);
			return a;
		} 
		else {
			return null;
		}
	}

	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		double bal = 0;
		if (accountEntry.containsKey(mobileNo)) {
			a = accountEntry.get(mobileNo);
			bal = a.getAccountBalance();
			bal += rechargeAmount;
			a.setAccountBalance(bal);
			accountEntry.replace(mobileNo, a);
			System.out.println("Your Account Recharge Successful");
		} 
		return (int) bal;
	}

}

package com.accountservice.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Account {
	
	@Id
	@SequenceGenerator(name = "Agen1", sequenceName = "AccountId", initialValue = 1800500, allocationSize=1)
	@GeneratedValue(generator="Agen1", strategy = GenerationType.SEQUENCE)
	private int accountid;
	
	
	private int accountNumber;
	
	private String accountHolderName;
	
	private String iFSCCode;
	
	private String mobileNumber;
	
	private String address;
	
	private int currentBalance;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accountid, int accountNumber, String accountHolderName, String iFSCCode, String mobileNumber,
			String address, int currentBalance) {
		super();
		this.accountid = accountid;
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.iFSCCode = iFSCCode;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.currentBalance = currentBalance;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public int getaccountNumber() {
		return accountNumber;
	}

	public void setaccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getiFSCCode() {
		return iFSCCode;
	}

	public void setiFSCCode(String iFSCCode) {
		this.iFSCCode = iFSCCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}
}

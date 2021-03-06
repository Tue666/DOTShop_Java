package com.dotshop.DAL;

import com.dotshop.Models.AccountModel;

public interface IAccountDAL {
	
	AccountModel findById(int accountId);
	
	int updateAccount(int accountId, String name, String gender, String address, String email);
	
	AccountModel signIn(String phone,String password);
	
	AccountModel getInfosignIn(String phone);
	
	int signUp(String phone, String password, String role, String status);
	
	AccountModel checkPhoneExisted(String phone);
	
	AccountModel checkOldPassword (String oldpassword,int accountId);
	
	int changePassword(String password, int accountId);
		
}

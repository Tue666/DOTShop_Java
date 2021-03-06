package com.dotshop.DAL.Implement;

import com.dotshop.DAL.IAccountDAL;
import com.dotshop.Mapper.AccountMapper;
import com.dotshop.Models.AccountModel;

public class AccountDAL extends AbstractDAL implements IAccountDAL {

	@Override
	public AccountModel findById(int accountId) {
		
		String query = "SELECT * FROM account WHERE id_account = " + accountId;
		
		return ExecuteOne(query, new AccountMapper());
	}

	@Override
	public int updateAccount(int accountId, String name, String gender, String address, String email) {

		String query = "UPDATE account SET name = ?, gender = ?, address = ?, email = ? WHERE id_account = ? ";
		return ExecuteUpdate(query,name, gender, address, email, accountId);

	}

	@Override
	public AccountModel signIn(String phone, String password) {
		String query = "SELECT * FROM account WHERE phone = ? AND password =?";
		return ExecuteOne(query,new AccountMapper(),phone,password);
	}

	@Override
	public AccountModel getInfosignIn(String phone) {
		String query = "SELECT * FROM account WHERE phone = ?";
		return ExecuteOne(query,new AccountMapper(),phone);
	}

	@Override
	public int signUp(String phone, String password, String role, String status) {
		String query = "INSERT INTO account(phone, password, typeaccount, status) VALUES (?, ?, ?, ?)";
		return ExecuteInsert(query, phone, password, role, status);
	}

	@Override
	public AccountModel checkPhoneExisted(String phone) {
		String query = "SELECT * FROM account WHERE phone = ?";
		return ExecuteOne(query,new AccountMapper(),phone);
	}

	@Override
	public AccountModel checkOldPassword(String oldpassword, int accountId) {
		String query = "SELECT * FROM account WHERE password = ? AND id_account = ? ";
		return ExecuteOne(query,new AccountMapper(), oldpassword, accountId);
	}

	@Override
	public int changePassword(String password, int accountId) {
		String query = "UPDATE account SET password = ? WHERE id_account = ? ";
		return ExecuteUpdate(query, password, accountId);
	}
}

package com.neusoft.dao;

import java.sql.SQLException;

import com.neusoft.entity.Account;

public interface AccountDao {
	public Account doLogin(String username,String password);

	public void update(Account acc);
}

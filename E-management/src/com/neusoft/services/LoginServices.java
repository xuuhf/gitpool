package com.neusoft.services;

import com.neusoft.dao.AccountDao;
import com.neusoft.dao.Daofactory;
import com.neusoft.entity.Account;

public class LoginServices {
	/**
	 * 处理登录业务逻辑。
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return true:登录成功
	 */
	public Account doLogin(Account mAccount) {
		AccountDao accDao = Daofactory.getInstance("accountDao", AccountDao.class);
		Account acc = accDao.doLogin(mAccount.getUsername(), mAccount.getPassword());
		if (acc != null) {
			acc.setLoginDate(System.currentTimeMillis());
			accDao.update(acc);
		}
		return acc;
	}
}

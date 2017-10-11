package com.neusoft.services;

import com.neusoft.dao.AccountDao;
import com.neusoft.dao.Daofactory;
import com.neusoft.entity.Account;

public class LoginServices {
	/**
	 * �����¼ҵ���߼���
	 * 
	 * @param username
	 *            �û���
	 * @param password
	 *            ����
	 * @return true:��¼�ɹ�
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

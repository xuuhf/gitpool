package com.neusoft.test;
import com.neusoft.dao.AccountDao;
import com.neusoft.dao.Daofactory;
import com.neusoft.entity.Account;

public class Test {

	public static void main(String[] args) {
		testLogin();
	}

	public static void testLogin() {
		AccountDao accDao = Daofactory.getInstance("accountDao", AccountDao.class);
		Account acc = accDao.doLogin("amy", "18");
		if (acc != null) {
			acc.setLoginDate(System.currentTimeMillis());
			accDao.update(acc);
		}
	}
}

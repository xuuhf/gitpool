package com.neusoft.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.neusoft.dao.AccountDao;
import com.neusoft.entity.Account;
import com.neusoft.util.ConnectionFactory;

public class AccountImpl implements AccountDao{
     private QueryRunner qr = new QueryRunner();
	
     public void update(Account acc) {
    	 Connection conn = null;
    	 String sql= "update account set loginDate=? where id=?";
    	 try {
    		conn = ConnectionFactory.getConnection();
			qr.update(conn, sql, acc.getLoginDate(),acc.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
     }

	@Override
	public Account doLogin(String username, String password) {
		Connection conn = null;
		Account acc=null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql="select id, username,password,loginDate from account where username=? and password=?";
			ResultSetHandler<Account> rsh=new BeanHandler<Account>(Account.class); 
			Object [] params = {username,password};
			 acc = qr.query(conn, sql,rsh,params);
			System.out.println(acc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
		return acc;
	}
	
}

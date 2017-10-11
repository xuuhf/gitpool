package com.neusoft.acc_consumerImpldao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.acc_consumerdao.Acc_consumerDao;
import com.neusoft.entity.Account_consumer;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.util.ConnectionFactory;
import com.neusoft.util.DaoException;

public class Acc_consumerImpl implements Acc_consumerDao{
	QueryRunner qr = new QueryRunner();
	@Override
	public boolean insert(Account_consumer acc_consumer) throws DaoException {
		Connection conn = null;
	    
		try {
			 conn = ConnectionFactory.getConnection();
			String sql = "insert into account_consumer(id,loginname,password,registertime,lastlogintime,IP) value(?,?,?,?,?,?)";
			Object[] params= {acc_consumer.getId(),acc_consumer.getLoginname(),acc_consumer.getPassword(),acc_consumer.getRegistertime(),acc_consumer.getLastlogintime(),acc_consumer.getIP()};
			  int count = qr.update(conn, sql, params);
			  if(count>0) {
				  return true;
			  }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("ÃÌº” ß∞‹",e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		
		return false;
	}

	@Override
	public boolean delete(int id) throws DaoException {
       Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "delete from account_consumer where id=?";
			qr.update(conn, sql, id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("…æ≥˝ ß∞‹",e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
	
		return false;
	}

	@Override
	public boolean update(Account_consumer acc_consumer) throws DaoException {
        Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql ="update account_consumer set id=?,loginname=?,password=?,registertime=?,lastlogintime=?,IP=?  where id=?";
			int count = qr.update(conn, sql,acc_consumer.getId(),acc_consumer.getLoginname(),acc_consumer.getPassword(),acc_consumer.getRegistertime(),acc_consumer.getLastlogintime(),acc_consumer.getIP(),acc_consumer.getId());
			if(count>0) {
				  return true;
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("–ﬁ∏ƒ ß∞‹",e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		
		return false;
	}

	@Override
	public Account_consumer select(int id) throws DaoException {
		Connection conn = null;
		Account_consumer acc_consumer = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id,loginname,password,registertime,lastlogintime,IP from acc_consumer where id=?";
			ResultSetHandler<Account_consumer> rsh = new BeanHandler<Account_consumer>(Account_consumer.class);
			Object[] params = {id};
			acc_consumer=qr.query(conn, sql, rsh, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("≤È—Ø ß∞‹",e);
		}
		  finally {
			DbUtils.closeQuietly(conn);
		}
		return acc_consumer;
		
	}

	@Override
	public PageModel<Account_consumer> getPageModel(int pageNo, int totalPageNo) throws DaoException {
		Connection conn = null;
		 PageModel<Account_consumer>  model=null;
		try {
			conn = ConnectionFactory.getConnection();
			String totalRecords_sql="select count(id) from account_consumer";
			ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
            int totalRecords=qr.query(conn, totalRecords_sql, rsh).intValue();
			
			if(totalRecords>0) {
				model=new PageModel<Account_consumer>();
				model.setTotalRecords(totalRecords);
				
				String sql="select id,loginname,password,registertime,lastlogintime,IP from account_consumer order by id desc limit ?,? ";
			    Object[] params= {(pageNo-1)*totalPageNo,totalPageNo};
				List<Account_consumer> acclist=qr.query(conn, sql, new BeanListHandler<Account_consumer>(Account_consumer.class), params);
			 
				model.setList(acclist);
			}
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("∑÷“≥≤È—Ø ß∞‹");
		}finally {
			DbUtils.closeQuietly(conn);
		}

		return model;
	}

	@Override
	public List<Account_consumer> selectList() throws DaoException {
List<Account_consumer> list = new ArrayList<Account_consumer>();
		
		Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id,loginname,password,registertime,lastlogintime,IP from account_cosumer";
			
			ResultSetHandler<Account_consumer> rsh = new BeanHandler<Account_consumer>(Account_consumer.class);
			Object [] params = {};
 		  qr.query(conn,sql, rsh, params);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		return list;
	}

	@Override
	public Account_consumer selectByName(String username, String password) throws DaoException {
		Connection conn = null;
		Account_consumer acc =null; 
		try {
			conn = ConnectionFactory.getConnection();
		    String sql = "select * from account_consumer where loginname=? and password=?";
		    ResultSetHandler <Account_consumer> rsh = new BeanHandler<Account_consumer>(Account_consumer.class);
		    Object [] params = {username,password};
		  acc =  qr.query(conn, sql, rsh, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc ;
	}

}

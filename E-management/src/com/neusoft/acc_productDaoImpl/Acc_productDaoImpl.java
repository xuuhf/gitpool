package com.neusoft.acc_productDaoImpl;

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

import com.neusoft.acc_productDao.Acc_productDao;
import com.neusoft.entity.Acc_product;
import com.neusoft.entity.Account_consumer;
import com.neusoft.entity.PageModel;
import com.neusoft.util.ConnectionFactory;
import com.neusoft.util.DaoException;

public class Acc_productDaoImpl implements Acc_productDao{
	QueryRunner qr = new QueryRunner();
	@Override
	public boolean insert(Acc_product acc_product) throws DaoException {
Connection conn = null;
	    
		try {
			 conn = ConnectionFactory.getConnection();
			String sql = "insert into account_product(id,loginname,password,registertime,lastlogintime,IP) value(?,?,?,?,?,?)";
			Object[] params= {acc_product.getId(),acc_product.getLoginname(),acc_product.getPassword(),acc_product.getRegistertime(),acc_product.getLastlogintime(),acc_product.getIP()};
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
				String sql = "delete from account_product where id=?";
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
	public boolean update(Acc_product acc_product) throws DaoException {
Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql ="update account_product set id=?,loginname=?,password=?,registertime=?,lastlogintime=?,IP=?  where id=?";
			int count = qr.update(conn, sql,acc_product.getId(),acc_product.getLoginname(),acc_product.getPassword(),acc_product.getRegistertime(),acc_product.getLastlogintime(),acc_product.getIP(),acc_product.getId());
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
	public Acc_product select(int id) throws DaoException {
		Connection conn = null;
		Acc_product acc_product = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id,loginname,password,registertime,lastlogintime,IP from account_product where id=?";
			ResultSetHandler<Acc_product> rsh = new BeanHandler<Acc_product>(Acc_product.class);
			Object[] params = {id};
			acc_product=qr.query(conn, sql, rsh, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("≤È—Ø ß∞‹",e);
		}
		  finally {
			DbUtils.closeQuietly(conn);
		}
		return acc_product;
	}

	@Override
	public PageModel<Acc_product> getPageModel(int pageNo, int totalPageNo) throws DaoException {
		Connection conn = null;
		 PageModel<Acc_product>  model=null;
		try {
			conn = ConnectionFactory.getConnection();
			String totalRecords_sql="select count(id) from account_product";
			ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
           int totalRecords=qr.query(conn, totalRecords_sql, rsh).intValue();
			
			if(totalRecords>0) {
				model=new PageModel<Acc_product>();
				model.setTotalRecords(totalRecords);
				
				String sql="select id,loginname,password,registertime,lastlogintime,IP from account_product order by id desc limit ?,? ";
			    Object[] params= {(pageNo-1)*totalPageNo,totalPageNo};
				List<Acc_product> acclist=qr.query(conn, sql, new BeanListHandler<Acc_product>(Acc_product.class), params);
			 
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
	public List<Acc_product> selectList() throws DaoException {
List<Acc_product> list = new ArrayList<Acc_product>();
		
		Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id,loginname,password,registertime,lastlogintime,IP from account_product";
			
			ResultSetHandler<Acc_product> rsh = new BeanHandler<Acc_product>(Acc_product.class);
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

}

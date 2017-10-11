package com.neusoft.shoppinginfoDaoImpl;

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

import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Shoppinginfo;
import com.neusoft.shoppinginfoDao.ShoppinginfoDao;
import com.neusoft.util.ConnectionFactory;
import com.neusoft.util.DaoException;

public class ShoppinginfoDaoImpl implements ShoppinginfoDao{
	QueryRunner qr = new QueryRunner();
	@Override
	public boolean insert(Shoppinginfo shoppinginfo) throws DaoException {
		
			Connection conn = null;
		    
			try {
				 conn = ConnectionFactory.getConnection();
				String sql = "insert into shoppinginfo_consumer(aid,nickname,money,lasttime) value(?,?,?,?)";
				Object[] params= {shoppinginfo.getAid(),shoppinginfo.getNickname(),shoppinginfo.getMoney(),shoppinginfo.getLasttime()};
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
			String sql = "delete from shoppinginfo_consumer where id=?";
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
	public boolean update(Shoppinginfo shoppinginfo) throws DaoException {
Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql ="update shoppinginfo_consumer set aid=?,nickname=?,money=?,lasttime=? where id=?";
			int count = qr.update(conn, sql,shoppinginfo.getAid(),shoppinginfo.getNickname(),shoppinginfo.getMoney(),shoppinginfo.getLasttime(),shoppinginfo.getId() );
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
	public Shoppinginfo select(int id) throws DaoException {
		Connection conn = null;
		Shoppinginfo shoppinginfo = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id,aid,nickname,money,lasttime from shoppinginfo_consumer where id=?";
			ResultSetHandler<Shoppinginfo> rsh = new BeanHandler<Shoppinginfo>(Shoppinginfo.class);
			Object[] params = {id};
			shoppinginfo=qr.query(conn, sql, rsh, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("≤È—Ø ß∞‹",e);
		}
		  finally {
			DbUtils.closeQuietly(conn);
		}
		return shoppinginfo;
	}

	@Override
	public PageModel<Shoppinginfo> getPageModel(int pageNo, int totalPageNo) throws DaoException {
		Connection conn = null;
		 PageModel<Shoppinginfo>  model=null;
		try {
			conn = ConnectionFactory.getConnection();
			String totalRecords_sql="select count(id) from shoppinginfo_consumer";
			ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
     int totalRecords=qr.query(conn, totalRecords_sql, rsh).intValue();
			
			if(totalRecords>0) {
				model=new PageModel<Shoppinginfo>();
				model.setTotalRecords(totalRecords);
				
				String sql="select id, aid ,nickname,money,lasttime from shoppinginfo_consumer order by id desc limit ?,? ";
			    Object[] params= {(pageNo-1)*totalPageNo,totalPageNo};
				List<Shoppinginfo> shoppinginfolist=qr.query(conn, sql, new BeanListHandler<Shoppinginfo>(Shoppinginfo.class), params);
			 
				model.setList(shoppinginfolist);
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
	public List<Shoppinginfo> selectList() throws DaoException {
List<Shoppinginfo> list = new ArrayList<Shoppinginfo>();
		
		Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select aid,nickname,money,lasttime from shoppinginfo_consumer";
			
			ResultSetHandler<Shoppinginfo> rsh = new BeanHandler<Shoppinginfo>(Shoppinginfo.class);
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

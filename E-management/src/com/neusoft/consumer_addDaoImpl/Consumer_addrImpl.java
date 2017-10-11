package com.neusoft.consumer_addDaoImpl;

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

import com.neusoft.consumer_addDao.Consumer_addrDao;
import com.neusoft.entity.Cate;
import com.neusoft.entity.Consumer_addr;
import com.neusoft.entity.PageModel;
import com.neusoft.util.ConnectionFactory;
import com.neusoft.util.DaoException;

public class Consumer_addrImpl implements Consumer_addrDao{
	QueryRunner qr = new QueryRunner();
	@Override
	public boolean insert(Consumer_addr consumer_addr) throws DaoException {
		 Connection conn = null;
		    
			try {
				 conn = ConnectionFactory.getConnection();
				String sql = "insert into consumer_addr(  name,addr, phone, provice,city, area) value(?,?,?,?,?,?)";
				Object[] params= {consumer_addr.getName(),consumer_addr.getAddr(),consumer_addr.getProvice(),consumer_addr.getPhone(),consumer_addr.getCity(),consumer_addr.getArea()};
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
			String sql = "delete from consumer_addr where id=?";
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
	public boolean update(Consumer_addr consumer_addr) throws DaoException {
Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql ="update consumer_addr set name=?,addr=?, phone=?, provice=?,city=?, area=?  where id=?";
			int count = qr.update(conn, sql, consumer_addr.getName(),consumer_addr.getAddr(),consumer_addr.getProvice(),consumer_addr.getPhone(),consumer_addr.getCity(),consumer_addr.getArea(),consumer_addr.getArea());
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
	public Consumer_addr select(int id) throws DaoException {
		Connection conn = null;
		Consumer_addr consumer_addr = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id, name,addr, phone, provice,city, area from consumer_addr where id=?";
			ResultSetHandler<Consumer_addr> rsh = new BeanHandler<Consumer_addr>(Consumer_addr.class);
			Object[] params = {id};
			consumer_addr=qr.query(conn, sql, rsh, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("≤È—Ø ß∞‹",e);
		}
		  finally {
			DbUtils.closeQuietly(conn);
		}
		return consumer_addr;
	}

	@Override
	public PageModel<Consumer_addr> getPageModel(int pageNo, int totalPageNo) throws DaoException {
		Connection conn = null;
		 PageModel<Consumer_addr>  model=null;
		try {
			conn = ConnectionFactory.getConnection();
			String totalRecords_sql="select count(id) from consumer_addr";
			ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
     int totalRecords=qr.query(conn, totalRecords_sql, rsh).intValue();
			
			if(totalRecords>0) {
				model=new PageModel<Consumer_addr>();
				model.setTotalRecords(totalRecords);
				
				String sql="select id, name,addr, phone, provice,city, area from consumer_addr order by id desc limit ?,? ";
			    Object[] params= {(pageNo-1)*totalPageNo,totalPageNo};
				List<Consumer_addr> conslist=qr.query(conn, sql, new BeanListHandler<Consumer_addr>(Consumer_addr.class), params);
			 
				model.setList(conslist);
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
	public List<Consumer_addr> selectList() throws DaoException {
List<Consumer_addr> list = new ArrayList<Consumer_addr>();
		
		Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id, name, addr, phone, provice,city, area from consumer_addr";
			
			ResultSetHandler<Consumer_addr> rsh = new BeanHandler<Consumer_addr>(Consumer_addr.class);
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

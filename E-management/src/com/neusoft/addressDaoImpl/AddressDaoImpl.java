package com.neusoft.addressDaoImpl;

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

import com.neusoft.addressDao.AddressDao;
import com.neusoft.entity.Address;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.util.ConnectionFactory;
import com.neusoft.util.DaoException;

public class AddressDaoImpl implements AddressDao{
	QueryRunner qr = new QueryRunner();
	
	@Override
	public boolean insert(Address address) throws DaoException {
		 Connection conn = null;
		    
			try {
				 conn = ConnectionFactory.getConnection();
				String sql = "insert into address(province,city,area) value(?,?,?)";
				Object[] params= {address.getProvince(),address.getCity(),address.getArea()};
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
			String sql = "delete from address where id=?";
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
	public boolean update(Address address) throws DaoException {
Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql ="update address set province=? ,city=? area=? where id=?";
			int count = qr.update(conn, sql, address.getProvince(),address.getCity(),address.getArea());
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
	public Address select(int id) throws DaoException {
		Connection conn = null;
		Address address = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select province ,city,area from address where id=?";
			ResultSetHandler<Address> rsh = new BeanHandler<Address>(Address.class);
			Object[] params = {id};
			address=qr.query(conn, sql, rsh, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("≤È—Ø ß∞‹",e);
		}
		  finally {
			DbUtils.closeQuietly(conn);
		}
		return address;
	}

	@Override
	public PageModel<Address> getPageModel(int pageNo, int totalPageNo) throws DaoException {
		Connection conn = null;
		 PageModel<Address>  model=null;
		try {
			conn = ConnectionFactory.getConnection();
			String totalRecords_sql="select count(id) from address";
			ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
     int totalRecords=qr.query(conn, totalRecords_sql, rsh).intValue();
			
			if(totalRecords>0) {
				model=new PageModel<Address>();
				model.setTotalRecords(totalRecords);
				
				String sql="select id , province ,city,area from address order by id desc limit ?,? ";
			    Object[] params= {(pageNo-1)*totalPageNo,totalPageNo};
				List<Address> addlist=qr.query(conn, sql, new BeanListHandler<Address>(Address.class), params);
			 
				model.setList(addlist);
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
	public List<Address> selectList() throws DaoException {
List<Address> list = new ArrayList<Address>();
		
		Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id , province ,city,area from Address";
			
			ResultSetHandler<Address> rsh = new BeanHandler<Address>(Address.class);
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

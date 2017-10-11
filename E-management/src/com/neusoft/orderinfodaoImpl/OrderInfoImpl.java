package com.neusoft.orderinfodaoImpl;

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

import com.neusoft.entity.OrderInfo;
import com.neusoft.entity.PageModel;
import com.neusoft.orderinfodao.OrderInfoDao;
import com.neusoft.util.ConnectionFactory;
import com.neusoft.util.DaoException;

public class OrderInfoImpl implements OrderInfoDao{
	QueryRunner qr = new QueryRunner();
	@Override
	public boolean insert(OrderInfo orderinfo) throws DaoException {
		 Connection conn = null;
		    
			try {
				 conn = ConnectionFactory.getConnection();
				String sql = "insert into orderinfo( orderno,orderstatus,paystatus, ordertime, paytime ,addrinto,mask) value(?,?,?,?,?,?,?)";
				Object[] params= {orderinfo.getOrderno(),orderinfo.getOrderstatus(),orderinfo.getPaystatus(),orderinfo.getOrdertime(),orderinfo.getPaytime(),orderinfo.getOrderno(),orderinfo.getMask()};
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
			String sql = "delete from orderinfo where id=?";
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
	public boolean update(OrderInfo orderinfo) throws DaoException {
Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql ="update orderinfo set orderno=?,orderstatus=?,paystatus=?, ordertime=?, paytime=? ,addrinto=?,mask=?  where id=?";
			int count = qr.update(conn, sql, orderinfo.getOrderno(),orderinfo.getOrderstatus(),orderinfo.getPaystatus(),orderinfo.getOrdertime(),orderinfo.getPaytime(),orderinfo.getAddrinto(),orderinfo.getMask(),orderinfo.getId());
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
	public OrderInfo select(int id) throws DaoException {
		Connection conn = null;
		OrderInfo cate = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select orderno,orderstatus,paystatus, ordertime, paytime ,addrinto,mask from orderinfo where id=?";
			ResultSetHandler<OrderInfo> rsh = new BeanHandler<OrderInfo>(OrderInfo.class);
			Object[] params = {id};
			cate=qr.query(conn, sql, rsh, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("≤È—Ø ß∞‹",e);
		}
		  finally {
			DbUtils.closeQuietly(conn);
		}
		return cate;
	}

	@Override
	public PageModel<OrderInfo> getPageModel(int pageNo, int totalPageNo) throws DaoException {
		Connection conn = null;
		 PageModel<OrderInfo>  model=null;
		try {
			conn = ConnectionFactory.getConnection();
			String totalRecords_sql="select count(id) from orderinfo";
			ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
     int totalRecords=qr.query(conn, totalRecords_sql, rsh).intValue();
			
			if(totalRecords>0) {
				model=new PageModel<OrderInfo>();
				model.setTotalRecords(totalRecords);
				
				String sql="select orderno,orderstatus,paystatus, ordertime, paytime ,addrinto,mask from orderinfo  order by id desc limit ?,? ";
			    Object[] params= {(pageNo-1)*totalPageNo,totalPageNo};
				List<OrderInfo> orderlist=qr.query(conn, sql, new BeanListHandler<OrderInfo>(OrderInfo.class), params);
			 
				model.setList(orderlist);
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
	public List<OrderInfo> selectList() throws DaoException {
List<OrderInfo> list = new ArrayList<OrderInfo>();
		
		Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id, orderno,orderstatus,paystatus, ordertime, paytime ,addrinto,mask from orderinfo from orderinfo";
			
			ResultSetHandler<OrderInfo> rsh = new BeanHandler<OrderInfo>(OrderInfo.class);
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

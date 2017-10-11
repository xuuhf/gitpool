package com.neusoft.product_orderDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product_orderinfor;
import com.neusoft.product_orderDao.Product_orderinforDao;
import com.neusoft.util.ConnectionFactory;
import com.neusoft.util.DaoException;

public class Product_orderImpl implements Product_orderinforDao{
	QueryRunner qr = new QueryRunner();
	@Override
	public boolean insert(Product_orderinfor product_orderfor) throws DaoException {
		 Connection conn = null;
		    
			try {
				 conn = ConnectionFactory.getConnection();
				String sql = "insert into product_orderinfor(orderid, productid) value(?,?)";
				Object[] params= {product_orderfor.getOrderid(),product_orderfor.getProductid()};
				  int count = qr.update(conn, sql, params);
				  if(count>0) {
					  return true;
				  }
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new DaoException("Ìí¼ÓÊ§°Ü",e);
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
			String sql = "delete from product_orderinfor where id=?";
			qr.update(conn, sql, id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("É¾³ýÊ§°Ü",e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
	
		return false;
	}

	@Override
	public boolean update(Product_orderinfor product_orderfor) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product_orderinfor select(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel<Product_orderinfor> getPageModel(int pageNo, int totalPageNo) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product_orderinfor> selectList() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.neusoft.productdaoImpl;

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
import com.neusoft.entity.Product;
import com.neusoft.productdao.ProductDao;
import com.neusoft.util.ConnectionFactory;
import com.neusoft.util.DaoException;

public class ProductDaoImpl implements ProductDao {
	QueryRunner qr = new QueryRunner();
	Connection conn = null;

	@Override
	public boolean insert(Product product) throws DaoException {
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "insert into product(pname,cid,pno,pic,price,online) value(?,?,?,?,?,?)";
			Object[] params = { product.getPname(), product.getCid(), product.getPno(), product.getPic(),
					product.getPrice(), product.getOnline() };
			int count = qr.update(conn, sql, params);
			if (count > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("ÃÌº” ß∞‹", e);
		} finally {
			DbUtils.closeQuietly(conn);
		}

		return false;
	}

	@Override
	public List<Product> selectList() throws DaoException {
		List<Product> list = new ArrayList<Product>();

		Connection conn = null;

		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id,pname,cid,pno,pic,price,online from Cate";

			ResultSetHandler<Product> rsh = new BeanHandler<Product>(Product.class);
			Object[] params = {};
			qr.query(conn, sql, rsh, params);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return list;
	}

	@Override
	public boolean delete(int cid) throws DaoException {
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "delete from product where id=?";
			qr.update(conn, sql, cid);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("…æ≥˝ ß∞‹", e);
		} finally {
			DbUtils.closeQuietly(conn);
		}

		return false;

	}

	@Override
	public boolean update(Product product) throws DaoException {
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "update product set pname=? ,cid=? ,pno=?,pic=?,price=?,online=? where id=?";
			int count = qr.update(conn, sql, product.getPname(), product.getCid(), product.getPno(), product.getPic(),
					product.getPrice(), product.getOnline(),product.getId());
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("–ﬁ∏ƒ ß∞‹", e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return false;
	}

	@Override
	public PageModel<Product> getPageModel(int pageNo, int totalPageNo) throws DaoException {

		PageModel<Product> model = null;
		try {
			conn = ConnectionFactory.getConnection();
			String totalRecords_sql = "select count(id) from product";
			ResultSetHandler<Long> rsh = new ScalarHandler<Long>();
			int totalRecords = qr.query(conn, totalRecords_sql, rsh).intValue();
			if (totalRecords > 0) {
				model = new PageModel<Product>();
				model.setTotalRecords(totalRecords);

				String sql = "select id,pname,cid,pno,pic,price,online from product  order by id desc limit ?,?";
				Object[] params = { (pageNo - 1) * totalPageNo, totalPageNo };
				List<Product> prolist = qr.query(conn, sql, params, new BeanListHandler<Product>(Product.class));
				model.setList(prolist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;
	}

	@Override
	public Product select(int id) throws DaoException {
		Connection conn = null;
		Product product = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id,pname,cid,pno,pic,price,online from product where id=?";
			ResultSetHandler<Product> rsh = new BeanHandler<Product>(Product.class);
			Object[] params = {id};
			product=qr.query(conn, sql, rsh, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("≤È—Ø ß∞‹",e);
		}
		  finally {
			DbUtils.closeQuietly(conn);
		}
		return product;
	}

	@Override
	public PageModel<Product> getPageModelByCid(int cid, int pageNo, int totalPageNo) throws DaoException {
		PageModel<Product> model = null;
		try {
			conn = ConnectionFactory.getConnection();
			String totalRecords_sql = "select count(id) from product where cid=?";
			ResultSetHandler<Long> rsh = new ScalarHandler<Long>();
			int totalRecords = qr.query(conn, totalRecords_sql, rsh,cid).intValue();
			if (totalRecords > 0) {
				model = new PageModel<Product>();
				model.setTotalRecords(totalRecords);

				String sql = "select id,pname,cid,pno,pic,price,online from product where cid=? order by id desc limit ?,?";
				Object[] params = {cid, (pageNo - 1) * totalPageNo, totalPageNo };
				List<Product> prolist = qr.query(conn, sql, params, new BeanListHandler<Product>(Product.class));
				model.setList(prolist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;
	}
	}
	


package com.neusoft.catedaoImpl;

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

import com.neusoft.catedao.CateDao;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.util.ConnectionFactory;
import com.neusoft.util.DaoException;

public class CateImpl implements CateDao{
	QueryRunner qr = new QueryRunner();
	
	@Override
	public boolean insert(Cate cate)throws DaoException {
		    Connection conn = null;
		    
		try {
			 conn = ConnectionFactory.getConnection();
			String sql = "insert into Cate(cname,pid) value(?,?)";
			Object[] params= {cate.getCname(),cate.getPid()};
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
	public boolean delete(int cid) throws DaoException{
		Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "delete from Cate where cid=?";
			qr.update(conn, sql, cid);
			
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
	public boolean update(Cate cate)throws DaoException {
		Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql ="update Cate set cname=? ,pid=?  where cid=?";
			int count = qr.update(conn, sql, cate.getCname(),cate.getPid(),cate.getCid());
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
	public Cate select(int cid)throws DaoException {
		Connection conn = null;
		Cate cate = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select cid,cname,pid from cate where cid=?";
			ResultSetHandler<Cate> rsh = new BeanHandler<Cate>(Cate.class);
			Object[] params = {cid};
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
	public PageModel<Cate> getPageModel(int pageNo, int totalPageNo) throws DaoException {
		Connection conn = null;
		 PageModel<Cate>  model=null;
		try {
			conn = ConnectionFactory.getConnection();
			String totalRecords_sql="select count(cid) from Cate";
			ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
      int totalRecords=qr.query(conn, totalRecords_sql, rsh).intValue();
			
			if(totalRecords>0) {
				model=new PageModel<Cate>();
				model.setTotalRecords(totalRecords);
				
				String sql="select cid ,cname,pid from Cate order by cid desc limit ?,? ";
			    Object[] params= {(pageNo-1)*totalPageNo,totalPageNo};
				List<Cate> catelist=qr.query(conn, sql, new BeanListHandler<Cate>(Cate.class), params);
			 
				model.setList(catelist);
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
	public List<Cate> selectList() throws DaoException {
		
		List<Cate> list = new ArrayList<Cate>();
		
		Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select cid,cname,pid from Cate";
			
			ResultSetHandler<Cate> rsh = new BeanHandler<Cate>(Cate.class);
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
	public List<Cate> selectBypid(int pid) throws DaoException {
		
		Connection conn = null;
		List<Cate> cate = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select cid,cname,pid from Cate where pid=?";
			ResultSetHandler<List<Cate>> rsh = new BeanListHandler<Cate>(Cate.class);
			Object [] params = {pid};
		cate = qr.query(conn ,sql, rsh, params);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}

		return cate;
	}

	}



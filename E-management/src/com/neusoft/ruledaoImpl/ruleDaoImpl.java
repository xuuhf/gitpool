package com.neusoft.ruledaoImpl;

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

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Rule;
import com.neusoft.ruledao.RuleDao;
import com.neusoft.util.ConnectionFactory;
import com.neusoft.util.DaoException;

public class ruleDaoImpl implements RuleDao{
	QueryRunner qr = new QueryRunner();

	@Override
	public boolean insert(Rule rule) throws DaoException {
		 Connection conn = null;
		    
			try {
				 conn = ConnectionFactory.getConnection();
				String sql = "insert into rule(pid,size) value(?,?)";
				Object[] params= {rule.getPid(),rule.getSize()};
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
			String sql = "delete from rule where id=?";
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
	public boolean update(Rule rule) throws DaoException {
          Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql ="update rule set pid=? ,size=?  where id=?";
			int count = qr.update(conn, sql, rule.getPid(),rule.getSize(),rule.getId());
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
	public Rule select(int id) throws DaoException {
		Connection conn = null;
		Rule rule = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id,pid,size from rule where id=?";
			ResultSetHandler<Rule> rsh = new BeanHandler<Rule>(Rule.class);
			Object[] params = {id};
			rule=qr.query(conn, sql, rsh, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("≤È—Ø ß∞‹",e);
		}
		  finally {
			DbUtils.closeQuietly(conn);
		}
		return rule;
	}

	@Override
	public PageModel<Rule> getPageModel(int pageNo, int totalPageNo) throws DaoException {
		Connection conn = null;
		 PageModel<Rule>  model=null;
		try {
			conn = ConnectionFactory.getConnection();
			String totalRecords_sql="select count(id) from rule";
			ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
     int totalRecords=qr.query(conn, totalRecords_sql, rsh).intValue();
			
			if(totalRecords>0) {
				model=new PageModel<Rule>();
				model.setTotalRecords(totalRecords);
				
				String sql="select id ,pid,size from Rule order by id desc limit ?,? ";
			    Object[] params= {(pageNo-1)*totalPageNo,totalPageNo};
				List<Rule> rulelist=qr.query(conn, sql, new BeanListHandler<Rule>(Rule.class), params);
			 
				model.setList(rulelist);
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
	public List<Rule> selectList() throws DaoException {
        List<Rule> list = new ArrayList<Rule>();
		
		Connection conn=null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select id,pid,size from rule";
			
			ResultSetHandler<Rule> rsh = new BeanHandler<Rule>(Rule.class);
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
	public List<Rule> selectBypid(int pid) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
	PageModel	pagemodel = new ruleDaoImpl().getPageModel(1, 1);
	
	System.out.println(pagemodel.getList());
		
	}
}
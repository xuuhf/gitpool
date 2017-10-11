package com.neusoft.ruledao;

import java.util.List;


import com.neusoft.entity.PageModel;
import com.neusoft.entity.Rule;
import com.neusoft.util.DaoException;

public interface RuleDao {
	/**
	 * 
	 * @param rule
	 * @return
	 * @throws DaoException
	 */
	public boolean insert(Rule rule) throws DaoException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(int id) throws DaoException;
	/**
	 * 
	 * @param rule
	 * @return
	 * @throws DaoException
	 */
	public boolean update(Rule rule) throws DaoException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public Rule select(int id) throws DaoException;
	/**
	 * 
	 * @param pageNo
	 * @param totalPageNo
	 * @return
	 * @throws DaoException
	 */
	public PageModel<Rule> getPageModel(int pageNo, int totalPageNo)throws DaoException;
	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<Rule> selectList()throws DaoException;
	/**
	 * 
	 * @param pid
	 * @return
	 * @throws DaoException
	 */
	public List<Rule> selectBypid( int pid)throws DaoException;
}

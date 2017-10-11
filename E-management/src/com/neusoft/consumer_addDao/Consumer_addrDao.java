package com.neusoft.consumer_addDao;

import java.util.List;

import com.neusoft.entity.Consumer_addr;
import com.neusoft.entity.PageModel;
import com.neusoft.util.DaoException;

public interface Consumer_addrDao {
	/**
	 * 
	 * @param consumer_addr
	 * @return
	 * @throws DaoException
	 */
	public boolean insert(Consumer_addr consumer_addr) throws DaoException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(int id) throws DaoException;
	/**
	 * 
	 * @param consumer_addr
	 * @return
	 * @throws DaoException
	 */
	public boolean update(Consumer_addr consumer_addr) throws DaoException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public Consumer_addr select(int id) throws DaoException;
	/**
	 * 
	 * @param pageNo
	 * @param totalPageNo
	 * @return
	 * @throws DaoException
	 */
	public PageModel<Consumer_addr> getPageModel(int pageNo, int totalPageNo)throws DaoException;
	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<Consumer_addr> selectList()throws DaoException;
	//public List<Consumer_addr> selectBypid( int pid)throws DaoException; 
}

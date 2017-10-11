package com.neusoft.shoppinginfoDao;

import java.util.List;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Shoppinginfo;
import com.neusoft.util.DaoException;

public interface ShoppinginfoDao {
	/**
	 * 
	 * @param shoppinginfo
	 * @return
	 * @throws DaoException
	 */
	public boolean insert(Shoppinginfo shoppinginfo) throws DaoException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(int id) throws DaoException;
	/**
	 * 
	 * @param shoppinginfo
	 * @return
	 * @throws DaoException
	 */
	public boolean update(Shoppinginfo shoppinginfo) throws DaoException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public Shoppinginfo select(int id) throws DaoException;
	/**
	 * 
	 * @param pageNo
	 * @param totalPageNo
	 * @return
	 * @throws DaoException
	 */
	public PageModel<Shoppinginfo> getPageModel(int pageNo, int totalPageNo)throws DaoException;
	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<Shoppinginfo> selectList()throws DaoException;
}

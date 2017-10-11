package com.neusoft.acc_productDao;

import java.util.List;

import com.neusoft.entity.Acc_product;

import com.neusoft.entity.PageModel;
import com.neusoft.util.DaoException;

public interface Acc_productDao {
	/**
	 * 
	 * @param acc_product
	 * @return
	 * @throws DaoException
	 */
	public boolean insert(Acc_product acc_product) throws DaoException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(int id) throws DaoException;
	/**
	 * 
	 * @param acc_product
	 * @return
	 * @throws DaoException
	 */
	public boolean update(Acc_product acc_product) throws DaoException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public Acc_product select(int id) throws DaoException;
	/**
	 * 
	 * @param pageNo
	 * @param totalPageNo
	 * @return
	 * @throws DaoException
	 */
	public PageModel<Acc_product> getPageModel(int pageNo, int totalPageNo)throws DaoException;
	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<Acc_product> selectList()throws DaoException;
}

package com.neusoft.product_orderDao;

import java.util.List;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product_orderinfor;
import com.neusoft.util.DaoException;

public interface Product_orderinforDao {
	/**
	 * 
	 * @param product_orderfor
	 * @return
	 * @throws DaoException
	 */
	public boolean insert(Product_orderinfor product_orderfor) throws DaoException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(int id) throws DaoException;
	/**
	 * 
	 * @param product_orderfor
	 * @return
	 * @throws DaoException
	 */
	public boolean update(Product_orderinfor product_orderfor) throws DaoException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public Product_orderinfor select(int id) throws DaoException;
	/**
	 * 
	 * @param pageNo
	 * @param totalPageNo
	 * @return
	 * @throws DaoException
	 */
	public PageModel<Product_orderinfor> getPageModel(int pageNo, int totalPageNo)throws DaoException;
	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<Product_orderinfor> selectList()throws DaoException;
}

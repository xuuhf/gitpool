package com.neusoft.orderinfodao;

import java.util.List;

import com.neusoft.entity.OrderInfo;
import com.neusoft.entity.PageModel;
import com.neusoft.util.DaoException;

public interface OrderInfoDao {
	/**
	 * 
	 * @param orderinfo
	 * @return
	 * @throws DaoException
	 */
	public boolean insert(OrderInfo orderinfo) throws DaoException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(int id) throws DaoException;
	/**
	 * 
	 * @param orderinfo
	 * @return
	 * @throws DaoException
	 */
	public boolean update(OrderInfo orderinfo) throws DaoException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public OrderInfo select(int id) throws DaoException;
	/**
	 * 
	 * @param pageNo
	 * @param totalPageNo
	 * @return
	 * @throws DaoException
	 */
	public PageModel<OrderInfo> getPageModel(int pageNo, int totalPageNo)throws DaoException;
	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<OrderInfo> selectList()throws DaoException;
}

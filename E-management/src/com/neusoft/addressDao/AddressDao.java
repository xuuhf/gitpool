package com.neusoft.addressDao;

import java.util.List;

import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;
import com.neusoft.util.DaoException;

public interface AddressDao {
	/**
	 * 
	 * @param address
	 * @return
	 * @throws DaoException
	 */
	public boolean insert(Address  address) throws DaoException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(int id) throws DaoException;
	/**
	 * 
	 * @param address
	 * @return
	 * @throws DaoException
	 */
	public boolean update(Address  address) throws DaoException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public Address select(int id) throws DaoException;
	/**
	 * 
	 * @param pageNo
	 * @param totalPageNo
	 * @return
	 * @throws DaoException
	 */
	public PageModel< Address> getPageModel(int pageNo, int totalPageNo)throws DaoException;
	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List< Address> selectList()throws DaoException;
}

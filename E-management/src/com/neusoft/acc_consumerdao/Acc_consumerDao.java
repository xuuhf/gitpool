package com.neusoft.acc_consumerdao;

import java.util.List;

import com.neusoft.entity.Account_consumer;
import com.neusoft.entity.PageModel;
import com.neusoft.util.DaoException;

public interface Acc_consumerDao {
	/**
	 * 
	 * @param Acc_consumer
	 * @return
	 * @throws DaoException
	 */
	public boolean insert(Account_consumer acc_consumer) throws DaoException;
	/**
	 * 
	 * @param cid
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(int id) throws DaoException;
	/**
	 * 
	 * @param Acc_consumer
	 * @return
	 * @throws DaoException
	 */
	public boolean update(Account_consumer acc_consumer) throws DaoException;
	/**
	 * 
	 * @param cid
	 * @return
	 * @throws DaoException
	 */
	public Account_consumer select(int id) throws DaoException;
	/**
	 * 
	 * @param pageNo
	 * @param totalPageNo
	 * @return
	 * @throws DaoException
	 */
	public PageModel<Account_consumer> getPageModel(int pageNo, int totalPageNo)throws DaoException;
	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<Account_consumer> selectList()throws DaoException;
	/**
	 * 
	 * @param usernme
	 * @param password
	 * @return
	 * @throws DaoException
	 */
	public Account_consumer selectByName(String usernme, String password)throws DaoException;
}

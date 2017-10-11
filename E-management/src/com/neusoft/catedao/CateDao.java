package com.neusoft.catedao;

import java.util.List;

import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.util.DaoException;

public interface CateDao {
	
	/**
	 * 插入类别信息
	 * @param cate 类别对象
	 * @return 返回 true false
	 * @throws DaoException 自定义异常
	 */
	public boolean insert(Cate cate) throws DaoException;
	/**
	 * 删除类别信息
	 * @param cate 类别对象
	 * @return 返回true flase
	 * @throws DaoException 自定义异常
	 */
	public boolean delete(int cid) throws DaoException;
	/**
	 * 修改类别信息
	 * @param cate 类别对象
	 * @return 返回true flase
	 * @throws DaoException 自定义异常
	 */
	public boolean update(Cate cate) throws DaoException;
	/**
	 * 查询类别信息
	 * @param cid 类别id
	 * @return 返回Cate集合
	 * @throws DaoException 自定义异常
	 */
	public Cate select(int cid) throws DaoException;
	/**
	 * 分页查询数据
	 * @param pageNo
	 * @param totalPageNo
	 * @return
	 * @throws DaoException
	 */
	
	 
	public PageModel<Cate> getPageModel(int pageNo, int totalPageNo)throws DaoException;
	
	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<Cate> selectList()throws DaoException;
	
	/**
	 * 通过pid
	 * @param pid
	 * @return
	 * @throws DaoException
	 */
	public List<Cate> selectBypid( int pid)throws DaoException; 
	
      
}

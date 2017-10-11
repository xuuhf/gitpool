package com.neusoft.productdao;


import java.util.List;

import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.util.DaoException;

public interface ProductDao {
	/**
	 * 增加
	 * @param product
	 * @return
	 * @throws DaoException
	 */
	public boolean insert(Product product)throws DaoException;
	
    /**
     * 查询
     * @return
     * @throws DaoException
     */
	
	public List<Product> selectList() throws DaoException ;
     /**
      * 删除
      * @param cid
      * @return
      * @throws DaoException
      */
	
	public boolean delete(int cid) throws DaoException;
	/**
	 * 修改
	 * @param product
	 * @return
	 * @throws DaoException
	 */
	
	public boolean update(Product product)throws DaoException;
	/**
	 * 
	 * @param pageNo
	 * @param totalPageNo
	 * @return
	 * @throws DaoException
	 */
	public  PageModel<Product> getPageModel(int pageNo,int totalPageNo)throws DaoException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public Product select(int id)throws DaoException;
	/**
	 * 
	 * @param cid
	 * @param pageNo
	 * @param totalPageNo
	 * @return
	 * @throws DaoException
	 */
	public  PageModel<Product> getPageModelByCid(int cid,int pageNo,int totalPageNo)throws DaoException;
}







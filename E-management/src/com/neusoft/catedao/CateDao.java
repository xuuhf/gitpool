package com.neusoft.catedao;

import java.util.List;

import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.util.DaoException;

public interface CateDao {
	
	/**
	 * ���������Ϣ
	 * @param cate ������
	 * @return ���� true false
	 * @throws DaoException �Զ����쳣
	 */
	public boolean insert(Cate cate) throws DaoException;
	/**
	 * ɾ�������Ϣ
	 * @param cate ������
	 * @return ����true flase
	 * @throws DaoException �Զ����쳣
	 */
	public boolean delete(int cid) throws DaoException;
	/**
	 * �޸������Ϣ
	 * @param cate ������
	 * @return ����true flase
	 * @throws DaoException �Զ����쳣
	 */
	public boolean update(Cate cate) throws DaoException;
	/**
	 * ��ѯ�����Ϣ
	 * @param cid ���id
	 * @return ����Cate����
	 * @throws DaoException �Զ����쳣
	 */
	public Cate select(int cid) throws DaoException;
	/**
	 * ��ҳ��ѯ����
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
	 * ͨ��pid
	 * @param pid
	 * @return
	 * @throws DaoException
	 */
	public List<Cate> selectBypid( int pid)throws DaoException; 
	
      
}

package com.neusoft.test;

import java.util.List;

import com.neusoft.catedao.CateDao;
import com.neusoft.dao.Daofactory;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;

public class CateTest {
  public static void main(String[] args) {
	 testInsert();
	 // testdelete();
	//testupdate();
	 //  testselect();
	 //testPageModel();
	// testSelectList() ;
	 testSelectBypid();
}
  
  
  public static void testInsert() {
	  CateDao catedao = Daofactory.getInstance("CateDao", CateDao.class);
	  Cate cate = new Cate("°¡°¡°¡",23);
	  System.out.println(catedao.insert(cate));
  }
  public static void testdelete() {
	  CateDao catedao = Daofactory.getInstance("CateDao", CateDao.class);
	  catedao.delete(1);
  }
public static void testupdate() {
	 CateDao catedao = Daofactory.getInstance("CateDao", CateDao.class);
	 Cate cate = catedao.select(3);
	 cate.setCname("ffff");
	 System.out.println(catedao.update(cate));
}

public static void testselect() {
	 CateDao catedao = Daofactory.getInstance("CateDao", CateDao.class);
	 System.out.println(catedao.select(3));
}


public static void testPageModel() {
	 CateDao catedao = Daofactory.getInstance("CateDao", CateDao.class);
	 PageModel<Cate> model = catedao.getPageModel(1,2);
	 System.out.println(model);
}
public static void testSelectList() {
	 CateDao catedao = Daofactory.getInstance("CateDao", CateDao.class);
	 List<Cate> list = catedao.selectList();
	 System.out.println(list);
}
public static void testSelectBypid(){
	CateDao catedao = Daofactory.getInstance("CateDao", CateDao.class);
	System.out.println  ( catedao.selectBypid(0));
}

}



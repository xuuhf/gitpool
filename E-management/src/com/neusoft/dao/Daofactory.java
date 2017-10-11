package com.neusoft.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Daofactory {
	private Daofactory(){}
	 private static Properties ps=new Properties();
	   static{
		   InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("dao.properties");
		   try {
			ps.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	 public static<T> T getInstance(String daoName,Class<T> c){
		 
		 T t=null;
		 if(null == daoName||"".equals(daoName)){
			 return t;
		 }
		 String classname = ps.getProperty(daoName);
		 if(classname == null||"".equals(daoName)){
			 return t;
			 
		 }
		 
		try {
			 Class<?> clazz = Class.forName(classname);
			t = (T)clazz.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return t;
		 
	 }
}

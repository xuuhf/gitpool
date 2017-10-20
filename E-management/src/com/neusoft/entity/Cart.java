package com.neusoft.entity;

import java.util.ArrayList;
import java.util.List;

import com.neusoft.util.MD5Utils;

public class Cart {
    private List<CartItem> items = new ArrayList<CartItem>();

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}
       public void add(CartItem item) {
    	   for(int i=0;i<items.size();i++) {
    		   CartItem ci = items.get(i);
    		   if(ci.getProductId()==item.getProductId()) {
    			   ci.setCount(ci.getCount()+1);
    			   ci.setPrice(ci.getPrice()+item.getPrice());
    			   return;
    		   }
    	   }
    	   items.add(item);
       }
       public void remove(CartItem item) {
    	   for(int i=0;i<items.size();i++) {
    		   CartItem ci = items.get(i);
    		   if(ci.getProductId()==item.getProductId()) {
    			   ci.setCount(ci.getCount()-1);
    		   }
    	   }
    	   items.remove(item);
       } 
       public static void main(String[] args) {
System.out.println(MD5Utils.GetMD5Code("18"));
	}
}

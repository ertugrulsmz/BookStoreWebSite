package com.bookstore.controller.admin.cart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.bookstore.entity.Book;


public class Cart {
	
	private Map<Book,Integer> cartMap=new HashMap<Book,Integer>();
	
	public void addBook(Book book) {
				
		
		if(!cartMap.containsKey(book)) {
			System.out.println("No such element");
			cartMap.put(book,1);
		}
		else {
			System.out.println("there is one at least");
			Integer counterInteger=cartMap.get(book);
			cartMap.put(book,counterInteger+1);
		}
	}
	
	
	public void removeBook(Book book) {
		
		if(cartMap.get(book)==1) {
			cartMap.remove(book);
		}else {
			Integer counterInteger=cartMap.get(book);
			cartMap.put(book,counterInteger-1);
		}
		
	}
	
	public Integer getValue(Book book) {
		return cartMap.get(book);
	}
	
	
	public int totalNumberofBooks() {
		int bookcounter=0;
		Set<Book> bookset=this.cartMap.keySet();
		
		for(Book book:bookset) {
			bookcounter+=cartMap.get(book);
		}
		return bookcounter;
	}
	
	
	public int totalNumberofElements()
	{		
		return cartMap.size();
	}
	
	public float totalPriceofBooks() {
		Set<Entry<Book,Integer>> entrySet=cartMap.entrySet();
		
		float price=0;
		for(Entry<Book,Integer> entry:entrySet) {
			price+=entry.getValue()*
					entry.getKey().getPrice();
		}
		return price;
		
	}
	
	public Map<Book,Integer> getItems()
	{		
		return this.cartMap;
	}
	
	public void ClearAll() {
		this.cartMap.clear();
	}
	
	public void traverse()
	{
		Set<Entry<Book,Integer>> set=this.cartMap.entrySet();
		for(Entry<Book,Integer> entry:set) {
			System.out.println("key : "+entry.getKey());
			System.out.println("value : "+entry.getValue());
			
		}
	}
	
}

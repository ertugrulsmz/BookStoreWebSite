package com.bookstore.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class JpaDao<T> {
	
	private static EntityManagerFactory entityManagerFactory;
	
	static {
		entityManagerFactory=Persistence.createEntityManagerFactory("BookStoreWebsite");
	}
	
	public JpaDao() {
	}
	
	public T create(T entity)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;
	}
	
	public T update (T entity)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();		
		entityManager.getTransaction().begin();
		entity=entityManager.merge(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;
	}
	
	public T find(Class<T> classobj,Object id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		T myentity=entityManager.find(classobj,id);
		if(myentity!=null) {
			entityManager.refresh(myentity);
		}
		entityManager.close();
		return myentity;
	}
	
	public void delete(Class<T> classobj,Object id) { //or you can do it by reference
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Object referenceObject=entityManager.getReference(classobj,id);
		entityManager.getTransaction().begin();
		entityManager.remove(referenceObject);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void delete2(T t) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(t);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public List<T> findAll(String query){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query2=entityManager.createNamedQuery(query);
		List<T> list= query2.getResultList();
		entityManager.close();
		return list;
	}
	
	
	
	public List<T> findbyNamedQuery(String query,String parameter,Object value) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query2=entityManager.createNamedQuery(query);
		query2.setParameter(parameter,value);
		List<T> list= query2.getResultList();
		entityManager.close();
		return list;
	}
	
	public List<T> findbyNamedQuery(String query,Map<String,Object> parameters) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query2=entityManager.createNamedQuery(query);
		Set<Entry<String,Object>> setwithentryMap=parameters.entrySet();
		
		
		for(Entry<String,Object> it:setwithentryMap) {
			query2.setParameter(it.getKey(),it.getValue());
		}
		
		List<T> list= query2.getResultList();
		entityManager.close();
		return list;
	}
	
	public T findsinglebyNamedQuery(String query,Map<String,Object> parameters) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query2=entityManager.createNamedQuery(query);
		Set<Entry<String,Object>> setwithentryMap=parameters.entrySet();
		
		
		for(Entry<String,Object> it:setwithentryMap) {
			query2.setParameter(it.getKey(),it.getValue());
		}
		
		List<T> list= query2.getResultList();
		if(list!=null && list.size()>0)
			return list.get(0);
		
		return null;
	}
	
	
	
	
	
	public long count(String query)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query2=entityManager.createNamedQuery(query);
		long value= (long) query2.getSingleResult();
		entityManager.close();
		return value;
	}
	
	public long count(String query,String parameter,Object id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query2=entityManager.createNamedQuery(query);
		query2.setParameter(parameter,id);
		long value=(long) query2.getSingleResult();
		entityManager.close();
		return value;
	}
	
	public  List<T> listNewObject(String query,int firstresult,int maxresults) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query2=entityManager.createNamedQuery(query);
		query2.setFirstResult(firstresult);
		query2.setMaxResults(maxresults);
		List<T> list=query2.getResultList();
		entityManager.close();
		return list;
	}
	
	
	public  List<Object[]> listNewObjectGroupList(String query,int firstresult,int maxresults) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query2=entityManager.createNamedQuery(query);
		query2.setFirstResult(firstresult);
		query2.setMaxResults(maxresults);
		List<Object[]> list=query2.getResultList();
		entityManager.close();
		return list;
	}
	
	
	
}

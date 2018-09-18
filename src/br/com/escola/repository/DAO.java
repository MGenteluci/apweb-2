package br.com.escola.repository;

import java.util.List;

import javax.persistence.EntityManager;

public interface DAO<T> {

	public EntityManager getEntityManager();
	
	public T create(T object);
	public List<T> findAll();
	public T findById(Object id);
	public void remove(T object);
	
	public void openTransaction();
	public void commitTransaction();
	public void undoTransaction();
}
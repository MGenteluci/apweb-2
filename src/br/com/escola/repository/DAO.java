package br.com.escola.repository;

import java.util.List;

import javax.persistence.EntityManager;

public interface DAO<T> {

	public EntityManager getEntityManager();
	
	public T findById();
	public List<T> findAll();
	
}
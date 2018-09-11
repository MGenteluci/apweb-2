package br.com.escola.repository;

import java.util.List;

import javax.persistence.EntityManager;

public class DAOImpl<T> implements DAO<T> {

	@Override
	public EntityManager getEntityManager() {
		return null;
	}

	@Override
	public T findById() {
		return null;
	}

	@Override
	public List<T> findAll() {
		return null;
	}

}
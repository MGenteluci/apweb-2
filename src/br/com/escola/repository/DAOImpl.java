package br.com.escola.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.escola.conf.JPAUtil;

public abstract class DAOImpl<T> implements DAO<T> {

	protected Class<T> persistentClass;
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public DAOImpl() {
		super();
		
		Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.persistentClass = (Class<T>) type;
		
		this.manager = JPAUtil.getEntityManager();
	}
	
	public DAOImpl(EntityManager manager){
		super();
		this.manager = manager;
	}
	
	@Override
	public EntityManager getEntityManager() {
		if(this.manager != null && !this.manager.isOpen())
			this.manager = JPAUtil.getEntityManager();
		
		return this.manager;
	}

	@Override
	public T findById(Object id) {
		
		return this.getEntityManager().find(this.persistentClass, id);
	}

	@Override
	public List<T> findAll() {
		
		CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> c = cb.createQuery(this.persistentClass);
		c.select(c.from(this.persistentClass));

		List<T> result = this.getEntityManager().createQuery(c).getResultList();
		return result;
	}

	@Override
	public T create(T object) {
		
		boolean transacaoAtiva = this.getEntityManager().getTransaction().isActive();

		if (!transacaoAtiva)
			this.openTransaction();

		object = this.getEntityManager().merge(object);

		if (!transacaoAtiva)
			this.commitTransaction();

		return object;
	}

	@Override
	public void remove(T object) {
		
	}

	@Override
	public void openTransaction() {
		this.getEntityManager().getTransaction().begin();
	}

	@Override
	public void commitTransaction() {
		this.getEntityManager().flush();
		this.getEntityManager().getTransaction().commit();
	}

	@Override
	public void undoTransaction() {
		this.getEntityManager().getTransaction().rollback();
	}

}
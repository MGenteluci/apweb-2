package br.com.escola.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.escola.conf.JPAUtil;
import br.com.escola.models.Parent;

public class ParentDAO {

	private EntityManager manager;
	
	public ParentDAO() {
		super();
		this.manager = JPAUtil.getEntityManager();
	}

	public Parent create(Parent parent) {
		this.manager.getTransaction().begin();
		Parent p = this.manager.merge(parent);
		this.manager.getTransaction().commit();
		return p;
	}
	
	public List<Parent> findAll(){
		String jpql = "from Parent p";
		List<Parent> parents = this.manager.createQuery(jpql, Parent.class).getResultList();
		return parents;
	}
	
}
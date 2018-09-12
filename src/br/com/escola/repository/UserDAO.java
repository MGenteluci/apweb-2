package br.com.escola.repository;

import javax.persistence.EntityManager;

import br.com.escola.conf.JPAUtil;
import br.com.escola.models.User;

public class UserDAO {

	private EntityManager manager;

	public UserDAO() {
		super();
		this.manager = JPAUtil.getEntityManager();
	}
	
	public User findByUsername(String username) {
		String jpql = "FROM User u WHERE u.username = :username";
		
		try {
			return this.manager.createQuery(jpql, User.class)
					.setParameter("username", username)
					.getSingleResult();
		}catch(Exception e) {
			return null;
		}
		
	}

}
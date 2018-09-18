package br.com.escola.repository;

import br.com.escola.models.User;

public class UserDAO extends DAOImpl<User>{
	
	public User findByUsername(String username) {
		String jpql = "FROM User u WHERE u.username = :username";
		
		try {
			return this.getEntityManager().createQuery(jpql, User.class)
					.setParameter("username", username)
					.getSingleResult();
		}catch(Exception e) {
			return null;
		}
		
	}

}
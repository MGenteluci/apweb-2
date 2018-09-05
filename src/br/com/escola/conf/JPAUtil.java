package br.com.escola.conf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory fabrica;

	static {
		fabrica = Persistence.createEntityManagerFactory("banco");
	}

	public static EntityManager getEntityManager() {
		return fabrica.createEntityManager();
	}

}
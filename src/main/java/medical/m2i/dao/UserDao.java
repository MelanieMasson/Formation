package medical.m2i.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import medical.m2i.model.User;

public class UserDao {

	EntityManagerFactory emf;
	EntityManager em;

	public UserDao() {
		super();
		em = DbConnection.getInstance();
	}

	public List<User> getUsers() throws ClassNotFoundException {
		return em.createQuery("from User", User.class).getResultList();
	}

	public List<User> getUsersByUsernameAndPassword(String pusername, String ppassword) throws ClassNotFoundException {
		return em.createNamedQuery("User.findByUsernameAndPassword", User.class).setParameter("username", pusername)
				.setParameter("password", ppassword).getResultList();
	}

}
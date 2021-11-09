package medical.m2i.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import medical.m2i.model.User;

public class UserDao {

	EntityManager em;

	public UserDao() {
		super();
		em = DbConnection.getInstance();

	}

	public int registerUser(User user) throws ClassNotFoundException {
		int id = 0;

		// Récupération d’une transaction
		EntityTransaction tx = em.getTransaction();
		// Début des modifications
		try {
			tx.begin();
			em.persist(user);
			tx.commit();
			id = user.getId();
		} catch (Exception e) {

			tx.rollback();
		} finally {
			// em.close();
			// emf.close();
		}
		System.out.println("id de l'utilisateur : " + id);
		return id;
	}

	public List<User> getUsers() throws ClassNotFoundException {
		return em.createQuery("from User", User.class).getResultList();
	}

	public List<User> getUsersByUsernameAndPassword(String pusername, String ppassword) throws ClassNotFoundException {
		return em.createNamedQuery("User.findByUsernameAndPassword", User.class).setParameter("username", pusername)
				.setParameter("password", ppassword).getResultList();
	}

}
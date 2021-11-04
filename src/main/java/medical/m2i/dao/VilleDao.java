package medical.m2i.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import medical.m2i.model.Ville;

public class VilleDao {

	EntityManagerFactory emf;
	EntityManager em;

	public VilleDao() {
		super();
		emf = Persistence.createEntityManagerFactory("medical7");
		em = emf.createEntityManager();
	}

	public int registerVille(Ville ville) throws ClassNotFoundException {
		int id = 0;

		// Récupération d’une transaction
		EntityTransaction tx = em.getTransaction();
		// Début des modifications
		try {
			tx.begin();
			em.persist(ville);
			tx.commit();
			id = ville.getId();
		} catch (Exception e) {

			tx.rollback();
		} finally {
			// em.close();
			// emf.close();
		}
		System.out.println("id de la ville : " + id);
		return id;
	}

	public List<Ville> getVilles() throws ClassNotFoundException {

		return em.createQuery("from Ville").getResultList();

	}

	public void deleteVille(int id) {
		Ville v = em.find(Ville.class, id);
		// Récupération d’une transaction
		EntityTransaction tx = em.getTransaction();
		// Début des modifications
		try {
			tx.begin();
			em.remove(v);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			// em.close();
			// emf.close();
		}
	}

	public Ville getVille(int id) {
		return em.find(Ville.class, id);
	}

	public void editVille(int id, String pays, String nom, String code_postal) {

		Ville v = em.find(Ville.class, id);

		// Récupération d’une transaction
		EntityTransaction tx = em.getTransaction();

		v.setNom(nom);
		v.setPays(pays);
		v.setCode_postal(code_postal);

		// Début des modifications
		try {
			tx.begin();
			em.persist(v);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			// em.close();
			// emf.close();
		}
	}

	public List<Ville> getVillesByPays(String pays) throws ClassNotFoundException {
		return em.createNamedQuery("Ville.findByPaysName", Ville.class).setParameter("name", pays).getResultList();
	}
}
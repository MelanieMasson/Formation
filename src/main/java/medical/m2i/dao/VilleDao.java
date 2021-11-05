package medical.m2i.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import medical.m2i.model.Ville;

public class VilleDao {

	EntityManagerFactory emf;
	EntityManager em;

	public VilleDao() {
		super();
		em = DbConnection.getInstance();
	}

	public List<Ville> getVilles() throws ClassNotFoundException {
		return em.createQuery("from Ville").getResultList();
	}

	public List<Ville> getVillesByPays(String pays) throws ClassNotFoundException {
		return em.createNamedQuery("Ville.findByPaysName", Ville.class).setParameter("name", pays).getResultList();
	}

}
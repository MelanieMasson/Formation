package medical.m2i.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import medical.m2i.model.Patient;

public class PatientDao {

	EntityManager em;

	public PatientDao() {
		super();
		em = DbConnection.getInstance();
	}

	public int registerPatient(Patient patient) throws ClassNotFoundException {
		int id = 0;

		// Récupération d’une transaction
		EntityTransaction tx = em.getTransaction();
		// Début des modifications
		try {
			tx.begin();
			em.persist(patient);
			tx.commit();
			id = patient.getId();
		} catch (Exception e) {

			tx.rollback();
		} finally {
			// em.close();
			// emf.close();
		}
		System.out.println("id du patient : " + id);
		return id;

	}

	public List<Patient> getPatients() throws ClassNotFoundException {

		return em.createQuery("from Patient").getResultList();

	}

	public void deletePatient(int id) {
		Patient p = em.find(Patient.class, id);
		EntityTransaction tx = em.getTransaction();
		// D�but des modifications
		try {
			tx.begin();
			em.remove(p);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			// em.close();
			// emf.close();
		}
	}

	public Patient getPatient(int id) {
		// TODO Auto-generated method stub
		return em.find(Patient.class, id);
	}

	public void editPatient(int id, String nom, String prenom, String datenaissance, String adresse, String pays,
			String ville) {

		Patient p = em.find(Patient.class, id);
		EntityTransaction tx = em.getTransaction();

		p.setNom(nom);
		p.setPrenom(prenom);
		p.setNaissance(datenaissance);
		p.setAdresse(adresse);
		p.setPays(pays);
		p.setVille(ville);

		// Début des modifications
		try {
			tx.begin();
			em.persist(p);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			// em.close();
			// emf.close();
		}
	}

}
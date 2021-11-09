package medical.m2i.beans;

import java.io.Serializable;
import java.util.List;

import medical.m2i.dao.VilleDao;
import medical.m2i.model.Ville;

public class VilleBean implements Serializable {
	private static final long serialVersionUID = 4356685251785460886L;

	private List<Ville> listeVilles;
	private Ville ville;

	public VilleBean() throws ClassNotFoundException {
		VilleDao vdao = new VilleDao();
		listeVilles = vdao.getVilles();
		ville = new Ville();

		System.out.println("Je suis dans init bean ville , taille de la liste = " + listeVilles.size());
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public List<Ville> getListeVilles() {
		return listeVilles;
	}

	public void setListeVilles(List<Ville> listeVilles) {
		this.listeVilles = listeVilles;
	}

	public String saveVille() throws ClassNotFoundException {
		VilleDao vdao = new VilleDao();
		vdao.registerVille(ville);

		return "/done.xhtml?faces-redirect=true";
	}

}
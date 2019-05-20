package Truckz;

/**
 * @author Erwan Gauduchon
 *
 */
public class Chauffeur extends Utilisateur {
	
	private Camion camion;
	private Entrepot entrepot;
	
	public Chauffeur(Compte compte, Camion camion) {
		super(compte);
		this.camion = camion;
		this.entrepot = entrepot;
	}
	
	public Camion getCamion() {
		return this.camion;
	}
	
	public void declarerDepart() {
		for(Colis c : this.camion.getChargement()) {
			c.setEtat(EtatColis.C);
		}
		this.camion.getEntrepotDestination().supprimerCamion(this.camion);
	}
	
	public void declarerArrivee() {
		this.camion.deposer(this.camion.getEntrepotDestination());
		this.camion.getEntrepotDestination().ajouterCamion(this.camion);
		this.camion.setDepart(this.camion.getEntrepotDestination());
	}
	
	public void declarerPanneEssence() {
		this.camion.setStatut(Statut.E);
	}
	
	public void declarerBloque() {
		this.camion.setStatut(Statut.B);
	}
	
	public void declarerPanne() {
		this.camion.setStatut(Statut.P);
	}
}

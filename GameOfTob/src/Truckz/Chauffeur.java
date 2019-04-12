package Truckz;

/**
 * @author Erwan Gauduchon
 *
 */
public class Chauffeur extends Utilisateur {
	
	private Camion camion;
	
	public Chauffeur(Compte compte, Camion camion) {
		super(compte);
		this.camion = camion;
	}
	
	public Camion getCamion() {
		return this.camion;
	}
	
	public void declarerDepart() {
		for(Colis c : this.camion.getChargement()) {
			c.setEtat(EtatColis.C);
		}
	}
	
	public void declarerArrivee() {
		this.camion.deposer(this.camion.getEntrepotDestination());
	}
	
	public void declarerBloque() {
		this.camion.setStatut(Statut.B);
	}
	
	public void declarerPanne() {
		this.camion.setStatut(Statut.P);
	}
}

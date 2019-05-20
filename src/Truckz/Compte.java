package Truckz;

/**
 * @author Erwan Gauduchon
 *
 */
public class Compte {

	private String identifiant;
	private String mdp;
	private String nom;
	
	public Compte(String identifiant, String mdp, String nom) {
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.nom = nom;
	}
	
	public String getIdentifiant() {
		return this.identifiant;
	}
	
	public String getMdp() {
		return this.mdp;
	}

	public String getNom() {
		return this.nom;
	}
	
}

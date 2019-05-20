package Truckz;

/**
 * @author Erwan Gauduchon
 *
 */
public class Utilisateur {
	
	private Compte compte;
	
	public Utilisateur(Compte compte) {
		this.compte = compte;
	}
	
	public Compte getCompte() {
		return this.compte;
	}
}

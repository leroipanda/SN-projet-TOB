package Truckz;

import java.util.UUID;

/**
 * @author Erwan Gauduchon
 *
 */
public class Preparateur extends Utilisateur {

	public Preparateur(Compte compte) {
		super(compte);
	}
	
	public Colis creerColis(String id, boolean prioritaire, Categorie categorie, double poids, Entrepot destination) {
		return new Colis(id, prioritaire, categorie, poids, destination);
	}
	
	public String genererIdUnique() {
		return UUID.randomUUID().toString();
	}
	
}

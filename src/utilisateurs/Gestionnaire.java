package Truckz;

import java.util.UUID;

/**
 * @author Erwan Gauduchon
 *
 */
public class Gestionnaire extends Utilisateur {

	private ListeUtilisateurs utlisateurs;
	
	public Gestionnaire(Compte compte, ListeUtilisateurs utilisateurs) {
		super(compte);
		this.utlisateurs = utilisateurs;
	}
	
	public void ajouterColis(Entrepot lieuStock, boolean prioritaire, Categorie categorie, double poids, Entrepot destination) {
		String id = UUID.randomUUID().toString();
		lieuStock.ajouter(new Colis(id, prioritaire, categorie, poids, destination));
	}
	
	public void ajouterChauffeur(String nom, String id, String mdp) {
		this.utlisateurs.ajouterUtilisateur(new Chauffeur(new Compte(id, mdp, nom), null, entrepot));
	}
	
	public void ajouterGestionnaire(String nom, String id, String mdp) {
		this.utlisateurs.ajouterUtilisateur(new Gestionnaire(new Compte(id, mdp, nom), this.utlisateurs));
	}
	
	public void ajouterPreparateur(String nom, String id, String mdp) {
		this.utlisateurs.ajouterUtilisateur(new Preparateur(new Compte(id, mdp, nom), entrepot));
	}
	
	public void supprimerUtilisateur(Utilisateur u) {
		this.utlisateurs.supprimerUtilisateur(u);
	}
	
}

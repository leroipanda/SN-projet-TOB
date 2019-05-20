package Truckz;

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
	
	public void ajouterChauffeur(String nom, String id, String mdp) {
			this.utlisateurs.ajouterUtilisateur(new Chauffeur(new Compte(id, mdp, nom), null));
	}
	
	public void ajouterGestionnaire(String nom, String id, String mdp) {
		this.utlisateurs.ajouterUtilisateur(new Gestionnaire(new Compte(id, mdp, nom), this.utlisateurs));
	}
	
	public void ajouterPreparateur(String nom, String id, String mdp) {
		this.utlisateurs.ajouterUtilisateur(new Preparateur(new Compte(id, mdp, nom)));
	}
	
}

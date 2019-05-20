package Truckz;

import java.util.ArrayList;

/**
 * @author Erwan Gauduchon
 *
 */
public class ListeUtilisateurs {
	
	private ArrayList<Utilisateur> utilisateurs;
	
	public ListeUtilisateurs(ArrayList<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	public void ajouterUtilisateur(Utilisateur u) {
		this.utilisateurs.add(u);
	}
	
	public Utilisateur connexion(String id, String mdp) {
		for(Utilisateur u : this.utilisateurs) {
			if(u.getCompte().getIdentifiant().equals(id)) {
				if(u.getCompte().getMdp().equals(mdp)) {
					return u;
				}
				else {
					throw new ConnexionImpossibleException("Mot de passe incorrect.");
				}
			}
		}
		throw new ConnexionImpossibleException("Identifiant incorrect.");
	}
}

// Non relié à la classe Colis, d'où les erreurs
package bdd;
import Truckz.Colis; //Quel Singe !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
import java.util.Scanner;
import java.io.File;
/**
 * 
 * @author irodrigu4
 * Classe permettant de récuperer les données sur les colis
 * présents dans le fichier texte
 *
 */
public class DonneesColis {
	java.io.File historique = new java.io.File("historiqueColis.txt");
	
	public DonneesColis() {
		liste = new java.util.Scanner(historique);
	}
	
	public Colis[] getListeColis(int nombreColis) {		

	}
	
	/* Obtenir un objet colis à partir de son id (unique) */
	public Colis getColis(String id) {
		
	}
	
	/* Ajouter un colis à la base de données */
	public void addColis(Colis colis) {
		
	}
	
	/* Supprimer un colis de la base de données */
	public void deleteColis(String id) {
		
	}
	
	/* Modifier l'état d'un colis présent dans la base de données */
	public void setEtatColis(String id, EtatColis etat) {
		
	}
}

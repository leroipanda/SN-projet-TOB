package Truckz;
import java.util.ArrayList;

import geolocalisation.position;

public class Entrepot {

	protected String nom;
	protected ArrayList<Colis> stock;
	protected ArrayList<Camion> camions;
	protected int nombreColis;
	protected position pos;
	/**
	 * CONSTRUCTEUR de l'entrepot
	 * @param nom = le nom de l'entrepot cree
	 */
	public Entrepot(String nom, position pos){
		this.nom = nom;
		this.stock = new ArrayList<Colis>();
		this.camions = new ArrayList<Camion>();
		this.nombreColis=0;
		this.pos=pos;
	}

	/**
	 * Ajouter un colis dans un entrepot
	 * @param colis = le colis ajoute
	 */
	public void ajouter(Colis colis){
		this.stock.add(colis);
		this.nombreColis = this.nombreColis +1;
	}

	/**
	 * Savoir si un colis est present dans un entrepot
	 * @param id = le nom du colis recherche
	 * @return booleen : TRUE = le colis est present, FALSE = non
	 */
	public boolean estPresentColis(String id){
		for (int i = 0; i<= this.nombreColis; i++){
			if (this.stock.get(i).getId() == id){
				return true;
			}
		}
		return false;
	}

	public String getNom(){
		return this.nom;
	}

	public ArrayList<Colis> getStock(){
		return this.stock;
	}

	public void ajouterCamion(Camion camion){
		this.camions.add(camion);
	}

	public void supprimerCamion(Camion camion){
		for (Camion c : camions) {
			if (camion.getMatricule()==c.getMatricule()) {
				this.camions.remove(c);
			}
		}
	}

	public void supprimerColis(Colis colis){
		for (Colis c : stock) {
			if (colis.getId()==c.getId()) {
				this.stock.remove(c);
			}
		}
		this.nombreColis= this.nombreColis - 1;
	}

	//Possibilité de supprimer plusieurs colis Antonin
	public void supprimerPlusColis(ArrayList<Colis> listeColis) {
		for (int i = 0; i <= listeColis.size(); i++) {
			this.supprimerColis(listeColis.get(i));
		}
	}

	public ArrayList<Colis> getColisDestination(Entrepot destination) {
		ArrayList<Colis> ColisDestination = new ArrayList<Colis>();
		for (Colis colis : stock) {
			if (colis.getDestination().equals(destination)) {
				ColisDestination.add(colis);
			}
		}
		return ColisDestination ;
	}

	//Ajout de priorité pour les éléments de l'entrepôts
	public void addPlusPriorite(ArrayList<Colis> listeColis, int niveauPrio) {
		for (int i = 0; i <= listeColis.size(); i++) {
			listeColis.get(i).addPriorite(niveauPrio);
		}
	}

}

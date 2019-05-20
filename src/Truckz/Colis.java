package Truckz;

/**
 * Classe qui definit un colis
 * 
 * @author acoulomb
 *
 */
public class Colis {

	protected String id;
	protected int priorite;
	protected Entrepot destination;
	protected Categorie categorie;
	protected EtatColis etat;
	protected double poids;

	/**
	 *  CONSTRUCTEUR du colis
	 * @param id = l'identifiant du colis
	 * @param prioritaire = bolléen : TRUE = Livraison express, FALSE = Livraison standard
	 * @param categorie = Précision si le contenu du colis est fragile/ contient des produits dangeureux
	 * @param poids = le poids du colis en kilogrammes
	 * @param destination = le nom de l'entrepot de destination
	 */
	public Colis(String id, boolean prioritaire, Categorie categorie, double poids, Entrepot destination) {
		this.id = id;
		this.destination = destination;
		this.categorie = categorie;
		this.poids = poids;
		this.etat = EtatColis.P;
		if (prioritaire){
			this.priorite = 50;
		}
		else {
			this.priorite = 0;
		}
	}

	/**
	 * retourne l'identifiant du colis
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * retourne la destination du colis
	 */
	public Entrepot getDestination() {
		return this.destination;
	}
	
	/**
	 * retourne l'état du colis
	 */
	public EtatColis getEtat() {
		return this.etat;
	}
	
	public int getPriorite() {
		return this.priorite;
	}
	
	public double getPoids() {
		return this.poids;
	}
	
	/**
	 * Changer l'etat d'un colis
	 * @param nouveau = le nouvel etat
	 */
	public void setEtat(EtatColis nouveau){
		this.etat=nouveau;
	}
	
	/**
	 * Ajouter de la priorite a un colis (ancienneté)
	 * @param add = la quantite a ajouter
	 */
	public void addPriorite(int add){
		this.priorite=this.priorite+add;
	}
	
	


}

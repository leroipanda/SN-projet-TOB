package Truckz;
import java.util.ArrayList;

public class Entrepot {
	
	protected String nom;
	protected ArrayList<Colis> stock;
	protected int nombreColis;
	
	/**
	 * CONSTRUCTEUR de l'entrepot
	 * @param nom = le nom de l'entrepot cree
	 */
	public Entrepot(String nom){
		this.nom = nom;
		this.stock = new ArrayList<Colis>();
		this.nombreColis=0;
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

}

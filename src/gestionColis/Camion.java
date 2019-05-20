package Truckz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Camion {

	protected String matricule;
	protected Chauffeur chauffeur;
	protected double poidsMax;
	protected Statut statut;
	protected Entrepot depart;
	protected Entrepot arrivee;
	protected ArrayList<Colis> chargement;

	public Camion(String matricule, double poidsmax){
		this.matricule=matricule;
		this.poidsMax=poidsmax;
		this.statut=Statut.I;
		this.depart=null;
		this.arrivee=null;
		this.chauffeur=null;
		this.chargement=null;
	}

	public void setChauffeur(Chauffeur nouveau){
		this.chauffeur = nouveau;
	}

	public void setDepart(Entrepot nouveau){
		this.depart = nouveau;
	}

	public void setArrivee(Entrepot nouveau){
		this.arrivee = nouveau;
	}

	public void setStatut(Statut nouveau){
		this.statut = nouveau;
	}

	public ArrayList<Colis> getChargement() {
		return this.chargement;
	}

	public void setChargement(ArrayList<Colis> listeColis) {
		this.chargement = listeColis;
	}

	public String getMatricule(){
		return this.matricule ;
	}


	public void remplir(Entrepot entrepotD, Entrepot entrepotA){
		double poidsCharge = 0;
		ArrayList<Colis> colisBonneDestination = new ArrayList<Colis>();
		for (Colis colis : entrepotD.getStock()){
			if (colis.getDestination().getNom().equals(entrepotA.getNom())){
				colisBonneDestination.add(colis);
			}
		}
		Collections.sort(colisBonneDestination, new Comparator<Colis>() {
		    @Override
		    public int compare(Colis colis1, Colis colis2) {
		        return Integer.compare(colis1.getPriorite(),colis2.getPriorite());
		    }
		});
		while (colisBonneDestination.size() != 0){
			if (poidsCharge + colisBonneDestination.get(0).getPoids() <= poidsMax){
			    this.chargement.add(colisBonneDestination.get(0));
			    poidsCharge = poidsCharge + colisBonneDestination.get(0).getPoids();
			}
			colisBonneDestination.remove(0);
		}
		for (Colis colis : this.chargement){
			entrepotD.retirer(colis);
			colis.setEtat(EtatColis.C);
		}
	}

	public void deposer(Entrepot entrepot){
		for (Colis colis : this.chargement){
			entrepot.ajouter(colis);
			colis.setEtat(EtatColis.L);
			chargement.remove(colis);
		}
	}

	public Entrepot getEntrepotDestination() {
		return this.arrivee;
	}

	public Entrepot getEntrepotDepart() {
		return this.depart;
	}

	//Ajout Antonin
	public double getPoidsMax() {
		return this.poidsMax;
	}

	public String toStringColis(int i) {
		return this.chargement.get(i).getId();
	}

	public boolean contientColis(String idColis) {
		for (int i = 0; i < this.chargement.size(); i++) {
			if (idColis.equals(this.toStringColis(i))) {
				return true;
			}
		}
		return false;
	}

}

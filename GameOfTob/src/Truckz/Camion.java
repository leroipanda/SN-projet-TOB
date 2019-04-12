package Truckz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class Camion {
	
	protected String matricule;
	protected String chauffeur;
	protected double poidsMax;
	protected Statut statut;
	protected String depart;
	protected String arrivee;
	protected ArrayList<Colis> chargement;
	
	public Camion(String matricule, double poidsmax){
		this.matricule=matricule;
		this.poidsMax=poidsmax;
		this.statut=Statut.I;
		this.depart="Inconnu";
		this.arrivee="Inconnu";
		this.chauffeur="Inconnu";	
		this.chargement=null;
	}
	
	public void setChauffeur(String nouveau){
		this.chauffeur = nouveau;
	}
	
	public void setDepart(String nouveau){
		this.depart = nouveau;
	}
	
	public void setArrivee(String nouveau){
		this.arrivee = nouveau;
	}
	
	public void setStatut(Statut nouveau){
		this.statut = nouveau;
	}
	

	public void remplir(Entrepot entrepotD, Entrepot entrepotA){
		int poidsCharge = 0;
		ArrayList<Colis> colisBonneDestination = new ArrayList<Colis>();
		for (Colis colis : entrepotD.getStock()){
			if (colis.getDestination()==entrepotA.getNom()){
				colisBonneDestination.add(colis);
			}
		}
		Collections.sort(colisBonneDestination, new Comparator<Colis>() {
		    @Override
		    public int compare(Colis colis1, Colis colis2) {
		        return Integer.compare(colis1.getPriorite(),colis2.getPriorite());
		    }
		});
		while (poidsCharge <= this.poidsMax){
			if (poidsCharge + colisBonneDestination.get(0).getPoids() > poidsMax){
				/** PAS FINI NO TIME */
			}
		}
	}
	
	public void deposer(Entrepot entrepot){
		for (Colis colis : this.chargement){
			entrepot.ajouter(colis);
			colis.setEtat(EtatColis.L);
			chargement.remove(colis);
		}
	}

}

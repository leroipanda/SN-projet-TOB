package Truckz;

public enum EtatColis {

	  //Objets directement construits
	  P ("Pas encore livr�."),
	  C("En cours de livraison."),
	  L ("Livr�.");

	  private String etat = "";
	   
	  //Constructeur
	  EtatColis(String etat){
	    this.etat = etat;
	  }
	   
	  public String toString(){
	    return etat;
	  }

	}
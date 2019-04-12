package Truckz;

public enum EtatColis {

	  //Objets directement construits
	  P ("Pas encore livré."),
	  C("En cours de livraison."),
	  L ("Livré.");

	  private String etat = "";
	   
	  //Constructeur
	  EtatColis(String etat){
	    this.etat = etat;
	  }
	   
	  public String toString(){
	    return etat;
	  }

	}
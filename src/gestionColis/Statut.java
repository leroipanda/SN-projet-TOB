package Truckz;

public enum Statut {

	  //Objets directement construits
	  E ("Il n'y a plus beaucoup d'essence dans le camion."),
	  B("Le traffic empêche l'avancement du camion."),
	  P("Le camion est en panne."),
	  I ("Le camion n'a pas de problème.");

	  private String statut = "";
	   
	  //Constructeur
	  Statut(String statut){
	    this.statut = statut;
	  }
	   
	  public String toString(){
	    return statut;
	  }

	}

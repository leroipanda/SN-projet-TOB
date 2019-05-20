package Truckz;

public enum Categorie {
	  //Objets directement construits
	  N ("Normal"),
	  PC("Produit(s) Chimique(s)"),
	  F ("Fragile");

	  private String name = "";
	   
	  //Constructeur
	  Categorie(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }

	}
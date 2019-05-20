package Truckz;

import java.util.ArrayList;

import OptimisationRangement.AlgoKnapsack;

/**
 * @author Erwan Gauduchon
 *
 */
public class Preparateur extends Utilisateur {

	private Entrepot entrepot;

	public Preparateur(Compte compte) {
		super(compte);
		this.entrepot = entrepot;
	}

	public ArrayList<Colis> obtenirColisEntrepot() {
		return this.entrepot.getStock();
	}

	//Ajout préparation chargement Antonin
	public void nouveauTrajet(Camion camion, Entrepot eDepart, Entrepot eArrivee) {
		camion.setDepart(eDepart);
		camion.setArrivee(eArrivee);
		AlgoKnapsack algoDepart = new AlgoKnapsack(eDepart.getStock(), (int)camion.getPoidsMax());
		algoDepart.resoudre(camion);
		eDepart.supprimerPlusColis(camion.getChargement());
		//Possibilité ajout priorité sur les colis non pris

	}

}

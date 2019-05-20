package OptimisationRangement;

import java.util.ArrayList;

import Truckz.Camion;
import Truckz.Colis;

/** Alogrithme knapsack pour l'optimisation de la capacité de transport du camion
 *
 * @author akenens
 *
 */
public class AlgoKnapsack {

	private ArrayList<Colis> colis;
	private int capacite;


	public AlgoKnapsack(ArrayList<Colis> colis, int capacite) {
		this.colis = colis;
		this.capacite = capacite;
	}

	public void resoudre(Camion camion) {

		int NB_COLIS = colis.size();

		int[][] sac = new int[NB_COLIS + 1][capacite + 1];

		for (int i = 0; i <= capacite; i++) {
			sac[0][i] = 0;
		}

		for (int i = 1; i <= NB_COLIS; i++) {
		      for (int j = 0; j <= capacite; j++) {
		        if (colis.get(i - 1).getPoids() > j)
		          sac[i][j] = sac[i-1][j];
		        else
		          sac[i][j] = Math.max(sac[i-1][j], sac[i-1][j - (int)colis.get(i-1).getPoids()+1]
						  + colis.get(i-1).getPriorite());
		      }
		}

		int resultat = sac[NB_COLIS][capacite];
		int c = capacite;
		ArrayList<Colis> solutionColis = new ArrayList<>();

		for (int i = NB_COLIS; i > 0  &&  resultat > 0; i--) {
			  if (resultat != sac[i-1][c]) {
			    solutionColis.add(colis.get(i - 1));
			    resultat -= colis.get(i-1).getPriorite();
			    c -= (int)colis.get(i-1).getPoids()+1;
			}
		}

		camion.setChargement(solutionColis);

	}

}

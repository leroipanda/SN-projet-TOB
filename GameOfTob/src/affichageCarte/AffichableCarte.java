package affichageCarte;

import geolocalisation.position;

/**
 * @author Nath
 *classe abtraite qui gere les éléments à afficher sur la carte
 */
public abstract class AffichableCarte {
	
	Map Carte ;
	position Emplacement ;
	
	/**constructeur de l'objet 
	 * @param carte la carte où afficher le marker.
	 * @param emplacement l'emplacement du l'objet à afficher.
	 */
	public AffichableCarte(Map carte,position emplacement ) {
		this.Carte = carte ;
		this.Emplacement = new position( emplacement) ;
	}
	 

}

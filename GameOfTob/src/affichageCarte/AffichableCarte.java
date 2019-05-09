package affichageCarte;

import geolocalisation.position;

/**
 * @author Nath
 *classe abtraite qui gere les �l�ments � afficher sur la carte
 */
public abstract class AffichableCarte {
	
	Map Carte ;
	position Emplacement ;
	
	/**constructeur de l'objet 
	 * @param carte la carte o� afficher le marker.
	 * @param emplacement l'emplacement du l'objet � afficher.
	 */
	public AffichableCarte(Map carte,position emplacement ) {
		this.Carte = carte ;
		this.Emplacement = new position( emplacement) ;
	}
	 

}

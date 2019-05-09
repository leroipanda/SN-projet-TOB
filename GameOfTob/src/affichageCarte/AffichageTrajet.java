/**
 * 
 */
package affichageCarte;

import geolocalisation.position;
import geolocalisation.trajet;

/**
 * @author Nath
 *
 */
public class AffichageTrajet extends MarkerTrucks {
 
	//les markers des extremit�s
	private Marker arriv� ;
	private Marker depart ;
	
	private trajet TrajetDuCamion;
	

	/**
	 * @param carte
	 * @param emplacement
	 */
	public AffichageTrajet(Map carte, position emplacement,trajet TrajetDuCamion) {
		super(carte, emplacement);
		this.TrajetDuCamion = TrajetDuCamion ;
		
		//marker des extremit�s
		depart =  new Marker(carte);
		depart.setPosition(new LatLng(TrajetDuCamion.getDepart().getLatitude() , TrajetDuCamion.getDepart().getLongitude() ));
		arriv� =  new Marker(carte);
		arriv�.setPosition(new LatLng(TrajetDuCamion.getArrivee().getLatitude() , TrajetDuCamion.getArrivee().getLongitude() ));
		
		//affichage du chemin 
	}

}

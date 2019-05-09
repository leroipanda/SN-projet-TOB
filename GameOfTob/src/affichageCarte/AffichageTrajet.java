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
 
	//les markers des extremités
	private Marker arrivé ;
	private Marker depart ;
	
	private trajet TrajetDuCamion;
	

	/**
	 * @param carte
	 * @param emplacement
	 */
	public AffichageTrajet(Map carte, position emplacement,trajet TrajetDuCamion) {
		super(carte, emplacement);
		this.TrajetDuCamion = TrajetDuCamion ;
		
		//marker des extremités
		depart =  new Marker(carte);
		depart.setPosition(new LatLng(TrajetDuCamion.getDepart().getLatitude() , TrajetDuCamion.getDepart().getLongitude() ));
		arrivé =  new Marker(carte);
		arrivé.setPosition(new LatLng(TrajetDuCamion.getArrivee().getLatitude() , TrajetDuCamion.getArrivee().getLongitude() ));
		
		//affichage du chemin 
	}

}

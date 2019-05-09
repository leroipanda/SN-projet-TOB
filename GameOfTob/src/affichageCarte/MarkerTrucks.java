package affichageCarte;

import com.teamdev.jxmaps.*;

import geolocalisation.position;

public class MarkerTrucks extends AffichableCarte{

	protected Marker marker  = new Marker(map); // le marker JxMap 
	
	public MarkerTrucks(Map carte ,position emplacement) {
		super(carte ,emplacement);
		marker.setPosition(new LatLng( ));
	}

}

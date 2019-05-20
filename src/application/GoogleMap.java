package fr.enseeiht.tob.system;

import com.teamdev.jxmaps.ControlPosition;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.MapViewOptions;
import com.teamdev.jxmaps.swing.MapView;

public class GoogleMap {

	private static final String KEY = "AIzaSyBNQDcDilCvR-x3Cp50p56CtH9Z1fxWLTQ";

	private final Map map;
	private MapView mapView;

	public GoogleMap(double zoom, double lat, double lng) {

		MapViewOptions mapViewOptions = new MapViewOptions();
		mapViewOptions.setApiKey(KEY);
		
		this.mapView = new MapView(mapViewOptions);
		this.map = mapView.getMap();
		
		mapView.setOnMapReadyHandler(new MapReadyHandler() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onMapReady(MapStatus status) {
				if (status == MapStatus.MAP_STATUS_OK) {
					MapOptions options = new MapOptions(map);
					MapTypeControlOptions controlOptions = new MapTypeControlOptions(map);
					controlOptions.setPosition(ControlPosition.TOP_RIGHT);
					options.setMapTypeControlOptions(controlOptions);
					map.setOptions(options);
					map.setCenter(new LatLng(map, lat, lng));
					map.setZoom(zoom);
				}
			}
		});
	}

	public Map getMap() {
		return map;
	}
	
	public MapView getMapView() {
		return mapView;
	}

}

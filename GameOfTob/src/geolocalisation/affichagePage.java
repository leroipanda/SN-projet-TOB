package geolocalisation;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;


public class affichagePage {
	static String ClefAPI = "AIzaSyBNQDcDilCvR-x3Cp50p56CtH9Z1fxWLTQ";
	static String adresseIcone[] =  {"https://zupimages.net/up/19/15/c1dk.png","https://zupimages.net/up/19/15/wdcq.png","https://zupimages.net/up/19/15/uk12.png"};
	public affichagePage() {
		
	}
	
	//fonction qui ecrit juste dans un fichier
	public void CreationFichier (String nom,String Contenu) {
		try{
			File ff=new File(nom); // définir l'arborescence
			ff.createNewFile();
			FileWriter ffw=new FileWriter(ff);
			ffw.write(Contenu);
			ffw.close(); // fermer le fichier à la fin des traitements
			} catch (Exception e) {}
			}
	//fonction qui realise un saut de ligne : marhe pas ....			
	private void sautDeLigne(FileWriter fichier) {
		try{fichier.write("\n");
	  } catch (Exception e) {}
	}
	//fonction qui genere la page html 
	private String pageHTMLcarte(position centre) {
		String page = new String();
		//creation de la page HTML de la carte
		page=" <!DOCTYPE html><html><head><style>"
				+ "#map {height: 400px;  /* The height is 400 pixels "
				+ "*/width: 100%;  /* The width is the width of the web page */}"
				+ "</style></head><body><h3>My Google Maps Demo</h3><!--The div element for the map --><div id="+"map"+"></div><script>function initMap() {"
				+ "var centre = "+centre.toString()+";"
				+""
				+ "var map = new google.maps.Map(document.getElementById('map'), "
				+ "{zoom: 4, center: centre});"
				+ "}"
				+ "</script><script async defer src="+"https://maps.googleapis.com/maps/api/js?key="
				+ ClefAPI
				+ "&callback=initMap"+"></script></body></html>";
		
		
		return page;}
		
		private String pageHTMLcarte(position centre,position[] camions ,position[] entrepots,position[] prios ) {
			String page = new String();
			//creation de la page HTML de la carte
			page=" <!DOCTYPE html><html><head><style>"
					+ "#map {height: 400px;  /* The height is 400 pixels "
					+ "*/width: 100%;  /* The width is the width of the web page */}"
					+ "</style></head><body><h3>My Google Maps Demo</h3><!--The div element for the map --><div id="+"map"+"></div><script>function initMap() {"
					+ "var centre = "+centre.toString()+";"
					+""
					+ "var map = new google.maps.Map(document.getElementById('map'), "
					+ "{zoom: 4, center: centre});";
			        
			        //ajout des markers
			        //marker camion 
					for(int i =0 ;i< camions.length ;i++ ) {
					page = page + ajoutMarqueurCamion(camions[i] );
					}
					//marker entrepot 
					for(int i =0 ;i< entrepots.length ;i++ ) {
					page = page + ajoutMarqueurEntrepot(entrepots[i] );
						}
					//marker camion prio
					for(int i =0 ;i< prios.length ;i++ ) {
					page = page + ajoutMarqueurCamionPrio(prios[i] );
						}
					
					
					page = page+ tracerRoute(camions[0],camions[1]);
					page = page + "}</script><script async defer src="+"https://maps.googleapis.com/maps/api/js?key="
					+ ClefAPI
					+ "&callback=initMap"+"></script></body></html>";
			
			
			return page;
}
	private String ajoutMarqueur(String icone, position emplacement ) {
		return "var image ='"+icone+"';var marker = new google.maps.Marker({position: "+emplacement.toString()+",icon: image  , map: map});";
	}
	private String ajoutMarqueurCamion(position emplacement ) {
		return ajoutMarqueur(adresseIcone[0], emplacement );
	}
	private String ajoutMarqueurEntrepot(position emplacement ) {
		return ajoutMarqueur(adresseIcone[1], emplacement );
	}
	private String ajoutMarqueurCamionPrio(position emplacement ) {
		return ajoutMarqueur(adresseIcone[2], emplacement );
	}
		
	public void creationPageHTML(position emplacementCentre){
		String Page = pageHTMLcarte(emplacementCentre);
		CreationFichier("page.html",Page);
		
	}
	//ajout des waypoint a faire
	public String tracerRoute(position depart,position arrive) {
		String lecode ;
		lecode = "var directionsService = new google.maps.DirectionsService;var directionsDisplay = new google.maps.DirectionsRenderer;directionsDisplay.setMap(map);calculateAndDisplayRoute(directionsService, directionsDisplay);}function calculateAndDisplayRoute(directionsService, directionsDisplay) {var waypts = [];var checkboxArray = document.getElementById('waypoints');for (var i = 0; i < checkboxArray.length; i++) {if(checkboxArray.options[i].selected) {waypts.push({location: checkboxArray[i].value,stopover: true});}}directionsService.route("
			+ "{origin:"+depart.toString() +","
		    + "destination: "+arrive.toString() +","
		    +"waypoints: null,"
		    +"optimizeWaypoints: true,"
		    +"travelMode: 'DRIVING'"
		+"}, function(response, status) {if (status === 'OK') {directionsDisplay.setDirections(response);var route = response.routes[0];var summaryPanel = document.getElementById('directions-panel');summaryPanel.innerHTML = '';for (var i = 0; i < route.legs.length; i++) {var routeSegment = i + 1;summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment +'</b><br>';summaryPanel.innerHTML += route.legs[i].start_address + ' to ';summaryPanel.innerHTML += route.legs[i].end_address + '<br>';summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';}} else {window.alert('Directions request failed due to ' + status);}});";
	return lecode;
	}
	
	public void creationPageHTML(position emplacementCentre,position[] cams , position[] entres,position[] prios){
		String Page = pageHTMLcarte(emplacementCentre,cams,entres,prios);
		CreationFichier("page.html",Page);
		
	}
}	





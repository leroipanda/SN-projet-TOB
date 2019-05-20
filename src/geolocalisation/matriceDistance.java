package geolocalisation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * @author nfrederi
 * la classe matriceDistance permet d'obtennir une matrice comportant les distances entre plusieurs emplacements de depart et d'arrive
 * 
 * depart = [A B C ]
 * arrivee = [ D E ]
 * 
 * la matrice : |	|A  |B  |C  |
 * 				----------------
 * 				|D  |AD |BD |CD |
 * 				---------------
 * 				|E  |AE |BE |EC |
 * 				----------------
 */
public class matriceDistance implements APIGoogleMaps {
	
	
	private Map<trajet , Double> matrice = new HashMap<>();
	private trajet[] trajetCalculer ;
	

	/**
	 * @param emplacementDeparts une liste de trajet comportant les emplacements de tout les lieux de départs
	 * @param emplacementArrivee une liste de trajet comportant les emplacements de tout les lieux d'arrivé
	 */
	public matriceDistance(  position[] emplacementDeparts , position[] emplacementArrivee ) {
	String url = CreationRequete(emplacementDeparts ,emplacementArrivee );
	int nombretrajets = emplacementDeparts.length *emplacementArrivee.length  ; 
	double[] distances  = ContructionJsonextractionDonnee(url , nombretrajets);
	//on va ajouter les trajet correspondant au distances à la matrice et sauvegarder aussi leur existance au passage
	trajetCalculer = new trajet[nombretrajets] ; 
	for(int i=0 ;i< distances.length ;i++ ){
		trajet trajetCorrespondant = new trajet(emplacementDeparts[i%emplacementDeparts.length] ,emplacementArrivee[i%emplacementArrivee.length] ) ;
		matrice.put(trajetCorrespondant, distances[i]);
		trajetCalculer[i] = trajetCorrespondant ; 
	}
	
	
	}
	
	private String CreationRequete(position[] emplacementDeparts ,position[] emplacementArrivee ){
		String url ;
		url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=";
		for(int i =0;i < emplacementDeparts.length ; i++ ){
			url = url + emplacementDeparts[i].ToStringSimplifier() ;
			url =url + "|";
		}
		url = url + "&destinations=";
		for(int i =0;i < emplacementArrivee.length ; i++ ){
			url = url + emplacementArrivee[i].ToStringSimplifier() ;
			url =url + "|";
		}
		url = url + "&key="+ClefAPI ;
		return url ; 
	}
	
	private double[] ContructionJsonextractionDonnee(String lien, int nombreDistance){
		double[] tableauDistance = new double[nombreDistance];
		String contenusFichier= new String(); ;
		try{
		//on creer le fichier 
		URL website = new URL(lien);
		//on le telecharge 
		
		String nomFichier = "donneMatrice.json";
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream(nomFichier);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		
		//on extrait les infos du fichier 
		
		File file = new File(nomFichier);
		FileInputStream fis = null;
		
			//on l'ouvre et on le lit octet par octet 
			fis = new FileInputStream(file);

			//System.out.println("Total file size to read (in bytes) : "
			//		+ fis.available());

			//on lit chaque caractere et on les ajoute à un String
			int content;	
			while ((content = fis.read()) != -1) {
				// convert to char and display it
				contenusFichier= contenusFichier + (char) content;
			     }
			//on trie les caracteres necessaire 
			//System.out.println(contenusFichier);
			String[] page = contenusFichier.split("\"text\" : \"");
			
		   /* System.out.println( page[0]);
		    System.out.println( page[1]);
		    System.out.println( page[2]);
		    */
			
			for (int i = 0 ;i < page.length ;i++){
				
				String[] intermediaire =  page[i].split(" km");
				if(i%2 == 1 ){
			    //System.out.println( i +"---"+ intermediaire[0]);
			    //System.out.println( Double.parseDouble(intermediaire[0].replace(',', '.')));
					
					//on rajoute au tableau la valeur  
					tableauDistance[i/2] = Double.valueOf( (intermediaire[0].replace(',', '.')));			
			}
		}
		}
		catch(Exception e) {
			System.out.println("fail : ");
			System.out.println(e.toString());
			System.out.println(e.getMessage());
		}
		
	
		return tableauDistance;
	}
	
	
	/**
	 * @param trajetDemande
	 * @return la distance du trajet
	 * @throws DistanceTrajetindisponibleException
	 */
	public double distanceTrajet( trajet trajetDemande ) throws DistanceTrajetindisponibleException
	{
		if(matrice.containsKey(trajetDemande) | matrice.containsKey(trajetDemande.inverser())) {
			return matrice.get(trajetDemande);
		}
		else{
		throw new DistanceTrajetindisponibleException(trajetDemande);
		
		}
	}
	
	/**
	 * @return un tableau comprenant tout les trajets calculés
	 */
	public trajet[] getTrajetsCalcules(){
		return trajetCalculer.clone();
	}
	
	}


package geolocalisation;

import java.util.ArrayList;

/**
 * @author nfrederi
 * classe qui implement un trajet entre deux position en tolérant le passant par plusieurs points intermediaires
 */
public class trajet {

	//un trajet contrient un depart une arrivé et des waypoints (optinnel)
	
	private position depart ;
	private position arrivee ;
	private ArrayList<position> waypoints = new ArrayList<position>();
	
	
	//les constructeurs
	
	/**
	 * @param positionDepart
	 * @param positionArrivee
	 */
	public trajet( position positionDepart,position positionArrivee ) {
		this.depart = positionDepart ;
		this.arrivee = positionArrivee;
		
		
	}
	/**
	 * @param positionDepart
	 * @param positionArrivee
	 * @param positionIntermediaire ,un array qui contieint tout les points intermediares du trajet
	 */
	public trajet( position positionDepart,position positionArrivee,ArrayList<position> positionIntermediaire ) {
		this.depart = positionDepart ;
		this.arrivee = positionArrivee;
		waypoints = new ArrayList<position>(positionIntermediaire) ;
	
	}
	
	
	/**fonction qui change la position de depart
	 * @param nouveauDepart
	 */
	public void setDepart(position nouveauDepart){
		this.depart = nouveauDepart ;
	}
	/**fonction qui renvoie la position de départ
	 * @return la position de depart
	 */
	public position getDepart(){
		position point = new position(depart.getLatitude() , depart.getLongitude());
		return point ;	
	}
	

	/**fonction qui change la position d'arrivee
	 * @param nouvelleArrivee
	 */
	public void setArrive(position nouvelleArrivee){
		this.depart = nouvelleArrivee ;
	}
	/**fonction qui renvoie la position d'arrivee
	 * @return la position d'arrivee
	 */
	public position getArrivee(){
		position point = new position(arrivee.getLatitude() , arrivee.getLongitude());
		return point ;	
	}
	
	/**fonction qui change la liste des points intermédiaires
	 * @param nouveauWaypoints
	 */
	public void setWaypoint(ArrayList<position> nouveauWaypoints ){
		this.waypoints = new ArrayList<position>(nouveauWaypoints) ;
	}
	/**fonction qui renvoie la liste des points intermédiaires
	 * @return la liste des points intermédiaires
	 */
	public ArrayList<position> getWaypoint( ){
		
		return new ArrayList<position>(this.waypoints) ;
	}
	
	/**fonction qui renvoie le trajet dans le  sens inverse
	 * @return le trajet inversé
	 */
	public trajet inverser(){
		trajet inverse = new trajet(this.arrivee , this.depart);
		return inverse ;
	}
	
	/**fonction qui indique si une position fait partie d'un trajet . 
	 * @param endroit que l'on souhaite tester
	 * @return boolean
	 */
	public Boolean PointDuTrajet(position endroit){
		Boolean passage =( endroit.equal(arrivee)|| endroit.equal(depart)  || waypoints.contains(endroit) ) ;
		return passage;
	}
}

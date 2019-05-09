package geolocalisation;


//il faut commenter ce code
/**
 * @author nfrederi
 * classe qui implement les coordonné d'une position
 */
public class position {
	
	private double Latitude ;
	private double Longitude ;

	/**construit une position à partir de ses coordonnées gps
	 * @param latitude
	 * @param longitude
	 */
	public position(double latitude , double longitude ) {
		this.Latitude = latitude ;
		this.Longitude = longitude;
	}
	public position(position emplacement) {
		this.Latitude = emplacement.getLatitude();
		this.Longitude = emplacement.getLongitude();
	  
	}
	/**retourne la latitude du point
	 * @return
	 */
	public double getLatitude() {
		return Latitude;
	}
	/**retourne la longitude du point
	 * @return
	 */
	public double getLongitude() {
		return Longitude;
	}
	
	/**modifie la latitude du point
	 * @param latitude
	 */
	public void setLatitude(double latitude) {
		this.Latitude = latitude;
	}
	/**modifie la longitude du point
	 * @param longitude
	 */
	public void setLongitude(double longitude) {
		this.Longitude = longitude;
	}
	
	/** fonction qui déplace le point à une nouvelle positin
	 * @param emplacement la position souhaiter
	 */
	public void nvllPosition (position emplacement) {
		this.Latitude = emplacement.Latitude;
		this.Longitude = emplacement.Longitude;
		
	}
	
	/**test si deux point sont égaux
	 * @param emplacement
	 * @return
	 */
	public boolean equal(position emplacement) {
		return this.Latitude == emplacement.Latitude && this.Longitude == emplacement.Longitude ;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	
	@Override
	public String toString() {
		String texte ;
		 texte = "{lat: "+this.getLatitude()+", lng: "+this.Longitude+"}";
		return texte;
	}
	/**retourne une chaine de caractere dans un format simplifier: lat,lon
	 * @return
	 */
	public String ToStringSimplifier(){
		return this.getLatitude()+","+this.getLongitude() ;
	}
	/** toString adapter pour la classe AffichagePage
	 * @return
	 */
	public String toStringRoute(){
		return "'"+this.getLatitude()+","+this.getLongitude()+"'" ;
	}
	
	
}

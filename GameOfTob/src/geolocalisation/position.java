package geolocalisation;


//il faut commenter ce code
public class position {
	
	private double Latitude ;
	private double Longitude ;

	public position(double latitude , double longitude ) {
		this.Latitude = latitude ;
		this.Longitude = longitude;
	}
	public double getLatitude() {
		return Latitude;
	}
	public double getLongitude() {
		return Longitude;
	}
	
	public void setLatitude(double latitude) {
		this.Latitude = latitude;
	}
	public void setLongitude(double longitude) {
		this.Longitude = longitude;
	}
	
	public void nvllPosition (position emplacement) {
		this.Latitude = emplacement.Latitude;
		this.Longitude = emplacement.Longitude;
		
	}
	
	public boolean equal(position emplacement) {
		return this.Latitude == emplacement.Latitude && this.Longitude == emplacement.Longitude ;
	}
	@Override
	public String toString() {
		String texte ;
		 texte = "{lat: "+this.getLatitude()+", lng: "+this.Longitude+"}";
		return texte;
	}
	public String ToStringSimplifier(){
		return this.getLatitude()+","+this.getLongitude() ;
	}
	public String toStringRoute(){
		return "'"+this.getLatitude()+","+this.getLongitude()+"'" ;
	}
}

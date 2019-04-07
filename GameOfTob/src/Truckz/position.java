package Truckz;


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
		return Double.toString(Latitude)+","+Double.toString(Longitude);
	}
}

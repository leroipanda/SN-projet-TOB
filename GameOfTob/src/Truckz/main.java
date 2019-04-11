package Truckz;

import geolocalisation.position;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		position a = new position(49.1049039 ,6.1613867);
		String api = "AIzaSyBNQDcDilCvR-x3Cp50p56CtH9Z1fxWLTQ";
		Carte test = new Carte(api);
		test.Getmap(a);

	}

}

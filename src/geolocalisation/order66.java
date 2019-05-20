package geolocalisation;

public class order66 {
	
	public order66() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public static void main(String[] args) {
		String page = "q";
		affichagePage test = new affichagePage();
		position cams[]  = {new position(48.4137,6.1105) , new position(43.3616,1.2638)};
		position entrs[] = { new  position (48.2327,4.2908),new  position (45.4535,4.5032 ),new  position (60.4535,5.5032 )};
		position prios [] = {new position (45,7),new position (48.2327,4.2908),new position (48.4619,5.0937)};
		
		position Metz = new position(49.0713 , 6.1040);
		System.out.println(Metz.toString());
		test.creationPageHTML(Metz,cams,entrs,prios);
		/* matriceDistance matrice = new matriceDistance(cams,entrs);
		try{trajet[] dispo = matrice.getTrajetsCalcules();
		double testdistance = matrice.distanceTrajet(dispo[1]);
		System.out.println(testdistance);
		//test.creationPageHTML(Metz);
		}
		
		catch(Exception e){
			
		}*/
	}

}

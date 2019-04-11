package geolocalisation;

public class main {
	
	public main() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public static void main(String[] args) {
		String page = "q";
		affichagePage test = new affichagePage();
		position cams[]  = {new position(48.4137,6.1105) , new position(43.3616,1.2638)};
		position entrs[] = { new  position (20,20 )};
		position prios [] = {new position (49,7)};
		
		position Metz = new position(49.0713 , 6.1040);
		System.out.println(Metz.toString());
		test.creationPageHTML(Metz,cams,entrs,prios);
		//test.creationPageHTML(Metz);
	}

}

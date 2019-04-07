package Truckz;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


public class Carte {
	private String APIKEY ; // " AIzaSyBNQDcDilCvR-x3Cp50p56CtH9Z1fxWLTQ"

	
	//faire un objet pour ca ? 
	int tailleX = 1080 ; 
	int tailleY = 720 ; 
	int Zoom = 17;
	
	
	// la classe carte utilise l'api google map pour fonctionner 
	public Carte(String clefapi  ) {
		APIKEY = clefapi ;  
	}
	public void Getmap(position emplacement) {
		// base du code : https://stackoverflow.com/questions/17598074/google-map-in-java-swing
		try {
            String imageUrl = GetURL(emplacement);
            String destinationFile = "carte.jpg";
            String str = destinationFile;
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
	
	}
	public String  GetURL(position emplacement)
	{
		//https://maps.googleapis.com/maps/api/staticmap?center=Albany,+NY&zoom=13&scale=1&size=600x300&maptype=roadmap&key=AIzaSyAtkjddgJ7OR33kI7tNk_YcubnMWlYKl64&format=png&visual_refresh=true&markers=size:mid%7Ccolor:0xff0000%7Clabel:1%7CAlbany,+NY

		String url = "https://maps.googleapis.com/maps/api/staticmap?center=";
		//ajout de la position 
		url =url.concat(emplacement.toString()) ;
		//parametre
		url =url.concat("&zoom="+Integer.toString(Zoom) + "&scale=1&size="+Integer.toString(tailleX)+"x" +Integer.toString(tailleY)+"&maptype=roadmap") ;  // a rendre modulaire
		//api
		url = url.concat("&key=" + APIKEY);
		//format 
	    url = url.concat("&format=jpg");
	    System.out.println(url);
		return url ;
	}

}



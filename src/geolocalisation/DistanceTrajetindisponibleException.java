package geolocalisation;

public class DistanceTrajetindisponibleException extends Exception {

	trajet trajetException ;
	public DistanceTrajetindisponibleException(trajet trajetexcep) {
		trajetException = trajetexcep ; 
	}

	public DistanceTrajetindisponibleException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DistanceTrajetindisponibleException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DistanceTrajetindisponibleException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DistanceTrajetindisponibleException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

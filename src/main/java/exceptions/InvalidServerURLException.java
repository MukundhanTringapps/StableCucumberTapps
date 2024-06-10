package exceptions;

@SuppressWarnings("serial")
public class InvalidServerURLException extends RuntimeException {

	public InvalidServerURLException(String message) {
		super(message);
	}
	
	public InvalidServerURLException(String message, Throwable cause) {
		super(message, cause);
	}
}

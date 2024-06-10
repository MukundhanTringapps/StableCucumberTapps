package exceptions;

@SuppressWarnings("serial")
public class InvalidPropertyKeyException extends RuntimeException {
	
	public InvalidPropertyKeyException(String message) {
		super(message);
	}
	
	public InvalidPropertyKeyException(String message, Throwable cause) {
		super(message, cause);
	}
}
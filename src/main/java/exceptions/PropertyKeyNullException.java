package exceptions;

@SuppressWarnings("serial")
public class PropertyKeyNullException extends RuntimeException {
	
	public PropertyKeyNullException(String message) {
		super(message);
	}
	
	public PropertyKeyNullException(String message, Throwable cause) {
		super(message, cause);
	}
}
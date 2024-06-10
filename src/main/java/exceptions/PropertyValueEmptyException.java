package exceptions;

@SuppressWarnings("serial")
public class PropertyValueEmptyException extends RuntimeException {
	
	public PropertyValueEmptyException(String message) {
		super(message);
	}
	
	public PropertyValueEmptyException(String message, Throwable cause) {
		super(message, cause);
	}
}
package exceptions;

@SuppressWarnings("serial")
public class InvalidJsonFilePathUsageException extends RuntimeException {
	
	public InvalidJsonFilePathUsageException(String message) {
		super(message);
	}
	
	public InvalidJsonFilePathUsageException(String message, Throwable cause) {
		super(message, cause);
	}
}
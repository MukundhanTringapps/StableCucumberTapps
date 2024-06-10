package exceptions;

@SuppressWarnings("serial")
public class InvalidPathForPropretyFileUsageException extends RuntimeException {
	
	public InvalidPathForPropretyFileUsageException(String message) {
		super(message);
	}
	
	public InvalidPathForPropretyFileUsageException(String message, Throwable cause) {
		super(message, cause);
	}
}
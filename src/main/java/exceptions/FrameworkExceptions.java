package exceptions;

/**
 * Custom exception ~ FrameworkExceptions thrown when exception in the framework is caught.
 */
@SuppressWarnings("serial")
public class FrameworkExceptions extends RuntimeException {
	
	public FrameworkExceptions(String message) {
		super(message);
	}
	
	public FrameworkExceptions(String message, Throwable cause) {
		super(message, cause);
	}
}
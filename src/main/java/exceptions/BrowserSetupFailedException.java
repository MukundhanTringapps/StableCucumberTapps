package exceptions;

/**
 * Custom exception ~ BrowserSetupFailedException thrown when browser Setup is failed.
 */
@SuppressWarnings("serial")
public class BrowserSetupFailedException extends RuntimeException {
	
	public BrowserSetupFailedException(String message) {
		super(message);
	}
	
	public BrowserSetupFailedException(String message, Throwable cause) {
		super(message, cause);
	}
}
package exceptions;

@SuppressWarnings("serial")
public class BrowserSetupFailedException extends RuntimeException {
	
	public BrowserSetupFailedException(String message) {
		super(message);
	}
	
	public BrowserSetupFailedException(String message, Throwable cause) {
		super(message, cause);
	}
}
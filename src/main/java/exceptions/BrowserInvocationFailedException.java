package exceptions;

@SuppressWarnings("serial")
public class BrowserInvocationFailedException extends RuntimeException {
	
	public BrowserInvocationFailedException(String message) {
		super(message);
	}
	
	public BrowserInvocationFailedException(String message, Throwable cause) {
		super(message, cause);
	}
}
package exceptions;

@SuppressWarnings("serial")
public class UnexpectedResultCountException extends RuntimeException {
	
	public UnexpectedResultCountException(String message) {
		super(message);
	}
	
	public UnexpectedResultCountException(String message, Throwable cause) {
		super(message, cause);
	}
}
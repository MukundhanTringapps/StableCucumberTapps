package exceptions;

@SuppressWarnings("serial")
public class ImproperWaitStrategyUsageException extends Exception {

	public ImproperWaitStrategyUsageException(String message) {
		super(message);
	}
	
	public ImproperWaitStrategyUsageException(String message, Throwable cause) {
		super(message, cause);
	}
}

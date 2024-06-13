package exceptions;

/**
 * Custom exception ~ ImproperWaitStrategyUsageException thrown when improper wait strategy is used.
 */
@SuppressWarnings("serial")
public class ImproperWaitStrategyUsageException extends Exception {

	public ImproperWaitStrategyUsageException(String message) {
		super(message);
	}
	
	public ImproperWaitStrategyUsageException(String message, Throwable cause) {
		super(message, cause);
	}
}

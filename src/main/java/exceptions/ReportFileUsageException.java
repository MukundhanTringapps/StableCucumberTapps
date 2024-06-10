package exceptions;

@SuppressWarnings("serial")
public class ReportFileUsageException extends RuntimeException {
	
	public ReportFileUsageException(String message) {
		super(message);
	}
	
	public ReportFileUsageException(String message, Throwable cause) {
		super(message, cause);
	}
}
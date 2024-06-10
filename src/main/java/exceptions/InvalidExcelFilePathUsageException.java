package exceptions;

@SuppressWarnings("serial")
public class InvalidExcelFilePathUsageException extends RuntimeException {
	
	public InvalidExcelFilePathUsageException(String message) {
		super(message);
	}
	
	public InvalidExcelFilePathUsageException(String message, Throwable cause) {
		super(message, cause);
	}
}
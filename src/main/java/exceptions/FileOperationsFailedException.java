package exceptions;

@SuppressWarnings("serial")
public class FileOperationsFailedException extends RuntimeException {
	
	public FileOperationsFailedException(String message) {
		super(message);
	}
	
	public FileOperationsFailedException(String message, Throwable cause) {
		super(message, cause);
	}
}
package _02.exception.handling.xmlBased.model;

public class DatabaseException extends Exception {

	private String errorCode;
	private String errorName;
	
	public DatabaseException(String errorCode, String errorName) {
		super();
		this.errorCode = errorCode;
		this.errorName = errorName;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorName() {
		return errorName;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
	
	
	
	
}

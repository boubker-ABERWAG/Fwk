package fr.sofnul.bk.fmk.exception;

public class FmkTechnicalException extends FmkException {

	private static final long serialVersionUID = 6631211588465363610L;

	public FmkTechnicalException() {
		super();
	}

	/**
	 * @param errorCode
	 * @param arguments
	 */
	public FmkTechnicalException(String errorCode, Object... arguments) {
		super(errorCode, arguments);
	}

	/**
	 * @param errorCode
	 */
	public FmkTechnicalException(String errorCode) {
		super(errorCode);
	}

	/**
	 * @param cause
	 * @param errorCode
	 * @param arguments
	 */
	public FmkTechnicalException(Throwable cause, String errorCode, Object... arguments) {
		super(cause, errorCode, arguments);
	}

	/**
	 * @param cause
	 * @param errorCode
	 */
	public FmkTechnicalException(Throwable cause, String errorCode) {
		super(cause, errorCode);
	}

}
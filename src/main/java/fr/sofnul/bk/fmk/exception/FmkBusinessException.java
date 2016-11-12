package fr.sofnul.bk.fmk.exception;

/**
 * @author Boubker ABERWAG
 */
public class FmkBusinessException extends FmkException {

	private static final long serialVersionUID = -4792589400582790845L;

	public FmkBusinessException() {
		super();
	}

	/**
	 * @param errorCode
	 * @param arguments
	 */
	public FmkBusinessException(String errorCode, Object... arguments) {
		super(errorCode, arguments);
	}

	/**
	 * @param errorCode
	 */
	public FmkBusinessException(String errorCode) {
		super(errorCode);
	}

	/**
	 * @param cause
	 * @param errorCode
	 * @param arguments
	 */
	public FmkBusinessException(Throwable cause, String errorCode, Object... arguments) {
		super(cause, errorCode, arguments);
	}

	/**
	 * @param cause
	 * @param errorCode
	 */
	public FmkBusinessException(Throwable cause, String errorCode) {
		super(cause, errorCode);
	}

}
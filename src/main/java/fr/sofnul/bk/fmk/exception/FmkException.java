package fr.sofnul.bk.fmk.exception;

import java.util.ArrayList;
import java.util.List;

import fr.sofnul.bk.fmk.error.ErrorUtil;
import fr.sofnul.bk.fmk.locale.CurrentLocale;

/**
 * @author Boubker ABERWAG
 */
public class FmkException extends RuntimeException {

	private static final long serialVersionUID = 5030075999994100505L;

	private String errorCode;

	private String errorMessage;

	private List<String> fields;

	public FmkException() {
	}

	/**
	 * Create a new SBDGBusinessException with argument errorCode
	 *
	 * @param errorCode
	 *            code defined in the errors message bundle
	 * @see #getErrorMessage(String, Object[])
	 */
	public FmkException(String errorCode) {
		this(errorCode, (Object) null);
	}

	/**
	 * Create a new SBDGBusinessException with mutiple arguments
	 *
	 * @param errorCode
	 *            code defined in the errors message bundle
	 * @param arguments
	 *            variable arguments of the base message
	 * @see #getErrorMessage(String, Object[])
	 */
	public FmkException(String errorCode, Object... arguments) {
		this(null, errorCode, arguments);
	}

	/**
	 * Create a new SBDGBusinessException with no argument
	 *
	 * @param cause
	 *            nested exception
	 * @param errorCode
	 *            code defined in the errors message bundle
	 * @see #getErrorMessage(String, Object[])
	 */
	public FmkException(Throwable cause, String errorCode) {
		this(cause, errorCode, (Object) null);
	}

	/**
	 * Create a new SBDGBusinessException with mutiple arguments
	 *
	 * @param cause
	 *            nested exception
	 * @param errorCode
	 *            code defined in the errors message bundle
	 * @param arguments
	 *            variable arguments of the base message
	 * @see #getErrorMessage(String, Object[])
	 */
	public FmkException(Throwable cause, String errorCode, Object... arguments) {
		super(ErrorUtil.getErrorMessage(CurrentLocale.getCurrentLocale(), errorCode, arguments), cause);
		this.fields = new ArrayList<String>();
		for (Object o : arguments) {
			if (o != null) {
				this.fields.add(o.toString());
			}
		}
		this.errorCode = errorCode;
		this.errorMessage = ErrorUtil.getErrorMessage(CurrentLocale.getCurrentLocale(), errorCode, arguments);

	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String message) {
		this.errorMessage = message;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

}
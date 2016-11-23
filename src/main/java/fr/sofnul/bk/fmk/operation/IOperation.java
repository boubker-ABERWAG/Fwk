package fr.sofnul.bk.fmk.operation;

import org.springframework.stereotype.Component;

/**
 * @author Boubker ABERWAG
 */
@Component
public interface IOperation {

	/**
	 * This method checks the input parameters
	 */
	void checkParameters(Object... params);

	/**
	 * This method must be implemented to process the service operation.
	 *
	 * @return Object
	 */
	Object process(Object... params);

}
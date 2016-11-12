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
	abstract void checkParameters();

	/**
	 * This method must be implemented to process the service operation. in this
	 * method we will map BO to DTO or inverse. We will call the component.
	 *
	 * @return Object
	 */
	abstract Object process();

}
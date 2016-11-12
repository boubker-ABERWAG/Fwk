package fr.sofnul.bk.fmk.component.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import fr.sofnul.bk.fmk.component.IComponent;
import fr.sofnul.bk.fmk.operation.IOperation;
import fr.sofnul.bk.fmk.utils.ServiceUtil;

/**
 * @author Boubker ABERWAG
 */
public abstract class AbstractComponent implements IComponent, ApplicationContextAware {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractComponent.class);

	protected ApplicationContext applicationContext = null;

	public AbstractComponent() {
		LOGGER.debug("# Fmk - Component # new " + getClass().getSimpleName());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	/**
	 * This methods returns the ComponentOperation related to its interface.
	 *
	 * @param interfaceOfComponentOp
	 * @return <T> IOperation
	 * @param interfaceOfComponentOp
	 * @return
	 */
	public <T extends IOperation> T getComponentOperation(Class<T> interfaceOfComponentOp) {
		return ServiceUtil.getComponentOperation(applicationContext, interfaceOfComponentOp);
	}
}

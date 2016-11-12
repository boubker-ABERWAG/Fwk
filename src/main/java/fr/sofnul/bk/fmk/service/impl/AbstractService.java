package fr.sofnul.bk.fmk.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import fr.sofnul.bk.fmk.component.IComponent;
import fr.sofnul.bk.fmk.service.IService;
import fr.sofnul.bk.fmk.utils.ServiceUtil;

/**
 * @author Boubker ABERWAG
 */
public abstract class AbstractService implements IService, ApplicationContextAware {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractService.class);

	protected ApplicationContext applicationContext;

	public AbstractService() {
		LOGGER.debug("#FWK# new " + getClass().getSimpleName());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	/**
	 * This methods returns the Component related to its interface.
	 *
	 * @param <E>
	 * @param interfaceOfComponent
	 * @return
	 */
	protected <E extends IComponent> E getComponent(Class<E> interfaceOfComponent) {
		return ServiceUtil.getComponent(applicationContext, interfaceOfComponent);
	}

}

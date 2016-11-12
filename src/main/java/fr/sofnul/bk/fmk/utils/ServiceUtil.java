package fr.sofnul.bk.fmk.utils;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import fr.sofnul.bk.fmk.bo.IObjectBaseBO;
import fr.sofnul.bk.fmk.component.IComponent;
import fr.sofnul.bk.fmk.dao.IDao;
import fr.sofnul.bk.fmk.exception.FmkTechnicalException;
import fr.sofnul.bk.fmk.operation.IOperation;

/**
 * @author Boubker ABERWAG
 */
public final class ServiceUtil {

	private static Logger LOGGER = LoggerFactory.getLogger(ServiceUtil.class);

	public static final String NULL_APPLICATION_CONTEXT_MSG = "Application context cannot be null";

	private static final String UNKNOW_ERROR_CODE = "";

	/**
	 * Private constructor : we don't allow instanciation of this class
	 */
	private ServiceUtil() {
	}

	/**
	 * Provides access to the implementation of a Component
	 *
	 * @param context
	 *            SPRING Application Context
	 * @param interfaceOfComponent
	 *            Interface of Component, for which to return an implementation
	 * @return Component implementation for the requested interface
	 * @throws FmkTechnicalException
	 *             if the bean could not be obtained
	 */
	@SuppressWarnings("unchecked")
	public static <T extends IComponent> T getComponent(ApplicationContext context, Class<T> interfaceOfComponent)
			throws FmkTechnicalException {

		Assert.notNull(context, NULL_APPLICATION_CONTEXT_MSG);

		T bean;
		try {
			LOGGER.debug("spring app context id {}", context.getId());
			bean = context.getBean(interfaceOfComponent);
		} catch (BeansException e) {
			LOGGER.error("Error to load Component {}", interfaceOfComponent.getSimpleName());
			LOGGER.error(e.toString(), e);
			throw new FmkTechnicalException(UNKNOW_ERROR_CODE);
		}

		return bean;
	}

	/**
	 * Provides access to the implementation of a Component Operation
	 *
	 * @param context
	 *            SPRING Application Context
	 * @param interfaceOfComponentOp
	 *            Interface of Component operation, for which to return an
	 *            implementation
	 * @return Component Operation implementation for the requested interface
	 * @throws FmkTechnicalException
	 *             if the bean could not be obtained
	 */
	@SuppressWarnings("unchecked")
	public static <T extends IOperation> T getComponentOperation(ApplicationContext context,
			Class<T> interfaceOfComponentOperation) throws FmkTechnicalException {

		Assert.notNull(context, NULL_APPLICATION_CONTEXT_MSG);

		T bean;
		try {
			LOGGER.debug("spring app context id {}", context.getId());
			bean = context.getBean(interfaceOfComponentOperation);
		} catch (BeansException e) {
			LOGGER.error("Error to load ComponentOperation {}", interfaceOfComponentOperation.getSimpleName());
			LOGGER.error(e.toString(), e);
			throw new FmkTechnicalException(UNKNOW_ERROR_CODE);
		}

		return bean;
	}

	/**
	 * Provides access to the implementation of a Dao
	 *
	 * @param context
	 *            SPRING Application Context
	 * @param interfaceOfDao
	 *            Interface of Dao, for which to return an implementation
	 * @return Dao implementation for the requested interface
	 * @throws FmkTechnicalException
	 *             if the bean could not be obtained
	 */
	@SuppressWarnings("unchecked")
	public static <T extends IDao<? extends IObjectBaseBO<? extends Serializable>, ? extends Serializable>> T getDao(
			ApplicationContext context, Class<T> interfaceOfDao) throws FmkTechnicalException {

		Assert.notNull(context, NULL_APPLICATION_CONTEXT_MSG);

		T bean;
		try {
			LOGGER.debug("spring app context id {}", context.getId());
			bean = context.getBean(interfaceOfDao);
		} catch (BeansException e) {
			LOGGER.error("Error to load Dao", interfaceOfDao.getSimpleName());
			LOGGER.error(e.toString(), e);
			throw new FmkTechnicalException(UNKNOW_ERROR_CODE);
		}

		return bean;
	}

}

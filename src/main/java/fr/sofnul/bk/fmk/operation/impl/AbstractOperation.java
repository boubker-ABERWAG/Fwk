package fr.sofnul.bk.fmk.operation.impl;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import fr.sofnul.bk.fmk.bo.IObjectBaseBO;
import fr.sofnul.bk.fmk.dao.IDao;
import fr.sofnul.bk.fmk.operation.IOperation;
import fr.sofnul.bk.fmk.utils.ServiceUtil;;

/**
 * @author Boubker ABERWAG
 */
public abstract class AbstractOperation implements IOperation, ApplicationContextAware {

	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractOperation.class);

	protected ApplicationContext applicationContext;

	public AbstractOperation() {
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		this.applicationContext = applicationContext;
	}

	/**
	 * Provides access to the implementation of a Dao
	 *
	 * @param interfaceOfDao
	 *            Interface of Dao, for which to return an implementation
	 * @return Dao implementation for the requested interface
	 */
	protected <E extends IDao<? extends IObjectBaseBO<? extends Serializable>, ? extends Serializable>> E getDao(
			Class<E> interfaceOfDao) {
		return ServiceUtil.getDao(applicationContext, interfaceOfDao);
	}
}
package fr.sofnul.bk.fmk.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import fr.sofnul.bk.fmk.bo.IObjectBaseBO;

/**
 * @author Boubker ABERWAG
 * @param <T>
 * @param <K>
 */
@NoRepositoryBean
public interface IDao<T extends IObjectBaseBO<? extends Serializable>, K extends Serializable> extends JpaRepository<T, K> {

}
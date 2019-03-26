/**
 * Base business class to be implemented by the business layer.
 */
package com.faire.engage.api.base;

import java.io.Serializable;
import java.util.List;

/**
 * @author William Matos de Carvalho
 * @param <E>
 * @param <ID>
 *
 */
public interface BaseBusiness<E extends BaseEntity<?>, ID extends Serializable> extends Serializable {

	/**
	 * 
	 * @param entity
	 * @return
	 */
	public E processInsert(final E entity);
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public E processUpdate(final E entity);
	
	/**
	 * @param entity
	 */
	public void processRemove(final E entity);
	
	/**
	 * @param id
	 * @return
	 */
	public E find(final ID id);
	
	/**
	 * @return
	 */
	public List<E> findAll();
}

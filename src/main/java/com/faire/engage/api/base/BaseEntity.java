
package com.faire.engage.api.base;

import java.io.Serializable;

/**
 * @author William Matos de Carvalho
 *
 * @param <ID>
 */
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

	/**
	 * s
	 */
	private static final long serialVersionUID = -762609424836423244L;

	/**
	 * @return
	 */
	public abstract ID getId();

	/**
	 * @param id
	 */
	public abstract void setId(final ID id);
}

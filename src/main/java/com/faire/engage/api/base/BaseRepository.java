/**
 * Base repository class to be implemented by the repository layer.
 */
package com.faire.engage.api.base;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author William Matos de Carvalho
 * @param <E>
 * @param <ID>
 *
 */
public interface BaseRepository<E extends BaseEntity<?>, ID extends Serializable> extends CrudRepository<E, ID>, JpaRepository<E, ID> {

}

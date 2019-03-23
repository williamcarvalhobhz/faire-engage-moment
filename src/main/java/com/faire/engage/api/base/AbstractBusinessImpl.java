package com.faire.engage.api.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.faire.engage.api.enums.TransactionType;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * @author William Matos de Carvalho
 *
 * @param <E>
 * @param <ID>
 */
@Component
@Getter(value = AccessLevel.PROTECTED)
@Transactional(propagation = Propagation.SUPPORTS)
public abstract class AbstractBusinessImpl<E extends BaseEntity<?>, ID extends Serializable> implements BaseBusiness<E, ID> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5940423899081013014L;
	
	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(AbstractBusinessImpl.class);
	
	/**
	 * 
	 */
	public AbstractBusinessImpl() {
		log.debug("Iniciando a camada de negócios abstrata...");
	}

	/**
	 * 
	 */
    @Override
	@Transactional(propagation = Propagation.REQUIRED)
	public E processInsert(final E entity){
		return execute(entity, TransactionType.INSERT);
	}


	/**
	 * 
	 */
        @Override
	@Transactional(propagation = Propagation.REQUIRED)
	public E processUpdate(final E entity){
		return execute(entity, TransactionType.UPDATE);
	}
	
	/**
	 * 
	 */
        @Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void processRemove(final E entity){
		execute(entity);
	}
	
	/**
	 * @param id
	 * @return
	 */
        @Override
	public E find(final ID id) {
		return getRepository().findOne(id);
	}
	
	/**
	 * @return
	 */
        @Override
	public List<E> findAll() {
		return getRepository().findAll();
	}

	/**
	 * 
	 * @param entity
	 * @param transactionType
         * @return  
	 */
	protected E execute(final E entity, final TransactionType transactionType) {
		beforeInsertOrUpdate(entity, transactionType);
		final E merged = insertOrUpdate(entity, transactionType);
		afterInsertOrUpdate(entity, transactionType);
		
		return merged;
	}
	
	/**
	 * 
	 * @param entity
	 */
	protected void execute(final E entity) {
		beforeDelete(entity);
		delete(entity);
		afterDelete(entity);
	}
	
	/**
	 * 
	 * @param entities
	 */
	protected void execute(final Collection<E> entities) {
		beforeDelete(entities);
		delete(entities);
		afterDelete(entities);
	}
	
	/**
	 * 
	 * @param entity
	 * @param transactionType
	 * @return
	 */
	protected E insertOrUpdate(final E entity, final TransactionType transactionType) {
		return getRepository().save(entity);
	}
	
	/**
	 * @param entity
	 */
	protected void delete(final E entity) {
		getRepository().delete(entity);
	}
	
	/**
         * @param id
	 */
	protected void delete(final ID id) {
		getRepository().delete(id);
	}
	
	/**
	 * 
	 * @param entities
	 */
	protected void delete(final Collection<E> entities) {
		getRepository().delete(entities);
	}
	
	/**
	 * @param entity
	 * @param transactionType
	 */
	protected void beforeInsertOrUpdate(final E entity, final TransactionType transactionType) {
		
	}
		
	/**
	 * @param entity
	 * @param transactionType
	 */
	protected void afterInsertOrUpdate(final E entity, final TransactionType transactionType) {
		
	}
	
	/**
	 * @param entity
	 */
	protected void beforeDelete(final E entity) {
		
	}
	
	/**
	 * @param entity
	 */
	protected void afterDelete(final E entity) {
		
	}
	
	/**
	 * @param entities
	 */
	protected void beforeDelete(final Collection<E> entities) {
		
	}
	
	/**
	 * @param entities
	 */
	protected void afterDelete(final Collection<E> entities) {
		
	}
	
	/**
	 * @return
	 */
	protected abstract BaseRepository<E, ID> getRepository();
}

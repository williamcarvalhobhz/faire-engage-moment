/**
 * Implementation of the product option business.
 */
package com.faire.engage.api.buiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.faire.engage.api.base.AbstractBusinessImpl;
import com.faire.engage.api.entities.ProductOption;
import com.faire.engage.api.repositories.ProductOptionRepository;

import lombok.Getter;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
@Component
@Transactional(propagation = Propagation.SUPPORTS)
public class ProductOptionBusinessImpl extends AbstractBusinessImpl<ProductOption, String>  implements ProductOptionBusiness {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Autowired
	private ProductOptionRepository repository;
	
}

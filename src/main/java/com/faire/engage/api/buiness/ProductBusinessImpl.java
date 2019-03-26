/**
 * Implementation of the product business.
 */
package com.faire.engage.api.buiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.faire.engage.api.base.AbstractBusinessImpl;
import com.faire.engage.api.entities.Product;
import com.faire.engage.api.repositories.ProductRepository;

import lombok.Getter;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
@Component
public class ProductBusinessImpl extends AbstractBusinessImpl<Product, String>  implements ProductBusiness {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Autowired
	private ProductRepository repository;

}

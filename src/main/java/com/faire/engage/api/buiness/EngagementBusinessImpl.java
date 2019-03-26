/**
 * Implementation of the engagement business.
 */
package com.faire.engage.api.buiness;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.faire.engage.api.base.AbstractBusinessImpl;
import com.faire.engage.api.entities.Engagement;
import com.faire.engage.api.entities.Product;
import com.faire.engage.api.entities.ProductOption;
import com.faire.engage.api.repositories.EngagementRepository;
import com.faire.engage.api.repositories.ProductOptionRepository;
import com.faire.engage.api.repositories.ProductRepository;

import lombok.Getter;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
@Component
@Transactional(propagation = Propagation.SUPPORTS)
public class EngagementBusinessImpl extends AbstractBusinessImpl<Engagement, String>  implements EngagementBusiness {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Autowired
	private EngagementRepository repository;
	
	@Getter
	@Autowired
	private ProductRepository productRepository;
	
	@Getter
	@Autowired
	private ProductOptionRepository productOptionRepository;	
	
	/**
	 * Populates the HSQL database with some data.
	 * 
	 * @throws ParseException
	 */
    @PostConstruct
    public void populate() throws ParseException {    	
    		
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    		
    		Product product = new Product();
    		product.setName("Moonstone Crystal Candle - Brings Good Luck");
    		product.setDescription("Hidden inside is a Moonstone that increases your intuition and connects you to the moon's energy to inspire new beginnings. Once your candle has burned retrieve your crystal and carry it with you, or place it in a sacred space to bring good fortune within the flow of your life. Hand-poured and made with 100% American farmed soy wax, the natural essential + fragrance oil blend features notes of citrus and sweet fruit. • 9 oz Jar • Silver Lid • 50 Hour Burn Time");
    		product.setActive(true);
    		product.setCreatedAt(new Date());
    		product.setUpdatedAt(new Date());
    		product = getProductRepository().save(product);   	
    		
    		ProductOption option = new ProductOption();
    		option.setProductId(product.getId());
    		option.setActive(true);
    		option.setName("9 oz");
    		option.setAvailableQuantity(1000);
    		option.setSku("SH83DHSK");    		
    		option.setCreatedAt(new Date());
    		option.setUpdatedAt(new Date());
    		option = getProductOptionRepository().save(option);       
    		    		
    		Engagement engagement = new Engagement();
    		engagement.setProduct(product);
    		engagement.setStartsAt(sdf.parse("2019-03-23 00:00:00"));
    		engagement.setEndsAt(sdf.parse("2019-03-30 23:59:00"));
    		engagement.setInitialDiscount(5);
    		engagement.setFinalDiscount(15);
    		engagement.setActualDiscount(12);
    		engagement.setAtive(true);
    		engagement.setImageUrl("https://cdn.faire.com/res/hszgttpjt/image/upload/e5ad690ffcaae0582954aef7321e57bc97b4c5630eb674e8cdcca73f49166de6/1518562775.jpg?dpr=1&fit=crop&format=jpg&height=450&width=450");
    		engagement = getRepository().save(engagement);

    }		
		

    /**
     * Find the open Engagements and fetch the sub-classes
     */
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Engagement> findByDate(final Date date, final Boolean ative){
		List<Engagement> result = getRepository().findByDate(date, ative);
		for(Engagement e : result){
			if(e.getProduct()!=null){
				Hibernate.initialize(e.getProduct().getOptions());
			}
		}
		return result;
	}

}

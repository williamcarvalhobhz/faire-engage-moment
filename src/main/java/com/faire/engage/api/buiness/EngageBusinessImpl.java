package com.faire.engage.api.buiness;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.faire.engage.api.base.AbstractBusinessImpl;
import com.faire.engage.api.entities.Engage;
import com.faire.engage.api.entities.Product;
import com.faire.engage.api.repositories.EngageRepository;
import com.faire.engage.api.repositories.ProductRepository;

import lombok.Getter;


@Component
@Transactional(propagation = Propagation.SUPPORTS)
public class EngageBusinessImpl extends AbstractBusinessImpl<Engage, String>  implements EngageBusiness {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Autowired
	private EngageRepository repository;

	@Getter
	@Autowired
	private ProductRepository productRepository;
	
    @PostConstruct
    public void populate() throws ParseException {    	
    		
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    		
    		Product product = new Product();
		product.setName("Moonstone Crystal Candle - Brings Good Luck | 9 oz — $10");
		product.setDescription("Hidden inside is a Moonstone that increases your intuition and connects you to the moon's energy to inspire new beginnings. Once your candle has burned retrieve your crystal and carry it with you, or place it in a sacred space to bring good fortune within the flow of your life. Hand-poured and made with 100% American farmed soy wax, the natural essential + fragrance oil blend features notes of citrus and sweet fruit. • 9 oz Jar • Silver Lid • 50 Hour Burn Time");
		product.setCreated_at(new Date());
		product.setUpdated_at(new Date());
		product = getProductRepository().save(product);
				
    		Engage engage = new Engage();
    		engage.setProduct(product);
    		engage.setStarts_at(sdf.parse("2019-03-23 00:00:00"));
    		engage.setEnds_at(sdf.parse("2019-03-25 23:59:00"));
    		engage.setInitial_discount(5);
    		engage.setFinal_discount(15);
    		engage.setActual_discount(12);
    		engage.setAtive(true);
    		engage.setImage_url("https://cdn.faire.com/res/hszgttpjt/image/upload/e5ad690ffcaae0582954aef7321e57bc97b4c5630eb674e8cdcca73f49166de6/1518562775.jpg?dpr=1&fit=crop&format=jpg&height=450&width=450");
    		getRepository().save(engage);
    }	
	
	public List<Engage> findByDate(final Date date, final Boolean ative){
		return getRepository().findByDate(date, ative);
	}

}

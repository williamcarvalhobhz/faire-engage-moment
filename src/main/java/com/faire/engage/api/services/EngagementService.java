package com.faire.engage.api.services;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.faire.engage.api.buiness.EngagementBusiness;
import com.faire.engage.api.buiness.ProductOptionBusiness;
import com.faire.engage.api.entities.Engagement;

import lombok.Getter;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
@Service
@Path("engagements/")
public class EngagementService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Autowired
	private EngagementBusiness business;
	
	@Getter
	@Autowired
	private ProductOptionBusiness productOptionBusiness;
	
	/**
	 * 
	 * @return The Open an Active Engagements
	 */
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Engagement> findOpenEngagements() {

		return getBusiness().findByDate(new Date(), true);
	}

}

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

import com.faire.engage.api.buiness.EngageBusiness;
import com.faire.engage.api.entities.Engage;

import lombok.Getter;

@Service
@Path("engaged/")
public class EngageService implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Getter
	@Autowired
	private EngageBusiness business;
	
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Engage> findOpenedEngages() {
			
		return getBusiness().findByDate(new Date(), true);
	}

}

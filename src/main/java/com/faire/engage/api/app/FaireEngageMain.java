/**
 * This application is responsible for providing HTTP services for
 * the Faire Engage Moment iOS App proposed for the
 * Vanhack's Hackaton.
 * 
 * Stack: Spring, Spring Data, Hibernate, Jersey, Jackson
 */
package com.faire.engage.api.app;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.faire.engage.api.services.EngagementService;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
public class FaireEngageMain {
	
	private final static int port = 80;	
	private final static String host = "http://localhost/";	
	
	@SuppressWarnings("resource")
	public static void main(String[] args){
		
		//Creating the Spring Application Context
		new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
	
		final URI baseUri = UriBuilder.fromUri(host).port(port).path("api/v2").build();
		
		//Defining the services to be provided
		final ResourceConfig config = new ResourceConfig(
				EngagementService.class
		);

		//Starting the HTTP server
		JdkHttpServerFactory.createHttpServer(baseUri, config);
	}		
}

package com.faire.engage.api.app;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.faire.engage.api.services.EngageService;


public class FaireEngageMain {
	
	private final static int port = 80;	
	private final static String host = "http://localhost/";	
	
	@SuppressWarnings("resource")
	public static void main(String[] args){
		
		
		new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
	
		final URI baseUri = UriBuilder.fromUri(host).port(port).path("api/v2").build();
		final ResourceConfig config = new ResourceConfig(
				EngageService.class
		);

		JdkHttpServerFactory.createHttpServer(baseUri, config);
	}
}

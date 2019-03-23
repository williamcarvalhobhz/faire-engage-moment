package com.faire.engage.api.base;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import lombok.Getter;

public class ApplicationContextInject implements ApplicationContextAware {
	
	@Getter
	private static final ApplicationContextInject instance = new ApplicationContextInject();
	
	public static ApplicationContext context;

	@Override
	public void setApplicationContext(final ApplicationContext context) throws BeansException {
		ApplicationContextInject.context = context;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getBean(final Class<?> clazz) {
		return (T) ApplicationContextInject.context.getBean(clazz);
	}
	

}

package com.servinglynk.hmis.warehouse.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.servinglynk.hmis.warehouse.base.dao.BaseDaoFactoryImpl;
import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.rest.ClientsController;
import com.servinglynk.hmis.warehouse.rest.ConsentsController;
import com.servinglynk.hmis.warehouse.rest.HealthController;

@Configuration
@Import({ com.servinglynk.hmis.warehouse.base.dao.config.BaseDatabaseConfig.class,
		com.servinglynk.hmis.warehouse.base.service.config.BaseServiceConfig.class,
		
		 com.servinglynk.hmis.warehouse.base.dao.config.HibernateConfig.class,
		com.servinglynk.hmis.warehouse.client.config.SpringConfig.class})
@EnableWebMvc
@EnableTransactionManagement
public class GlobalAPIConfig extends WebMvcConfigurerAdapter {

	public void configureMessageConverters(
			List<HttpMessageConverter<?>> messageConverters) {

		MappingJackson2HttpMessageConverter jmc = new MappingJackson2HttpMessageConverter();
		jmc.setObjectMapper(new JSONObjectMapper());
		messageConverters.add(jmc);
		messageConverters.add(createXmlHttpMessageConverter());
		super.configureMessageConverters(messageConverters);
	}

	private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
		MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();

		XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
		xmlConverter.setMarshaller(xstreamMarshaller);
		xmlConverter.setUnmarshaller(xstreamMarshaller);

		return xmlConverter;
	}	
	
/*	@Bean
	public BaseDaoFactoryImpl baseDaoFactoryImpl(){
		return new BaseDaoFactoryImpl();
	}*/
	
	@Autowired
	Environment env;
		
	 @Bean
	 public HealthController healthController(){
		 return new HealthController();
	 }
	 
	 @Bean
	 public ConsentsController consentsController(){
		 return new ConsentsController();
	 }
	 
	 @Bean
	 public ClientsController clientsController(){
		 return new ClientsController();
	 }
}
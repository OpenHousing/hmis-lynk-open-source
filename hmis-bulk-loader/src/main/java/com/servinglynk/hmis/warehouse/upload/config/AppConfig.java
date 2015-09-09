package com.servinglynk.hmis.warehouse.upload.config;

import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.servinglynk.hmis.warehouse.config.DatabaseConfig;


@Configuration 
@ComponentScan("com.servinglynk.hmis.warehouse.upload") 
@Import({ com.servinglynk.hmis.warehouse.sync.config.SpringConfig.class,DatabaseConfig.class})
@EnableWebMvc   
@EnableTransactionManagement
@EnableScheduling
public class AppConfig extends WebMvcConfigurerAdapter {
	
	 @Bean
	 public CommonsMultipartResolver commonsMultipartResolver(){
	     CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
	     commonsMultipartResolver.setDefaultEncoding("utf-8");
	     commonsMultipartResolver.setMaxUploadSize(50000000);
	     return commonsMultipartResolver;
	 }
	
	@Bean  
    public UrlBasedViewResolver setupViewResolver() {  
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();  
        resolver.setPrefix("/WEB-INF/views/");  
        resolver.setSuffix(".jsp");  
        resolver.setViewClass(JstlView.class);
        return resolver;  
    }
}
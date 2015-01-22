package com.angular.spring.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * @Autor Samuel.Guardado
 * @FechaCreacion 20/01/2015
 */
@EnableWebMvc
@ComponentScan("com.angular.spring.controller")
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    
	
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	

	@Override
	 public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	    configurer.favorPathExtension(false).
	            favorParameter(true).
	            parameterName("mediaType").
	            ignoreAcceptHeader(true).
	            useJaf(false).
	            defaultContentType(MediaType.APPLICATION_JSON).
	            mediaType("xml", MediaType.APPLICATION_XML).
	            mediaType("json", MediaType.APPLICATION_JSON);
	  }
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
		resourceViewResolver.setPrefix("/WEB-INF/template/");
		resourceViewResolver.setSuffix(".html");
		return resourceViewResolver;
	}
	
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").
        addResourceLocations("/WEB-INF/resources/");
    }
	

	/*@Bean
    public MappingJackson2JsonView mappingJacksonJsonView() {
            return new MappingJackson2JsonView();
    }
	
	@Bean
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
            final ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
            contentNegotiatingViewResolver
                            .setDefaultContentType(MediaType.APPLICATION_JSON);
            final ArrayList<View> defaultViews = new ArrayList<View>();
            defaultViews.add(mappingJacksonJsonView());
            contentNegotiatingViewResolver.setDefaultViews(defaultViews);
            return contentNegotiatingViewResolver;
    }*/
	
	
    
}

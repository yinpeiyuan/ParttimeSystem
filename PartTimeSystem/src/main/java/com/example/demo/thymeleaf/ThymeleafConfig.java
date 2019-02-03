//package com.example.demo.thymeleaf;
//
//import nz.net.ultraq.thymeleaf.LayoutDialect;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//
//@Configuration
//public class ThymeleafConfig extends WebMvcConfigurationSupport {
//
//    private ApplicationContext applicationContext;
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setForceEncoding(true);
//        characterEncodingFilter.setEncoding("UTF-8");
//        registrationBean.setFilter(characterEncodingFilter);
//        return registrationBean;
//    }
//
//
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        super.addResourceHandlers(registry);
//    }
//    @Bean
//    @ConfigurationProperties(prefix = "spring.thymeleaf")
//    public SpringResourceTemplateResolver templateResolver(){
//        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//        resolver.setApplicationContext(applicationContext);
//        resolver.setCharacterEncoding("UTF-8");
//
//        return  resolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine(){
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setEnableSpringELCompiler(true);
//        templateEngine.addDialect(new LayoutDialect());
//        return templateEngine;
//    }
//
//
//@Bean
//    public ThymeleafViewResolver viewResolver(){
//        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
//        thymeleafViewResolver.setTemplateEngine(templateEngine());
//        return thymeleafViewResolver;
//}
//
//
//}

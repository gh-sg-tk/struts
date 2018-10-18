package org.superbiz.struts;


import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class Application {
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }



    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new FilterDispatcher());

        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(0);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean ActionContextCleanUp(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new ActionContextCleanUp());

        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean PageFilter(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new PageFilter());

        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }




}

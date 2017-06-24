package cn.sixlab.web;

import cn.sixlab.web.interceptor.ApiInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by patrick on 2017/6/20.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/home").setViewName("home");
        //registry.addViewController("/").setViewName("home");
        //registry.addViewController("/hello").setViewName("hello");
        //registry.addViewController("/login").setViewName("login");
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getApiInterceptor()).addPathPatterns("/api/**");
        super.addInterceptors(registry);
    }
    
    @Bean
    public ApiInterceptor getApiInterceptor(){
        return new ApiInterceptor();
    }
}

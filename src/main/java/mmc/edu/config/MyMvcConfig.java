package mmc.edu.config;

import mmc.edu.component.MyLocaleResolver;
import mmc.edu.intercepter.LoginIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyMvcConfig{

    @Bean
    public WebMvcConfigurer webMvcConfigurerAdapter(){
        return  new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/success").setViewName("success");
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                               registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/**")
                                    .excludePathPatterns("/","/login.html","/user/login","/webjars/**","/asserts/css/**","/asserts/js/**","/asserts/img/**");

            }
        };
    }


    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocaleResolver();
    }

}

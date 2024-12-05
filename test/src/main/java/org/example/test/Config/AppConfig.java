package org.example.test.Config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowCredentials(true)
//                .allowedOrigins("http://localhost:8080")
                .allowedOrigins("http://127.0.0.1:3000","http://localhost:8080","http://localhost:5173")
                .allowedMethods("*")
                .allowCredentials(true)
                .allowedHeaders("*");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:///D:/DTPM/Fe/shoptest/public/images/")
                .setCachePeriod(3600)
                .resourceChain(true);
    }
}

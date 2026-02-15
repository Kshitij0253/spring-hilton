package com.hiltonMicroSwitch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfig  {

    // @Value("${app.cors.allowed-origins}")
    // private String allowedOrigins;

    // @Override
    // public void addCorsMappings(CorsRegistry registry) {
    // 	registry.addMapping("/**")
    //                     .allowedOrigins(
    //                         "https://hilton-theta.vercel.app"
    //                     )
    //                     .allowedMethods("*")
    //                     .allowedHeaders("*")
    //                     .allowCredentials(false);
    // }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**")
                        .allowedOrigins(
                            "https://hilton-theta.vercel.app"
                        )
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .allowCredentials(false); // IMPORTANT
            }
        };
    }
}

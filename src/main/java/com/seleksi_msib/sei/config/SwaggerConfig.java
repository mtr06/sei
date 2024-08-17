package com.seleksi_msib.sei.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Proyek REST API")
                        .version("1.0.0")
                        .description("REST API untuk manajemen proyek dan lokasinya.")
                        .contact(new Contact().name("Muhammad Thoriq Ramadhan").email("thoriqramadhanm@gmail.com")));
    }
}

package com.ebac.modulo38.configuration;

import com.ebac.modulo38.service.DataBase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Bean
    public DataBase dataBase() {
        return new DataBase();
    }
}

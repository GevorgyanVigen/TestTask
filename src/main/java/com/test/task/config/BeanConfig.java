package com.test.task.config;

import com.test.task.util.MD5Encoder;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource.tomcat")
    public DataSource dataSource(){

        return new DataSource();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new MD5Encoder();
    }

}

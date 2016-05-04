package com.crowd.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by root on 02.04.2016.
 */
@Configuration
@Profile("prod")
@PropertySource({"classpath:hibernate.properties"})
public class BaseDataSource {

    @Autowired
    private Environment env;

    @Bean
    public DataSource restDataSource() {
        URI dbUri = null;
        try {
            dbUri = new URI(System.getenv("DATABASE_URL"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        final DriverManagerDataSource dataSource = new DriverManagerDataSource(dbUrl, username, password);
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        return dataSource;
    }

}

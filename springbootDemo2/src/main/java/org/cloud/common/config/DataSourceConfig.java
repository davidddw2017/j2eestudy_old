package org.cloud.common.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:c3p0.properties")
public class DataSourceConfig {
    @Primary
    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "c3p0")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
    }
}

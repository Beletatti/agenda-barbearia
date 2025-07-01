package io.github.barbeariagb.barbearia.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driver-class-name}")
    String driver;

    @Bean
    public DataSource hikariDataSource(){
        HikariConfig config = new HikariConfig();
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);

        config.setMaximumPoolSize(20); // maximo de conexões liberadas
        config.setMinimumIdle(1); // tamanho inicial do pool
        config.setPoolName("barbearia-db-pool");
        config.setMaxLifetime(600000); // tempo de conexão em ms (depois desse tempo mata a conexão e inicia outra)
        config.setConnectionTimeout(100000); // timeout para conseguir uma conexão
        config.setConnectionTestQuery("SELECT 1");

        return new HikariDataSource(config);
    }
}

package org.todo.todorails.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

@Configuration
@Profile("prod")
public class DatabaseConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        String databaseUrl = System.getenv("DATABASE_URL");
        
        if (databaseUrl != null && databaseUrl.startsWith("postgresql://")) {
            // Transform Render's PostgreSQL URL to JDBC format
            databaseUrl = "jdbc:" + databaseUrl;
            
            return DataSourceBuilder
                    .create()
                    .url(databaseUrl)
                    .driverClassName("org.postgresql.Driver")
                    .build();
        }
        
        // Fallback to H2 if no DATABASE_URL provided
        return DataSourceBuilder
                .create()
                .url("jdbc:h2:mem:todorails")
                .driverClassName("org.h2.Driver")
                .username("sa")
                .password("")
                .build();
    }
}

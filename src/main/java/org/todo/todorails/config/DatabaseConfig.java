package org.todo.todorails.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Primary;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

@Configuration
@Profile("prod")
public class DatabaseConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
        String databaseUrl = System.getenv("DATABASE_URL");
        
        if (databaseUrl != null && databaseUrl.startsWith("postgresql://")) {
            // Parse the URL: postgresql://username:password@host:port/database
            // Transform to JDBC format and extract credentials
            
            try {
                // Remove the postgresql:// prefix
                String urlWithoutPrefix = databaseUrl.substring("postgresql://".length());
                
                // Split into credentials and host parts
                String[] credentialsAndHost = urlWithoutPrefix.split("@", 2);
                String[] userAndPassword = credentialsAndHost[0].split(":", 2);
                String hostAndDb = credentialsAndHost[1];
                
                String username = userAndPassword[0];
                String password = userAndPassword[1];
                String jdbcUrl = "jdbc:postgresql://" + hostAndDb;
                
                return DataSourceBuilder
                        .create()
                        .url(jdbcUrl)
                        .username(username)
                        .password(password)
                        .driverClassName("org.postgresql.Driver")
                        .build();
            } catch (Exception e) {
                System.err.println("Error parsing DATABASE_URL: " + e.getMessage());
                // Fall through to H2 fallback
            }
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

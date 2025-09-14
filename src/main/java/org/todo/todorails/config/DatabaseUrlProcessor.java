package org.todo.todorails.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import jakarta.annotation.PostConstruct;

import java.net.URI;

@Configuration
@Profile("prod")
@Order(1) // Ensure this runs first
public class DatabaseUrlProcessor {

    @PostConstruct
    public void processDatabaseUrl() {
        String databaseUrl = System.getenv("DATABASE_URL");
        
        System.out.println("🚀 DatabaseUrlProcessor starting...");
        System.out.println("📍 DATABASE_URL: " + (databaseUrl != null ? "Found" : "Not found"));
        
        if (databaseUrl != null && databaseUrl.startsWith("postgresql://")) {
            try {
                URI uri = new URI(databaseUrl);
                String jdbcUrl = "jdbc:postgresql://" + uri.getHost() + ":" + uri.getPort() + uri.getPath();
                
                // Set Spring Boot's standard environment variables
                System.setProperty("spring.datasource.url", jdbcUrl);
                System.setProperty("spring.datasource.username", uri.getUserInfo().split(":")[0]);
                System.setProperty("spring.datasource.password", uri.getUserInfo().split(":")[1]);
                System.setProperty("spring.datasource.driver-class-name", "org.postgresql.Driver");
                
                // FORCE the DDL mode and dialect
                System.setProperty("spring.jpa.hibernate.ddl-auto", "create");
                System.setProperty("spring.jpa.database-platform", "org.hibernate.dialect.PostgreSQLDialect");
                System.setProperty("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
                
                System.out.println("✅ Successfully configured PostgreSQL connection from DATABASE_URL");
                System.out.println("🔗 JDBC URL: " + jdbcUrl);
                System.out.println("🛠️ DDL Mode: create");
                System.out.println("🗣️ Dialect: PostgreSQLDialect");
                
            } catch (Exception e) {
                System.err.println("❌ Error parsing DATABASE_URL: " + e.getMessage());
                throw new RuntimeException("Failed to parse DATABASE_URL", e);
            }
        } else {
            System.out.println("⚠️ DATABASE_URL not found, using default configuration");
        }
    }
}
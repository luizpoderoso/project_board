package com.lp.board.persistence.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    @Bean
    public Flyway flyway() {
        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost/project_board", "root", "32493403")
                .load();
        flyway.migrate();
        return flyway;
    }

}

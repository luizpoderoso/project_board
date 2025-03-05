package com.lp.board.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class ConnectionConfig {

    @Bean
    public static Connection getConnection() throws SQLException {
        var connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/project_board", "root", "32493403"
        );
        connection.setAutoCommit(false);
        return connection;
    }

}

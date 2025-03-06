package com.lp.board.persistence.dao.impl;

import com.lp.board.persistence.dao.ProjectDAO;
import com.lp.board.model.entity.ProjectEntity;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;

import static java.util.TimeZone.LONG;

@RequiredArgsConstructor
public class ProjectDAOImpl implements ProjectDAO {

    private final Connection connection;

    public void insert(ProjectEntity project) throws SQLException {
        try (var statement = connection.prepareCall("call prc_insert_project(?,?,?,?,?)")) {
            statement.registerOutParameter(5, LONG);
            statement.setLong(1, project.getAuthors().getFirst().getId());
            statement.setString(2, project.getName());
            statement.setString(3, project.getCategory());
            statement.setString(4, project.getDescription());
            statement.execute();
            project.setId(statement.getLong(5));
        }
    }

}

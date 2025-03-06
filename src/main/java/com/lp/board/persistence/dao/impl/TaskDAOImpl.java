package com.lp.board.persistence.dao.impl;

import com.lp.board.model.entity.TaskEntity;
import com.lp.board.persistence.dao.TaskDAO;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;

import static java.util.TimeZone.LONG;

@RequiredArgsConstructor
public class TaskDAOImpl implements TaskDAO {

    private final Connection connection;

    public void insert(TaskEntity task) throws SQLException {
        try (var statement = connection.prepareCall("call prc_insert_task_to_group(?,?,?,?,?,?)")) {
            statement.registerOutParameter(6, LONG);
            statement.setLong(1, task.getAuthors().getFirst().getId());
            statement.setLong(2, task.getGroups().getFirst().getId());
            statement.setString(3, task.getName());
            statement.setString(4, task.getResume());
            statement.setString(5, task.getDescription());
            statement.execute();
            task.setId(statement.getLong(6));
        }
    }

}

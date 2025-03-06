package com.lp.board.persistence.dao.impl;

import com.lp.board.persistence.dao.GroupDAO;
import com.lp.board.model.entity.GroupEntity;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;

import static java.util.TimeZone.LONG;

@RequiredArgsConstructor
public class GroupDAOImpl implements GroupDAO {

    private final Connection connection;

    public void insert(GroupEntity group) throws SQLException {
        try (var statement = connection.prepareCall("call prc_insert_group(?,?,?,?,?,?)")) {
            statement.registerOutParameter(6, LONG);
            statement.setLong(1, group.getMembers().getFirst().getId());
            statement.setLong(2, group.getProject().getId());
            statement.setString(3, group.getName());
            statement.setString(4, group.getCategory());
            statement.setString(5, group.getDescription());
            statement.execute();
            group.setId(statement.getLong(6));
        }
    }

}

package com.lp.board.persistence.dao.impl;

import com.lp.board.persistence.dao.AuthorDAO;
import com.lp.board.persistence.entity.AuthorEntity;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;

import static java.util.TimeZone.LONG;

@RequiredArgsConstructor
public class AuthorDAOImpl implements AuthorDAO {

    private final Connection connection;

    public void insert(AuthorEntity entity) throws SQLException {
        try (var call = connection.prepareCall("call prc_insert_author(?,?,?)")) {
            call.registerOutParameter(3, LONG);
            call.setString(1, entity.getName());
            call.setString(2, entity.getOccupation());
            call.execute();
            entity.setId(call.getLong(3));
        }
    }

}

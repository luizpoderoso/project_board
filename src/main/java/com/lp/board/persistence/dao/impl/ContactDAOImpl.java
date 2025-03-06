package com.lp.board.persistence.dao.impl;

import com.lp.board.persistence.dao.ContactDAO;
import com.lp.board.model.entity.ContactEntity;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;

import static java.util.TimeZone.LONG;

@RequiredArgsConstructor
public class ContactDAOImpl implements ContactDAO {

    private final Connection connection;

    public void insert(ContactEntity contact) throws SQLException {
        try (var statement = connection.prepareCall("call prc_insert_contact(?,?,?,?)")) {
            statement.registerOutParameter(4, LONG);
            statement.setString(1, contact.getType());
            statement.setString(2, contact.getLabel());
            statement.setLong(3, contact.getAuthor().getId());
            statement.execute();
            contact.setId(statement.getLong(4));
        }
    }

}

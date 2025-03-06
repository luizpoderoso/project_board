package com.lp.board.persistence.dao;

import com.lp.board.model.entity.ContactEntity;

import java.sql.SQLException;

public interface ContactDAO {

    public void insert(ContactEntity entity) throws SQLException;

}

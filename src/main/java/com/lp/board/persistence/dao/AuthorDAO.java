package com.lp.board.persistence.dao;

import com.lp.board.persistence.entity.AuthorEntity;

import java.sql.SQLException;

public interface AuthorDAO {

    public void insert(AuthorEntity entity) throws SQLException;

    public AuthorEntity getById(Long id) throws SQLException;

    public AuthorEntity getByIdWithDetails(Long id) throws SQLException;

}

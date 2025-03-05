package com.lp.board.persistence.dao;

import com.lp.board.persistence.entity.AuthorEntity;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;

import static java.util.TimeZone.LONG;

public interface AuthorDAO {
    
    public void insert(AuthorEntity entity) throws SQLException;

}

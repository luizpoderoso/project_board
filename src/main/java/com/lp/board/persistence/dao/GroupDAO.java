package com.lp.board.persistence.dao;

import com.lp.board.model.entity.GroupEntity;

import java.sql.SQLException;

public interface GroupDAO {

    public void insert(GroupEntity group) throws SQLException;

}

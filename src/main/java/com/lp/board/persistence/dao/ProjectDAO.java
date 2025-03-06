package com.lp.board.persistence.dao;

import com.lp.board.model.entity.ProjectEntity;

import java.sql.SQLException;

public interface ProjectDAO {

    public void insert(ProjectEntity project) throws SQLException;

}

package com.lp.board.persistence.dao;

import com.lp.board.model.entity.TaskEntity;

import java.sql.SQLException;

public interface TaskDAO {

    public void insert(TaskEntity task) throws SQLException;

}

package com.lp.board.service;

import com.lp.board.model.dto.AuthorDTO;
import com.lp.board.persistence.dao.impl.AuthorDAOImpl;
import com.lp.board.persistence.entity.AuthorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class AuthorService {

    @Autowired
    private final Connection connection;

    public void insertAuthor(AuthorDTO dto) throws SQLException {
        var authorDAO = new AuthorDAOImpl(connection);
        try {
            var entity = convertToEntity(dto);
            authorDAO.insert(entity);
            connection.commit();
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        }
    }

    private AuthorDTO convertToDTO(AuthorEntity entity) {
        var dto = new AuthorDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setOccupation(entity.getOccupation());
        return dto;
    }

    private AuthorEntity convertToEntity(AuthorDTO dto) {
        var entity = new AuthorEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setOccupation(dto.getOccupation());
        return entity;
    }

}

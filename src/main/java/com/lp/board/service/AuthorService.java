package com.lp.board.service;

import com.lp.board.model.dto.*;
import com.lp.board.model.entity.*;
import com.lp.board.model.mapper.AuthorMapper;
import com.lp.board.persistence.dao.ContactDAO;
import com.lp.board.persistence.dao.GroupDAO;
import com.lp.board.persistence.dao.ProjectDAO;
import com.lp.board.persistence.dao.TaskDAO;
import com.lp.board.persistence.dao.impl.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthorService {

    @Autowired
    private final Connection connection;

    @Autowired
    private final AuthorMapper mapper;

    public void insertAuthor(AuthorDTO dto) throws SQLException {
        var authorDAO = new AuthorDAOImpl(connection);
        var contactDAO = new ContactDAOImpl(connection);
        var projectDAO = new ProjectDAOImpl(connection);
        var groupDAO = new GroupDAOImpl(connection);
        var taskDAO = new TaskDAOImpl(connection);
        try {
            var entity = mapper.convertToEntity(dto);
            authorDAO.insert(entity);
            dto.setId(entity.getId());
            insertAuthorContacts(entity, contactDAO);
            insertAuthorProjects(entity, projectDAO, groupDAO, taskDAO);
            connection.commit();
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        }
    }

    public AuthorDTO getAuthorById(Long id) throws SQLException {
        var authorDAO = new AuthorDAOImpl(connection);
        var dto = new AuthorDTO();
        try {
            var entity = authorDAO.getById(id);
            dto = mapper.convertToDTO(entity);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dto;
    }

    public AuthorDTO getAuthorByIdWithDetails(Long id) throws SQLException {
        var authorDAO = new AuthorDAOImpl(connection);
        var dto = new AuthorDTO();
        try {
            var entity = authorDAO.getByIdWithDetails(id);
            dto = mapper.convertToDTO(entity);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dto;
    }


    private void insertAuthorContacts(AuthorEntity entity, ContactDAO contactDAO) throws SQLException {
        var contacts = entity.getContacts();
        for (var contact : contacts) {
            contact.setAuthor(entity);
            contactDAO.insert(contact);
        }
    }

    private void insertAuthorProjects
            (AuthorEntity entity, ProjectDAO projectDAO, GroupDAO groupDAO, TaskDAO taskDAO) throws SQLException {

        for (var project : entity.getProjects()) {
            if (project.getAuthors() == null) project.setAuthors(new ArrayList<>());
            project.getAuthors().add(entity);
            projectDAO.insert(project);

            if (project.getGroups() != null) {
                for (var group : project.getGroups()) {
                    if (group.getProject() == null) group.setProject(project);
                    if (group.getMembers() == null) group.setMembers(new ArrayList<>());
                    group.getMembers().add(entity);
                    groupDAO.insert(group);

                    if (group.getTasks() != null) {
                        for (var task : group.getTasks()) {
                            if (task.getAuthors() == null) task.setAuthors(new ArrayList<>());
                            if (task.getGroups() == null) task.setGroups(new ArrayList<>());
                            task.getAuthors().add(entity);
                            task.getGroups().add(group);
                            taskDAO.insert(task);
                        }
                    }
                }
            }
        }

    }

}

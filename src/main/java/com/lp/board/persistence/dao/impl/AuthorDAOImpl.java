package com.lp.board.persistence.dao.impl;

import com.lp.board.persistence.dao.AuthorDAO;
import com.lp.board.persistence.entity.*;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.TimeZone.LONG;

@RequiredArgsConstructor
public class AuthorDAOImpl implements AuthorDAO {

    private final Connection connection;

    public void insert(AuthorEntity entity) throws SQLException {
        try (var statement = connection.prepareCall("call prc_insert_author(?,?,?)")) {
            statement.registerOutParameter(3, LONG);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getOccupation());
            statement.execute();
            entity.setId(statement.getLong(3));
        }
    }

    public AuthorEntity getById(Long id) throws SQLException {
        var entity = new AuthorEntity();
        try (var statement = connection.prepareCall("call prc_get_by_id_author(?)")) {
            statement.setLong(1, id);
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            if (resultSet.next()) {
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setOccupation(resultSet.getString("occupation"));
            }
        }
        return entity;
    }

    public AuthorEntity getByIdWithDetails(Long id) throws SQLException {
        var entity = new AuthorEntity();
        try (var statement = connection.prepareCall("call prc_get_by_id_with_details_author(?)")) {
            statement.setLong(1, id);
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            if (resultSet.next()) {
                entity.setId(resultSet.getLong("aut_id"));
                entity.setName(resultSet.getString("aut_name"));
                entity.setOccupation(resultSet.getString("aut_occupation"));
                entity.setContacts(getAuthorContacts(resultSet));
                entity.setProjects(getAuthorProjects(resultSet));
                entity.setGroups(getAuthorGroups(resultSet));
                entity.setTasks(getAuthorTasks(resultSet));
            }
        }
        return entity;
    }

    private List<ContactEntity> getAuthorContacts(ResultSet resultSet) throws SQLException {
        try {
            var contacts = new ArrayList<ContactEntity>();
            var csId = Arrays.stream(resultSet.getString("cs_id").split(","))
                    .map(Long::valueOf).toList();
            var csType = Arrays.stream(resultSet.getString("cs_type").split(",")).toList();
            var csLabel = Arrays.stream(resultSet.getString("cs_label").split(",")).toList();
            for (var i = 0; i < csId.toArray().length; i++) {
                var contact = new ContactEntity();
                contact.setId(csId.get(i));
                contact.setType(csType.get(i));
                contact.setLabel(csLabel.get(i));
                contacts.add(contact);
            }
            return contacts;
        } catch (NullPointerException ex) {
            System.out.printf("%s não possui contatos.\n", resultSet.getString("aut_name"));
            return null;
        }
    }

    private List<ProjectEntity> getAuthorProjects(ResultSet resultSet) throws SQLException {
        try {
            var projects = new ArrayList<ProjectEntity>();
            var psId = Arrays.stream(resultSet.getString("ps_id").split(","))
                    .map(Long::valueOf).toList();
            var psName = Arrays.stream(resultSet.getString("ps_name").split(",")).toList();
            var psCategory = Arrays.stream(resultSet.getString("ps_category").split(",")).toList();
            var psDescription = Arrays.stream(resultSet.getString("ps_description").split(",")).toList();
            for (var i = 0; i < psId.toArray().length; i++) {
                var project = new ProjectEntity();
                project.setId(psId.get(i));
                project.setName(psName.get(i));
                project.setCategory(psCategory.get(i));
                project.setDescription(psDescription.get(i));
                projects.add(project);
            }
            return projects;
        } catch (NullPointerException ex) {
            System.out.printf("%s não possui projetos.\n", resultSet.getString("aut_name"));
            return null;
        }
    }

    private List<GroupEntity> getAuthorGroups(ResultSet resultSet) throws SQLException {
        try {
            var groups = new ArrayList<GroupEntity>();
            var gsId = Arrays.stream(resultSet.getString("gs_id").split(","))
                    .map(Long::valueOf).toList();
            var gsName = Arrays.stream(resultSet.getString("gs_name").split(",")).toList();
            var gsCategory = Arrays.stream(resultSet.getString("gs_category").split(",")).toList();
            var gsDescription = Arrays.stream(resultSet.getString("gs_description").split(",")).toList();
            for (var i = 0; i < gsId.toArray().length; i++) {
                var group = new GroupEntity();
                group.setId(gsId.get(i));
                group.setName(gsName.get(i));
                group.setCategory(gsCategory.get(i));
                group.setDescription(gsDescription.get(i));
                groups.add(group);
            }
            return groups;
        } catch (NullPointerException ex) {
            System.out.printf("%s não possui tarefas.\n", resultSet.getString("aut_name"));
            return null;
        }
    }

    private List<TaskEntity> getAuthorTasks(ResultSet resultSet) throws SQLException {
        try {
            var tasks = new ArrayList<TaskEntity>();
            var tsId = Arrays.stream(resultSet.getString("ts_id").split(","))
                    .map(Long::valueOf).toList();
            var tsName = Arrays.stream(resultSet.getString("ts_name").split(",")).toList();
            var tsResume = Arrays.stream(resultSet.getString("ts_resume").split(",")).toList();
            var tsDescription = Arrays.stream(resultSet.getString("ts_description").split(",")).toList();
            for (var i = 0; i < tsId.toArray().length; i++) {
                var task = new TaskEntity();
                task.setId(tsId.get(i));
                task.setName(tsName.get(i));
                task.setResume(tsResume.get(i));
                task.setDescription(tsDescription.get(i));
                tasks.add(task);
            }
            return tasks;
        } catch (NullPointerException ex) {
            System.out.printf("%s não possui tarefas.\n", resultSet.getString("aut_name"));
            return null;
        }
    }
}

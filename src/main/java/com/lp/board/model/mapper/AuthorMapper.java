package com.lp.board.model.mapper;

import com.lp.board.model.dto.*;
import com.lp.board.model.entity.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AuthorMapper {

    public AuthorEntity convertToEntity(AuthorDTO authorDTO) {
        var authorEntity = new AuthorEntity();
        authorEntity.setId(authorDTO.getId());
        authorEntity.setName(authorDTO.getName());
        authorEntity.setOccupation(authorDTO.getOccupation());

        if (authorDTO.getContacts() != null) {
            var contactEntities = new ArrayList<ContactEntity>();
            authorDTO.getContacts().forEach(c -> {
                var contactEntity = new ContactEntity();
                contactEntity.setId(c.getId());
                contactEntity.setType(c.getType());
                contactEntity.setLabel(c.getLabel());
                contactEntities.add(contactEntity);
            });
            authorEntity.setContacts(contactEntities);
        }

        if (authorDTO.getProjects() != null) {
            var projectEntities = new ArrayList<ProjectEntity>();
            authorDTO.getProjects().forEach(p -> {

                var projectEntity = new ProjectEntity();
                projectEntity.setId(p.getId());
                projectEntity.setName(p.getName());
                projectEntity.setCategory(p.getCategory());
                projectEntity.setDescription(p.getDescription());

                if (p.getGroups() != null) {
                    var groupEntities = new ArrayList<GroupEntity>();
                    p.getGroups().forEach(g -> {

                        var groupEntity = new GroupEntity();
                        groupEntity.setId(g.getId());
                        groupEntity.setName(g.getName());
                        groupEntity.setCategory(g.getCategory());
                        groupEntity.setDescription(g.getDescription());

                        if (g.getTasks() != null) {
                            var taskEntities = new ArrayList<TaskEntity>();

                            g.getTasks().forEach(t -> {
                                var taskEntity = new TaskEntity();
                                taskEntity.setId(t.getId());
                                taskEntity.setName(t.getName());
                                taskEntity.setResume(t.getResume());
                                taskEntity.setDescription(t.getDescription());

                                taskEntities.add(taskEntity);
                            });

                            groupEntity.setTasks(taskEntities);
                        }

                        groupEntities.add(groupEntity);

                    });
                    projectEntity.setGroups(groupEntities);
                }

                projectEntities.add(projectEntity);

            });
            authorEntity.setProjects(projectEntities);
        }

        if (authorDTO.getGroups() != null) {
            var groupEntities = new ArrayList<GroupEntity>();
            authorDTO.getGroups().forEach(g -> {
                var groupEntity = new GroupEntity();
                groupEntity.setId(g.getId());
                groupEntity.setName(g.getName());
                groupEntity.setCategory(g.getCategory());
                groupEntity.setDescription(g.getDescription());
                groupEntities.add(groupEntity);
            });
            authorEntity.setGroups(groupEntities);
        }

        if (authorDTO.getTasks() != null) {
            var taskEntities = new ArrayList<TaskEntity>();
            authorDTO.getTasks().forEach(t -> {
                var taskEntity = new TaskEntity();
                taskEntity.setId(t.getId());
                taskEntity.setName(t.getName());
                taskEntity.setResume(t.getResume());
                taskEntity.setDescription(t.getDescription());
                taskEntities.add(taskEntity);
            });
            authorEntity.setTasks(taskEntities);
        }

        return authorEntity;
    }

    public AuthorDTO convertToDTO(AuthorEntity entity) {
        var authorDTO = new AuthorDTO();
        authorDTO.setId(entity.getId());
        authorDTO.setName(entity.getName());
        authorDTO.setOccupation(entity.getOccupation());
        if (entity.getContacts() != null) {
            var contactsDTO = new ArrayList<ContactDTO>();
            entity.getContacts().forEach(c -> {
                var contactDTO = new ContactDTO();
                contactDTO.setId(c.getId());
                contactDTO.setType(c.getType());
                contactDTO.setLabel(c.getLabel());
                contactsDTO.add(contactDTO);
            });
            authorDTO.setContacts(contactsDTO);
        }
        if (entity.getProjects() != null) {
            var projectsDTO = new ArrayList<ProjectDTO>();
            entity.getProjects().forEach(p -> {
                var projectDTO = new ProjectDTO();
                projectDTO.setId(p.getId());
                projectDTO.setName(p.getName());
                projectDTO.setCategory(p.getCategory());
                projectDTO.setDescription(p.getDescription());
                projectsDTO.add(projectDTO);
            });
            authorDTO.setProjects(projectsDTO);
        }
        if (entity.getGroups() != null) {
            var groupsDTO = new ArrayList<GroupDTO>();
            entity.getGroups().forEach(g -> {
                var groupDTO = new GroupDTO();
                groupDTO.setId(g.getId());
                groupDTO.setName(g.getName());
                groupDTO.setCategory(g.getCategory());
                groupDTO.setDescription(g.getDescription());
                groupsDTO.add(groupDTO);
            });
            authorDTO.setGroups(groupsDTO);
        }
        if (entity.getTasks() != null) {
            var tasksDTO = new ArrayList<TaskDTO>();
            entity.getTasks().forEach(t -> {
                var taskDTO = new TaskDTO();
                taskDTO.setId(t.getId());
                taskDTO.setName(t.getName());
                taskDTO.setResume(t.getResume());
                taskDTO.setDescription(t.getDescription());
                tasksDTO.add(taskDTO);
            });
            authorDTO.setTasks(tasksDTO);
        }
        return authorDTO;
    }

}

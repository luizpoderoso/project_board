package com.lp.board.controller;

import com.lp.board.persistence.entity.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/authors")
public class AuthorRestController {

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        var contact = new Contact();
        contact.setId(1L);
        contact.setType("email");
        contact.setLabel("lpoderoso@icloud.com");
        var task = new Task();
        task.setId(1L);
        task.setName("Back-end");
        task.setResume("Desenvolvimento");
        task.setDescription("Desenvolvimento do modelo de negócios do projeto.");
        var group = new Group();
        group.setId(1L);
        group.setName("Grupo de Desenvolvimento Back-end");
        group.setCategory("Desenvolvimento");
        group.setDescription("Grupo focado em desenvolvimento back-end.");
        var project = new Project();
        project.setId(1L);
        project.setName("Board");
        project.setCategory("Estudo");
        project.setDescription("Projeto para testar aprendizados em Spring Boot e em Java como um todo.");
        var entities = new ArrayList<Author>();
        var entity = new Author();
        contact.setAuthor(entity);
        entity.setId(1L);
        entity.setName("Luiz Poderoso");
        entity.setOccupation("Desenvolvedor");
        entity.getContacts().add(contact);
        project.getAuthors().add(entity);
        project.getGroups().add(group);
        project.getTasks().add(task);
        entity.getProjects().add(project);
        group.setProject(project);
        group.getMembers().add(entity);
        group.getTasks().add(task);
        entity.getGroups().add(group);
        task.setProject(project);
        task.getAuthors().add(entity);
        task.getGroups().add(group);
        entity.getTasks().add(task);
        entities.add(entity);
        return ResponseEntity.ok(entities);
    }

}

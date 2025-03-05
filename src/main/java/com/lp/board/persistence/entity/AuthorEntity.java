package com.lp.board.persistence.entity;

import lombok.Data;

import java.util.List;

@Data
public class AuthorEntity {

    private Long id;

    private String name;

    private String occupation;

    private List<ContactEntity> contacts;

    private List<ProjectEntity> projects;

    private List<GroupEntity> groups;

    private List<TaskEntity> tasks;

}

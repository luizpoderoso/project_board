package com.lp.board.persistence.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class TaskEntity {

    private Long id;

    private String name;

    private String resume;

    private String description;

    @ToString.Exclude
    private List<AuthorEntity> authors;

    @ToString.Exclude
    private List<GroupEntity> groups;

    @ToString.Exclude
    private ProjectEntity project;

}

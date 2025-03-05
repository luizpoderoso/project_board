package com.lp.board.persistence.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class ProjectEntity {

    private Long id;

    private String name;

    private String category;

    private String description;

    @ToString.Exclude
    private List<AuthorEntity> authors;

    private List<GroupEntity> groups;

    private List<TaskEntity> tasks;

}

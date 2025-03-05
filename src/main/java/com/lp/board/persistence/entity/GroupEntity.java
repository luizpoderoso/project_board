package com.lp.board.persistence.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class GroupEntity {

    private Long id;

    private String name;

    private String category;

    private String description;

    @ToString.Exclude
    private ProjectEntity project;

    @ToString.Exclude
    private List<AuthorEntity> members;

    private List<TaskEntity> tasks;

}

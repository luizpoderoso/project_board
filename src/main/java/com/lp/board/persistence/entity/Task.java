package com.lp.board.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
public class Task {

    private Long id;

    private String name;

    private String resume;

    private String description;

    @ToString.Exclude
    @JsonBackReference
    private List<Author> authors = new ArrayList<>();

    @ToString.Exclude
    @JsonBackReference
    private List<Group> groups = new ArrayList<>();

    @ToString.Exclude
    @JsonBackReference
    private Project project;

}

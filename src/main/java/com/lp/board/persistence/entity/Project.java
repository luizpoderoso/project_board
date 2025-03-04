package com.lp.board.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
public class Project {

    private Long id;

    private String name;

    private String category;

    private String description;

    @ToString.Exclude
    @JsonBackReference
    private List<Author> authors = new ArrayList<>();

    @JsonManagedReference
    private List<Group> groups = new ArrayList<>();

    @JsonManagedReference
    private List<Task> tasks = new ArrayList<>();

}

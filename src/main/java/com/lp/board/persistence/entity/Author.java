package com.lp.board.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Author {

    private Long id;

    private String name;

    private String occupation;

    @JsonManagedReference
    private List<Contact> contacts = new ArrayList<>();

    @JsonManagedReference
    private List<Project> projects = new ArrayList<>();

    @JsonManagedReference
    private List<Group> groups = new ArrayList<>();

    @JsonManagedReference
    private List<Task> tasks = new ArrayList<>();

}

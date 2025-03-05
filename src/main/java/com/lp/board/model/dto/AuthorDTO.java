package com.lp.board.model.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class AuthorDTO {

    private Long id;

    private String name;

    private String occupation;

    private List<ContactDTO> contacts = new ArrayList<>();

    private List<ProjectDTO> projects = new ArrayList<>();

    private List<GroupDTO> groups = new ArrayList<>();

    private List<TaskDTO> tasks = new ArrayList<>();

}

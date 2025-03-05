package com.lp.board.model.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class GroupDTO {

    private Long id;

    private String name;

    private String category;

    private String description;

    @ToString.Exclude
    private ProjectDTO project;

    @ToString.Exclude
    private List<AuthorDTO> members = new ArrayList<>();

    private List<TaskDTO> tasks = new ArrayList<>();

}

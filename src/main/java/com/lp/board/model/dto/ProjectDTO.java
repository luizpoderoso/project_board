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
public class ProjectDTO {

    private Long id;

    private String name;

    private String category;

    private String description;

    @ToString.Exclude
    private List<AuthorDTO> authors = new ArrayList<>();

    private List<GroupDTO> groups = new ArrayList<>();

    private List<TaskDTO> tasks = new ArrayList<>();

}

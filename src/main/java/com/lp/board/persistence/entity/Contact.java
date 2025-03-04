package com.lp.board.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

@Data
public class Contact {

    private Long id;

    private String type;

    private String label;

    @ToString.Exclude
    @JsonBackReference
    private Author author;

}

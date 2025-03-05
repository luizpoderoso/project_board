package com.lp.board.model.dto;

import lombok.ToString;

public class ContactDTO {

    private Long id;

    private String type;

    private String label;

    @ToString.Exclude
    private AuthorDTO author;

}

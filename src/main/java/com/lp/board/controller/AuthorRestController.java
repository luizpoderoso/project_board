package com.lp.board.controller;

import com.lp.board.model.dto.AuthorDTO;
import com.lp.board.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(path = "/authors")
public class AuthorRestController {

    @Autowired
    private AuthorService service;

    @PostMapping
    public ResponseEntity<AuthorDTO> postAuthor(@RequestBody AuthorDTO dto) throws SQLException {
        service.insertAuthor(dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AuthorDTO> getAuthor(@PathVariable Long id) throws SQLException {
        var dto = service.getAuthorById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(path = "/{id}/details")
    public ResponseEntity<AuthorDTO> getAuthorWithDetails(@PathVariable Long id) throws SQLException {
        var dto = service.getAuthorByIdWithDetails(id);
        return ResponseEntity.ok(dto);
    }

}

package com.epam.esm.controller;

import domain.tag.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.esm.service.tag.TagService;

import java.util.UUID;

@RestController
@RequestMapping("/api/tag")
public class TagController {

    private  TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(
            @RequestBody Tag tag
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(tagService.create(tag));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<?> get(
            @RequestParam UUID id
    ){
        return ResponseEntity.ok(tagService.get(id));
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(tagService.getAll());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(
            @RequestParam UUID id
    ){
        return ResponseEntity.ok(tagService.delete(id));
    }
}

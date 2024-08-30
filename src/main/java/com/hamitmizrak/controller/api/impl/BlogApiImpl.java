package com.hamitmizrak.controller.api.impl;

import com.hamitmizrak.assist.FrontendUrl;
import com.hamitmizrak.business.dto.BlogDto;
import com.hamitmizrak.business.services.IBlogServices;
import com.hamitmizrak.controller.api.IBlogApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// API
@RestController
@CrossOrigin(origins = FrontendUrl.REACT_URL) // http://localhost:3000
@RequestMapping("/blog/api/v1")
public class BlogApiImpl implements IBlogApi<BlogDto> {

    // Injection
    private final IBlogServices iBlogServices;

    // CREATE
    // http://localhost:4444/blog/api/v1/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> blogApiCreate(@Valid @RequestBody BlogDto categoryDto) {
        return ResponseEntity.ok(iBlogServices.blogServiceCreate(categoryDto));
    }

    // LIST
    // http://localhost:4444/blog/api/v1/list
    @Override
    @GetMapping(value="/list")
    public ResponseEntity<List<BlogDto>> blogApiList() {
        return ResponseEntity.status(HttpStatus.OK).body(iBlogServices.blogServiceList());
    }

    // FIND
    // http://localhost:4444/blog/api/v1/find/1
    @Override
    @GetMapping(value="/find/{id}")
    public ResponseEntity<?> blogApiFindById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(200).body(iBlogServices.blogServiceFindById(id));
    }

    // UPDATE
    // http://localhost:4444/blog/api/v1/update/1
    @Override
    @PutMapping(value="/update/{id}")
    public ResponseEntity<?> blogApiUpdate(@PathVariable(name = "id") Long id, @Valid @RequestBody BlogDto categoryDto) {
        return ResponseEntity.ok().body(iBlogServices.blogServiceUpdate(id,categoryDto));
    }

    // DELETE BY ID
    // http://localhost:4444/blog/api/v1/delete/1
    @Override
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<?> blogApiDeleteById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(iBlogServices.blogServiceDeleteById(id),HttpStatus.OK);
    }

    ///////////////////////////////////////////////////////
    // ALL DELETE
    @Override
    public ResponseEntity<String> blogApiAllDelete() {
        return null;
    }

    // SPEED DATA
    @Override
    public ResponseEntity<List<BlogDto>> blogApiSpeedData(Long key) {
        return null;
    }





























} //end class

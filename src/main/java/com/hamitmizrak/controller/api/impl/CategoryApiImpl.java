package com.hamitmizrak.controller.api.impl;

import com.hamitmizrak.assist.FrontendUrl;
import com.hamitmizrak.business.dto.CategoryDto;
import com.hamitmizrak.business.services.ICategoryServices;
import com.hamitmizrak.controller.api.ICategoryApi;
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
@RequestMapping("/category/api/v1")
public class CategoryApiImpl implements ICategoryApi<CategoryDto> {

    // Injection
    private final ICategoryServices iCategoryServices;

    // CREATE
    // http://localhost:4444/category/api/v1/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> categoryApiCreate(@Valid @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(iCategoryServices.categoryServiceCreate(categoryDto));
    }

    // LIST
    // http://localhost:4444/category/api/v1/list
    @Override
    @GetMapping(value="/list")
    public ResponseEntity<List<CategoryDto>> categoryApiList() {
        return ResponseEntity.status(HttpStatus.OK).body(iCategoryServices.categoryServiceList());
    }

    // FIND
    // http://localhost:4444/category/api/v1/find/1
    @Override
    @GetMapping(value="/find/{id}")
    public ResponseEntity<?> categoryApiFindById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(200).body(iCategoryServices.categoryServiceFindById(id));
    }

    // UPDATE
    // http://localhost:4444/category/api/v1/update/1
    @Override
    @PutMapping(value="/update/{id}")
    public ResponseEntity<?> categoryApiUpdate(@PathVariable(name = "id") Long id, @Valid @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok().body(iCategoryServices.categoryServiceUpdate(id,categoryDto));
    }

    // DELETE BY ID
    // http://localhost:4444/category/api/v1/delete/1
    @Override
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<?> categoryApiDeleteById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(iCategoryServices.categoryServiceDeleteById(id),HttpStatus.OK);
    }

    ///////////////////////////////////////////////////////
    // ALL DELETE
    // http://localhost:4444/category/api/v1/delete/all
    @Override
    @DeleteMapping(value="/delete/all")
    public ResponseEntity<String> categoryApiAllDelete() {
        return ResponseEntity.ok(iCategoryServices.categoryDeleteAll());
    }

    // SPEED DATA
    // http://localhost:4444/category/api/v1/speed/10
    @Override
    @GetMapping(value="/speed/{id}")
    public ResponseEntity<String> categoryApiSpeedData(@PathVariable(name = "id")  Integer data) {
        return  ResponseEntity.ok(iCategoryServices.categorySpeedData(data));
    }

} //end class

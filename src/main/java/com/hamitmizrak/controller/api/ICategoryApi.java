package com.hamitmizrak.controller.api;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICategoryApi <D> {

    // C R U D
    // CREATE
    public ResponseEntity<?>  categoryApiCreate(D d);

    // LIST
    public ResponseEntity<List<D>>  categoryApiList();

    // FIND BY
    public ResponseEntity<?>  categoryApiFindById(Long id);

    // UPDATE
    public ResponseEntity<?>  categoryApiUpdate(Long id,D d);

    // DELETE
    public ResponseEntity<?>  categoryApiDeleteById(Long id);

    //////////////////////////////////////
    // ALL DELETE
    public ResponseEntity<String> categoryApiAllDelete();

    // SPEED DATA
    public ResponseEntity<String> categoryApiSpeedData(Integer data);
}

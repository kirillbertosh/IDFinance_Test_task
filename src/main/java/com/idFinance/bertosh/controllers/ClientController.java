package com.idFinance.bertosh.controllers;

import com.idFinance.bertosh.model.Request;
import com.idFinance.bertosh.repositories.RequestRepository;
import com.idFinance.bertosh.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/client/requests")
public class ClientController {

    @Autowired
    private RequestRepository repository;
    @Autowired
    private ClientService service;

    @GetMapping("/status/{id}")
    public ResponseEntity findRequest(@PathVariable Long id) {
        Optional<Request> request = repository.findById(id);
        if (request.isPresent()) {
            return new ResponseEntity<>(request.get().getStatus(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Request request) {
        request = service.save(request);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }
}

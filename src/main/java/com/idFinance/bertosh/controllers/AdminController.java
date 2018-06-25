package com.idFinance.bertosh.controllers;

import com.idFinance.bertosh.model.Request;
import com.idFinance.bertosh.repositories.RequestRepository;
import com.idFinance.bertosh.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/requests")
public class AdminController {

    @Autowired
    private RequestRepository repository;
    @Autowired
    private AdminService service;

    @GetMapping("/all")
    public ResponseEntity findAll() {
        List<Request> requestList = repository.findAll();
        if (requestList.size() == 0) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(requestList, HttpStatus.OK);
        }
    }

    @GetMapping("/completed")
    public ResponseEntity findCompletedRequests() {
        List<Request> requestList = repository.findByStatusCompleted();
        if (requestList.size() == 0) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(requestList, HttpStatus.OK);
        }
    }

    @GetMapping("/refused")
    public ResponseEntity findRefusedRequests() {
        List<Request> requestList = repository.findByStatusRefused();
        if (requestList.size() == 0) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(requestList, HttpStatus.OK);
        }
    }

    @PostMapping("/complete/{id}")
    public ResponseEntity completeRequest(@PathVariable Long id) {
        Request request = service.completeRequest(id);
        if (request != null) {
            return new ResponseEntity<>(request, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/refuse/{id}")
    public ResponseEntity refuseRequest(@PathVariable Long id) {
        Request request = service.refuseRequest(id);
        if (request != null) {
            return new ResponseEntity<>(request, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
